package com.wintmain.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-24 23:35:21
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {

    //后置通知（返回通知）
    @Before(value = "execution(* com.wintmain.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("Person Before.........");
    }
}
