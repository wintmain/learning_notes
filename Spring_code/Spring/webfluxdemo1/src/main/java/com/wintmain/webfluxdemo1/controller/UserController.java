package com.wintmain.webfluxdemo1.controller;

import com.wintmain.webfluxdemo1.entity.User;
import com.wintmain.webfluxdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-02 15:43:34
 */

@RestController
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    //id查询
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }

    //查询所有
    @GetMapping("/users")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }

    //添加
    @PostMapping("/saveuser")
    public Mono<Void> saveUsr(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }

}
