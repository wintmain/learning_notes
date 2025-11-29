package com.wintmain.spring5;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Orders.java
 * @FilePath src/com/wintmain/spring5/Orders.java
 * @Description 使用有参数构造注入
 * @Date 2022-03-17 16:15:50
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Orders {

  private String oname = "";
  private String address;

  public Orders(String oname, String address) {
    this.oname = oname;
    this.address = address;
  }

  public void ordersTest() {
    System.out.println(oname + "::" + address);
  }
}
