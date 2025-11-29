package com.wintmain.spring5.dao;

import java.sql.*;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName DataSource.java
 * @FilePath src/com/wintmain/spring5/dao/DataSource.java
 * @Description TBD
 * @Date 2022-03-18 21:05:22
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class DataSource {

  private String driverClassName;
  private String url;
  private String username;
  private String password;

  public DataSource(
    String driverClassName,
    String url,
    String username,
    String password
  ) {
    this.driverClassName = driverClassName;
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public DataSource() {}

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void test() {
    Connection conn = null;
    Statement stmt = null;
    try {
      //注册JDBC驱动
      Class.forName(driverClassName);

      // 打开链接
      System.out.println("连接数据库...");
      conn = DriverManager.getConnection(url, username, password);

      // 执行查询
      System.out.println("实例化Statement对象...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT id, name, url FROM websites";
      ResultSet rs = stmt.executeQuery(sql);

      // 展开结果集数据库
      while (rs.next()) {
        // 通过字段检索
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String url = rs.getString("url");

        // 输出数据
        System.out.print("ID: " + id);
        System.out.print(", 站点名称: " + name);
        System.out.print(", 站点 URL: " + url);
        System.out.print("\n");
      }
      // 完成后关闭
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException se) {
      // 处理 JDBC 错误
      se.printStackTrace();
    } catch (Exception e) {
      // 处理 Class.forName 错误
      e.printStackTrace();
    } finally {
      // 关闭资源
      try {
        if (stmt != null) stmt.close();
      } catch (SQLException se2) {} // 什么都不做
      try {
        if (conn != null) conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
      System.out.println("Bye");
    }
    System.out.println("成功");
  }
}
