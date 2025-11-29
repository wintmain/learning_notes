package com.example.webfluxdemo2;

import com.example.webfluxdemo2.handler.UserHandler;
import com.example.webfluxdemo2.service.UserService;
import com.example.webfluxdemo2.service.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-03 9:30:28
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //1 创建Router路由
    public RouterFunction<ServerResponse> routingFunction(){
        //创建hanler对象
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);
        //设置路由
        return RouterFunctions.
                route(GET("/users/{id}").and(accept(APPLICATION_JSON)),handler::getUserById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)),handler::getAllUsers);
    }

    //2 创建服务器完成适配
    private void createReactorServer() {
        //路由和handler适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }
}
