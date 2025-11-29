package com.wintmain.springboot02config;

import com.wintmain.springboot02config.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * SpringBoot单元测试;
 * <p>
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void helloService() {
        boolean b = ioc.containsBean("helloService02");
        System.out.println(b);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
