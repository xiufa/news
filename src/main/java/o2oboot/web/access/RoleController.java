package o2oboot.web.access;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import o2oboot.entity.News;
import o2oboot.entity.access.Access;
import o2oboot.entity.access.Role;
import o2oboot.service.AccessService;
import o2oboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ac")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/addRole")
    @ResponseBody
    public Map<String, Object> addRole(@RequestParam("roleStr") String roleStr, HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        try {
            Role role = objectMapper.readValue(roleStr, Role.class);
            int res = roleService.addRole(role);
            if (res < 1) {
                map.put("success", false);
            } else {
                map.put("success", true);
            }

        } catch (Exception e) {
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public Map<String,Object> roleList(){
        Map<String,Object> map=new HashMap<>();
        List<Role> list=new LinkedList<>();

        list=roleService.queryAllRole();
        if(list.size()!=0){
            map.put("success",true);
            map.put("roleList",list);
        }else{
            map.put("success",false);
        }
        return map;


    }

    @RequestMapping("/deleteRole")
    @ResponseBody
    public Map<String,Object> deleteRole(HttpServletRequest request){
        Long newsId= Long.valueOf(request.getParameter("roleId"));
        Map<String,Object> map=new HashMap<>();
        int s=roleService.deleteRole(newsId);
        if(s<1){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }


}