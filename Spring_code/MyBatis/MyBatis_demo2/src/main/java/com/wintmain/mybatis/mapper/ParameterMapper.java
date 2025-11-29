package com.wintmain.mybatis.mapper;

import com.wintmain.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-29 16:01:03
 */
public interface ParameterMapper {
    // 实现的功能放在这里，不需要dao层
    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username); //理论是只查一个

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录（使用@Param）
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
