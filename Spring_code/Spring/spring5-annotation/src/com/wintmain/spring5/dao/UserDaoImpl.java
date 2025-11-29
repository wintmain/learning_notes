package com.wintmain.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-21 15:56:09
 */

@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao add...");
    }
}
