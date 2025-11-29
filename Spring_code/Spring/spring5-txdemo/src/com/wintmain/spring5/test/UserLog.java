package com.wintmain.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-26 16:20:50
 */
public class UserLog {
    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}
