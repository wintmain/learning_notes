package com.wintmain.spring5.bean;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Dept.java
 * @FilePath src/com/wintmain/spring5/bean/Dept.java
 * @Description TBD
 * @Date 2022-03-18 10:37:59
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Dept {

  private String dname;

  public void setDname(String dname) {
    this.dname = dname;
  }

  @Override
  public String toString() {
    return "Dept{" + "dname='" + dname + '\'' + '}';
  }
}
