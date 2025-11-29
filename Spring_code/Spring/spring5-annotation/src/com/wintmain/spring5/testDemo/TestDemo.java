package com.wintmain.spring5.testDemo;

import com.wintmain.spring5.config.SpringConfig;
import com.wintmain.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-21 16:33:51
 */
public class TestDemo {

    @Test
    public void testService1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_annotation.xml");
        UserService userService = context.getBean("userService",UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testService2(){
        //加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
