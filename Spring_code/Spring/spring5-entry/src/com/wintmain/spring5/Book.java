package com.wintmain.spring5;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Book.java
 * @FilePath src/com/wintmain/spring5/Book.java
 * @Description 演示使用set方法进行注入属性
 * @Date 2022-03-17 16:09:05
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Book {

  //创建属性
  private String bname;
  private String bauthor;
  private String address;
  private Integer id;

  public void setBname(String bname) {
    this.bname = bname;
  }

  public void setBauthor(String bauthor) {
    this.bauthor = bauthor;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void testDemo() {
    System.out.println(bname + "::" + bauthor + "::" + address + "::" + id);
  }
}
