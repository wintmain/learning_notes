package com.wintmain.spring5.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/** =================================================================
 * @Author wintmain
 * @MailTo wosintmain@gmail.com
 * @FileName MyBeanPost.java
 * @FilePath src/com/wintmain/spring5/bean/MyBeanPost.java
 * @Description TBD
 * @Date 2022-03-18 19:54:56
 *
 * Copyright © 2022 by wintmain, All Rights Reserved.
 * ==================================================================
 */
public class MyBeanPost implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
    throws BeansException {
    System.out.println("在初始化之前执行的方法");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName)
    throws BeansException {
    System.out.println("在初始化之后执行的方法");
    return bean;
  }
}
