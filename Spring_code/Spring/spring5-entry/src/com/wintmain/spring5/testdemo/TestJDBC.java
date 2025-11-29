package com.wintmain.spring5.testdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.wintmain.spring5.dao.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName testJDBC.java
 * @FilePath src/com/wintmain/spring5/testdemo/testJDBC.java
 * @Description TBD
 * @Date 2022-03-18 20:56:23
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class TestJDBC {

  @Test
  public void test() {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_druid.xml"
    );
    DruidDataSource dataSource = context.getBean(
      "dataSource",
      DruidDataSource.class
    );
    System.out.println(dataSource.isKeepAlive());
  }

  @Test
  public void test2() {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "bean_druid.xml"
    );
    DataSource dataSource = context.getBean("dataSource", DataSource.class);
    dataSource.test();
  }
}
