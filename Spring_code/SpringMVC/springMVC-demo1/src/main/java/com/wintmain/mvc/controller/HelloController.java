package com.wintmain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author wintmain <wosintmain@gmail.com>
 * @Date 2022-03-03 10:59:25
 */

@Controller
public class HelloController {
    // "/"-->/WEB-INF/templates/index.html

    @RequestMapping(value = "/")
    public String index(){
        // 返回视图名称
        return "index";
    }

    @RequestMapping(value = "/target")
    public String toTarget(){
        return "target";
    }

}
