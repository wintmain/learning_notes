package com.wintmain.spring5.testdemo;

import com.wintmain.spring5.User;
import com.wintmain.spring5.bean.Emp;
import com.wintmain.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName TestBean.java
 * @FilePath src/com/wintmain/spring5/testdemo/TestBean.java
 * @Description TBD
 * @Date 2022-03-18 12:05:16
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class TestBean {
  @Test
  public void testBean1() {
    //1.加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean1.xml"
    );
    //2.获取配置创建的对象
    User user = context.getBean("user", User.class);
    user.add();
  }

  @Test
  public void testBean2() {
    //1.加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean2.xml"
    );
    //2.获取配置创建的对象
    UserService userService = context.getBean("userService", UserService.class);
    userService.add();
  }

  @Test
  public void testBean3() {
    //1.加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean3.xml"
    );
    //2.获取配置创建的对象
    Emp emp = context.getBean("emp", Emp.class);
    emp.add();
  }

  @Test
  public void testBean4() {
    //1.加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean4.xml"
    );
    //2.获取配置创建的对象
    Emp emp = context.getBean("emp", Emp.class);
    emp.add();
  }
}
