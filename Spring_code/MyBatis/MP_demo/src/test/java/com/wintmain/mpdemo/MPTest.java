package com.wintmain.mpdemo;

import com.wintmain.mpdemo.mapper.UserMapper;
import com.wintmain.mpdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-09 16:15:37
 */

@SpringBootApplication
public class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        System.out.println(("----- selectAll method test ------"));
        //条件构造器
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
