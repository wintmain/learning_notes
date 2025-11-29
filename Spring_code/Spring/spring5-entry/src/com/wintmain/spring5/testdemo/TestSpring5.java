package com.wintmain.spring5.testdemo;

import com.wintmain.spring5.Book;
import com.wintmain.spring5.Orders;
import com.wintmain.spring5.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName TestSpring5.java
 * @FilePath src/com/wintmain/spring5/testdemo/TestSpring5.java
 * @Description TBD
 * @Date 2022-03-16 21:53:38
 *
 * Copyright © 2023 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class TestSpring5 {

  @Test
  public void testAdd() {
    //1 加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean1.xml"
    );
    //2 获取配置创建的对象
    User user = context.getBean("user", User.class);
    System.out.println(user);
    user.add();
  }

  @Test
  public void testBook() {
    //1 加载spring配置文件
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean1.xml"
    );
    //2 获取配置创建的对象
    Book book = context.getBean("book", Book.class);

    System.out.println(book);
    book.testDemo();
  }

  @Test
  public void testOrders() {
    //1 加载spring配置文件
    BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");

    Orders orders = context.getBean("orders", Orders.class);

    System.out.println(orders);
    orders.ordersTest();
  }
}
