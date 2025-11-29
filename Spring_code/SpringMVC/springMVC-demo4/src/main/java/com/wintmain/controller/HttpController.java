package com.wintmain.controller;

import com.wintmain.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-13 14:39:45
 */
@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("RequestBody:"+requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //当前requestEnity表示整个请求报文的信息
        System.out.println("请求头："+requestEntity.getHeaders());
        System.out.println("请求体："+requestEntity.getBody());
        System.out.println("请求地址："+requestEntity.getUrl());
        System.out.println("请求类型："+requestEntity.getType());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello,response.From HttpServletResponse");
    }

    @RequestMapping(value = "/testResponseBody",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody(){
        return "成功";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001, "admin", "123456", 23, "男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }
}
