package com.wintmain.spring5.test;

import com.wintmain.spring5.aopanno.User;
import com.wintmain.spring5.aopxml.Book;
import com.wintmain.spring5.config.ConfigAop;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-24 23:03:53
 */
public class TestAop {

    @Test
    public void testAopAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user",User.class);
        user.add();
    }

    @Test
    public void testAopAnno2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user",User.class);
        user.add();
    }

    @Test
    public void testA(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book",Book.class);
        book.buy();
    }
}
