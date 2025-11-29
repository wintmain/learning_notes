package com.wintmain.spring5.test;

import com.wintmain.spring5.service.UserService;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-26 16:50:29
 */

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JTest5 {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.accountMoney();
    }
}
