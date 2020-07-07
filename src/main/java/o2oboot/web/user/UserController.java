package o2oboot.web.user;

import o2oboot.entity.User;
import o2oboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkUserEmail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkUserEmail (HttpServletRequest request){
        String userId=request.getParameter("userId");

        int s = userService.checkUserEmail(userId);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "/userSignUp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> userSignUp (HttpServletRequest request){
        Long userId=userService.queryMaxUserId()+1;
        String email=request.getParameter("email");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");

        User user=new User(userId,userName,password,email);
        int s=userService.addUser(user);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "/userSignIn",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> userSignIn (HttpServletRequest request){
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        int s=userService.checkUserSingIn(email,password);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "/userDetail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> userDetail (HttpServletRequest request){
        Long userId= Long.valueOf(request.getParameter("userId"));

        User user=userService.getUserDetail(userId);
        List<User> list = new ArrayList<>();
        list.add(user);
        Map<String,Object> map = new HashMap<>();
        map.put("userDetail",list);
        return map;
    }

    @RequestMapping(value = "/modifyUser",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> modifyUser (HttpServletRequest request){
        Long userId= Long.valueOf(request.getParameter("userId"));
        String email=request.getParameter("email");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");

        User user=new User(userId,userName,password,email);
        int s=userService.modifyUser(user);
        Map<String,Object> map = new HashMap<>();
        if(s<1){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return map;
    }
}
