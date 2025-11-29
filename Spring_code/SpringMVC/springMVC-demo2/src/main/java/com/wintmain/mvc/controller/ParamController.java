package com.wintmain.mvc.controller;

import com.wintmain.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-06 9:31:34
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        String uname = request.getParameter("username");
        String upwd = request.getParameter("password");
        System.out.println("uname:"+uname+",upwd:"+upwd);
        return "success";
    }

//    @RequestMapping("/testParam")
//    public String testParam(String username,String password){
//        System.out.println("username:"+username+",password:"+password);
//        return "success";
//    }
    @RequestMapping("/testParam") public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "moren") String username,
            String password,
            String[] hobbies,
            @RequestHeader("Host") String host,
            @CookieValue("JSESSIONID") String JESSIONID){
        //多请求参数中出现多个同名的参数，可以在控制器方法的形参位置设置字符串类型或数组接收
        //字符串类型用，拼接的
        System.out.println("username:"+username+",password:"+password+",hobbies:"+ Arrays.toString(hobbies));
        System.out.println("host:"+host);
        System.out.println("JESSIONID:"+JESSIONID);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testpojo(User user){
        System.out.println(user);

        return "success";
    }
}
