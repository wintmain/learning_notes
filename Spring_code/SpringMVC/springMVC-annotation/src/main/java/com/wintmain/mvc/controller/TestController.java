package com.wintmain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-15 13:14:10
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String testController(){
        System.out.println("open index");
        return "index";
    }

    @RequestMapping("/testHello")
    public String testHello(){
        System.out.println("open hello");
        return "hello";
    }
}
