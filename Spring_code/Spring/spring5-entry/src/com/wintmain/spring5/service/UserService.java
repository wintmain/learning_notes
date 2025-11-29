package com.wintmain.spring5.service;

import com.wintmain.spring5.dao.UserDao;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName UserService.java
 * @FilePath src/com/wintmain/spring5/service/UserService.java
 * @Description TBD
 * @Date 2022-03-17 21:44:15
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class UserService {

  //创建UserDao类型属性，生成set方法
  private UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  public void add() {
    System.out.println("service add...");
    userDao.update();
  }
}
