package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cookie02")
public class cookie02 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        设置cookie的路径
        // 当前服务器下任何项目的任何资源都可以访问和获取
        Cookie cookie = new Cookie("xxx","xxx");
        cookie.setPath("/");
        resp.addCookie(cookie);
        //
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
