package com.wintmain.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 20:04:46
 */

@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //多钱
    @Override
    public void addMoney() {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    //lucy转账100给mary
    //少钱
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
}
