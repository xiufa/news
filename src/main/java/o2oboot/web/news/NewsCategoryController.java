package o2oboot.web.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import o2oboot.dto.NewsCategoryExecution;
import o2oboot.entity.NewsCategory;
import o2oboot.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/newsCategory")
public class NewsCategoryController {
    @Autowired
    private NewsCategoryService newsCategoryService;

    @RequestMapping(value = "/addNewsCategory",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> addNewsCategory(HttpServletRequest request){
        Long newCategoryId=Long.valueOf(request.getParameter("newsCategoryId"));
        String newsCategoryName=request.getParameter("newsCategoryID");
        Integer priority= Integer.valueOf(request.getParameter("priority"));
        String parent=request.getParameter("parent");
        Map<String,Object> map=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            NewsCategory newsCategory=objectMapper.readValue(parent, NewsCategory.class);
            NewsCategory category=new NewsCategory(newCategoryId,newsCategoryName,priority,newsCategory);
            newsCategoryService.addNewsCategory(category);
            map.put("success",true);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("errMsg",e.getMessage());
            return map;
        }
    }

    @RequestMapping(value = "/deleteNewsCategoryById",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> deleteNewsCategoryById(HttpServletRequest request){
        Long newCategoryId=Long.valueOf(request.getParameter("newsCategoryId"));
        NewsCategoryExecution newsCategoryExecution=newsCategoryService.deleteNewsCategoryById(newCategoryId);
        Map<String,Object> map=new HashMap<>();
        if(newsCategoryExecution.getState()==1){
            map.put("success",true);
        }
        else {
            map.put("success",false);
            map.put("errMsg",newsCategoryExecution.getStateInfo());
        }
        return map;
    }

    @RequestMapping(value = "/queryNewsCategoryByParent",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryNewsCategoryByParent(HttpServletRequest request){
        String parent=request.getParameter("parent");
        Map<String,Object> map=new HashMap<>();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            NewsCategory newsCategory=objectMapper.readValue(parent, NewsCategory.class);
            NewsCategoryExecution newsCategoryExecution=newsCategoryService.queryNewsCategoryByParent(newsCategory);
            map.put("success",true);
            map.put("newsCategory",newsCategoryExecution.getNewsList());
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("errMsg",e.getMessage());
            return map;
        }
    }
}
