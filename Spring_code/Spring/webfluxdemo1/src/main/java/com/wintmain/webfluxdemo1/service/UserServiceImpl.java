package com.wintmain.webfluxdemo1.service;

import com.wintmain.webfluxdemo1.entity.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-02 15:33:13
 */

@Repository
public class UserServiceImpl implements UserService{
    //创建map集合存储数据
    private final Map<Integer,User> users = new HashMap<>();

    public UserServiceImpl(){
        this.users.put(1,new User("lucy","nan",20));
        this.users.put(2,new User("mary","nv",30));
        this.users.put(3,new User("jack","nv",50));
    }


    //根据id查询
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person->{
           // 向map集合里面放值
            int id = users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
