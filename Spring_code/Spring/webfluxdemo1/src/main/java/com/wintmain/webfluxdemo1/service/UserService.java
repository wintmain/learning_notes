package com.wintmain.webfluxdemo1.service;

import com.wintmain.webfluxdemo1.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-02 15:30:04
 */

//用户操作接口
public interface UserService {
    //根据id查询用户
    Mono<User> getUserById(int id);

    //查询所有用户
    Flux<User> getAllUser();

    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
