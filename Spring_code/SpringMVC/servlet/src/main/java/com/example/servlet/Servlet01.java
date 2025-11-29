package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//获取servletcontext对象
@WebServlet("/s001")
public class Servlet01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取
        ServletContext servletContext1 = req.getServletContext();
        //通过session对象获取
        ServletContext servletContext2 = req.getSession().getServletContext();
        //通过servletconfig对象获取
        ServletContext servletContext3 = getServletConfig().getServletContext();
        //直接获取
        ServletContext servletContext4 = getServletContext();

        //常用方法
        //获取服务器当前版本信息
        String serverinfo = req.getServletContext().getServerInfo();
        System.out.println(serverinfo);
        //获取项目的真实路径
        String realpath = req.getServletContext().getRealPath("/");
        System.out.println(realpath);
        System.out.println("");

    }
}
