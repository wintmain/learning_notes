package com.wintmain.spring5.testdemo;

import com.wintmain.spring5.autowire.Emp;
import com.wintmain.spring5.bean.Orders;
import com.wintmain.spring5.collectiontype.Book;
import com.wintmain.spring5.collectiontype.Course;
import com.wintmain.spring5.collectiontype.Stu;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName TestBean2.java
 * @FilePath src/com/wintmain/spring5/testdemo/TestBean2.java
 * @Description TBD
 * @Date 2022-03-18 15:25:15
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class TestBean2 {

  @Test
  public void testCollection1() {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_collection.xml"
    );

    Stu stu = context.getBean("stu", Stu.class);
    stu.test();
  }

  @Test
  public void testCollection2() {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_collection2.xml"
    );
    Book book1 = context.getBean("book", Book.class);
    Book book2 = context.getBean("book", Book.class);

    book1.test();
    System.out.println(book1);
    System.out.println(book2);
  }

  @Test
  public void test3() {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_factory.xml"
    );
    Course course = context.getBean("myBean", Course.class);
    System.out.println(course);
  }

  @Test
  public void testBean3() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_life.xml"
    );
    Orders orders = context.getBean("orders", Orders.class);
    System.out.println("第四步 获取创建bean实例对象");
    System.out.println(orders);

    //手动让 bean 实例销毁
    context.close();
  }

  @Test
  public void testBean4() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_postprocessor.xml"
    );
    Orders orders = context.getBean("orders", Orders.class);
    System.out.println("第四步 获取创建bean实例对象");
    System.out.println(orders);

    //手动让 bean 实例销毁
    context.close();
  }

  @Test
  public void test4() {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_auto.xml"
    );
    Emp emp = context.getBean("emp", Emp.class);
    System.out.println(emp);
  }
}
