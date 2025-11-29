package com.example.webfluxdemo2;

import com.example.webfluxdemo2.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-03 9:30:38
 */
public class Client {
    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:11038");
        //根据id查询
        String id = "1";
        User userresult = webClient.get().uri("/users/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
                .block();
        System.out.println(userresult.getName());

        //查询所有
        Flux<User> results = webClient.get().uri("/users")
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);

        results.map(stu -> stu.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
