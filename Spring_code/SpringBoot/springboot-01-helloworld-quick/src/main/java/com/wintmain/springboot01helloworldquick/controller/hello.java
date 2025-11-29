package com.wintmain.springboot01helloworldquick.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-05 21:25:49
 */

@RestController
public class hello {
    @RequestMapping("/hello")
    public String hi() {
        return "Quick helloworld";
    }
}
