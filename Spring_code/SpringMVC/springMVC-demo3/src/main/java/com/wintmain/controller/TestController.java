package com.wintmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-08 11:54:48
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

//    @RequestMapping("/test_view")
//    public String testview(){
//        return "test_view";
//    }
}
