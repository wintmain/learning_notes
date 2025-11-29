package com.wintmain.spring5.collectiontype;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Course.java
 * @FilePath src/com/wintmain/spring5/collectiontype/Course.java
 * @Description TBD
 * @Date 2022-03-18 13:07:02
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Course {

  private String cname; //课程名称

  public void setCname(String cname) {
    this.cname = cname;
  }

  @Override
  public String toString() {
    return "Course{" + "cname='" + cname + '\'' + '}';
  }
}
