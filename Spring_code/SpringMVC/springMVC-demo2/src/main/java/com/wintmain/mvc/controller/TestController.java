package com.wintmain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-03 15:13:36
 */

@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

//    @RequestMapping("/param")
    @RequestMapping("/")
    public String param(){
        return "test_param";
    }

}
