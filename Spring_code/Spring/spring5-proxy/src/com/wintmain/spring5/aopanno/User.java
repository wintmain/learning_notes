package com.wintmain.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-24 22:50:29
 */

//被增强的类

@Component
public class User {
    public void add(){
//        int i = 10/0;
        System.out.println("add......");
    }
}
