package o2oboot.web.news;

import o2oboot.dto.NewsExecution;
import o2oboot.entity.News;
import o2oboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/getAllNews")
    @ResponseBody
    public Map<String,Object> getAllNews(@RequestParam("pageIndex") int pageIndex,@RequestParam("pageSize") int pageSize){
        Map<String,Object> map=new HashMap<>();
        NewsExecution newsExecution=newsService.getAllNewsList((pageIndex > 0) ? (pageIndex-1)*pageSize : 0,pageSize);
        if(newsExecution.getState()==1){
            map.put("success",true);
            map.put("newsList",newsExecution.getNewsList());
        }else {
            map.put("success",false);
            map.put("errMsg",newsExecution.getStateInfo());
        }
        return map;
    }
//通过类型搜索
    @RequestMapping("/getNewsByCategory")
    @ResponseBody
    public Map<String,Object> getNewsListByCategory(@RequestParam("pageIndex") int pageIndex,@RequestParam("pageSize") int pageSize,HttpServletRequest request){
        Long newCategoryId=Long.valueOf(request.getParameter("newsCategoryId"));
        NewsExecution newsExecution=newsService.getNewsListByNewsCategory(newCategoryId,(pageIndex > 0) ? (pageIndex-1)*pageSize : 0,pageSize);
        Map<String,Object> map=new HashMap<>();
        if(newsExecution.getState()==1){
            map.put("success",true);
            map.put("newsList",newsExecution.getNewsList());
        }else {
            map.put("success",false);
            map.put("errMsg",newsExecution.getStateInfo());
        }
        return map;
    }
//通过名称搜索
    @RequestMapping("/getNewsByNewsName")
    @ResponseBody
    public Map<String,Object> getNewsListByNewsName(@RequestParam("pageIndex") int pageIndex,@RequestParam("pageSize") int pageSize,HttpServletRequest request){
        String newsName=request.getParameter("newsName");
        NewsExecution newsExecution=newsService.getNewsListByName(newsName,(pageIndex > 0) ? (pageIndex-1)*pageSize : 0,pageSize);
        Map<String,Object> map=new HashMap<>();
        if(newsExecution.getState()==1){
            map.put("success",true);
            map.put("newsList",newsExecution.getNewsList());
        }else {
            map.put("success",false);
            map.put("errMsg",newsExecution.getStateInfo());
        }
        return map;
    }
    //获取某条新闻详细信息

    @RequestMapping(value="/getNewsDetail",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getNewsById(HttpServletRequest request){
        Long newsId= Long.valueOf(request.getParameter("newsId"));
        Map<String,Object> map=new HashMap<>();
        News news=newsService.getNewsById(newsId);
        if(news!=null) {
            List<News> list = new ArrayList<>();
            list.add(news);
            map.put("success",true);
            map.put("news",list);
        }else{
            map.put("success",false);
        }
        return map;
    }
}
