package com.wintmain.spring5.service;

import com.wintmain.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 20:19:48
 */

@Service
//@Transactional //配合基于xml注解方式
public class UserService {
    //注入dao
    @Autowired
    private UserDao userDao;

    //转账的方法
//    @Transactional
    public void accountMoney() {

        try{
            //第一步 开启事务

            //第二步 进行业务操作
            //lucy 少 100
            userDao.reduceMoney();

            //模拟异常
            int i = 10/0;

            //mary 多 100
            userDao.addMoney();

            //第三步 没有发生异常，提交事务
        }catch (RuntimeException e){
            //第四步 出现异常，事务回滚
//            throw new RuntimeException("出错了");
        }

    }
}
