package com.wintmain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-04 14:52:53
 */

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(
            value = {"/testRequestMapping","/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success(){
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @RequestMapping(
            value = {"/testRequest", "/t"}
            ,method = {RequestMethod.GET, RequestMethod.POST}
            ,params = {"username","password!=123456"}
    )
    public String testRequestMapping(){
        return "success";
    }

    @RequestMapping("/a?a/testAnt")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}
