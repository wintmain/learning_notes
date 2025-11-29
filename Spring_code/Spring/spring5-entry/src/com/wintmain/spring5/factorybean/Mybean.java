package com.wintmain.spring5.factorybean;

import com.wintmain.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName Mybean.java
 * @FilePath src/com/wintmain/spring5/factorybean/Mybean.java
 * @Description TBD
 * @Date 2022-03-18 19:16:48
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class Mybean implements FactoryBean<Course> {

  //定义返回bean
  @Override
  public Course getObject() throws Exception {
    Course course = new Course();
    course.setCname("abc");
    return course;
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }
}
