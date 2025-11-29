package com.wintmain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-05 13:32:48
 */

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot";
    }
}
