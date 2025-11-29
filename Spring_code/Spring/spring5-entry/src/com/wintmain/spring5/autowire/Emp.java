package com.wintmain.spring5.autowire;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Emp.java
 * @FilePath src/com/wintmain/spring5/autowire/Emp.java
 * @Description TBD
 * @Date 2022-03-18 20:04:26
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Emp {

  private Dept dept;

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  @Override
  public String toString() {
    return "Emp{" + "dept=" + dept + '}';
  }

  public void test() {
    System.out.println(dept);
  }
}
