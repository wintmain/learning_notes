package com.wintmain.spring5.bean;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Emp.java
 * @FilePath src/com/wintmain/spring5/bean/Emp.java
 * @Description TBD
 * @Date 2022-03-18 10:37:21
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Emp {

  private String ename;
  private String gender;

  //员工属于某一个部门，使用对象形式表示
  private Dept dept;

  //生成dept的get方法
  public Dept getDept() {
    return dept;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public void add() {
    System.out.println(ename + "::" + gender + "::" + dept);
  }
}
