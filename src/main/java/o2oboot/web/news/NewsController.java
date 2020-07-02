package o2oboot.web.news;

import o2oboot.dto.NewsExecution;
import o2oboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/index")
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


}
