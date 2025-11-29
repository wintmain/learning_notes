package com.wintmain.spring5.dao;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 20:03:37
 */

@Component
public interface UserDao {
    // 多钱
    public void addMoney();

    //少钱
    public void reduceMoney();
}
