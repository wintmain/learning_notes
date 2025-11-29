package com.wintmain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-09 12:07:14
 */

@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
