package com.wintmain.spring5.collectiontype;

import java.util.List;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Book.java
 * @FilePath src/com/wintmain/spring5/collectiontype/Book.java
 * @Description TBD
 * @Date 2022-03-18 18:49:15
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Book {

  private List<String> list;

  public void setList(List<String> list) {
    this.list = list;
  }

  public void test() {
    System.out.println(list);
  }
}
