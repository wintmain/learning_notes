package com.example.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//name没有作用
@WebServlet(name = "helloServlet", value = {"/hello-servlet","/s01"})
public class Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    //    模板自动创建的
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }

//    基础的实现方法（重写service(HttpServletRequest req, HttpServletResponse resp)）
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //打印内容在控制台上
        System.out.println(message);
        //返回给浏览器
        resp.getWriter().write(message);
//        resp.setHeader("Refresh","5;URL=http://localhost:8080/servlet/example.htm");
    }

    /*
    销毁方法
    系统方法，服务器自动调用
    当服务器关闭或者应用程序停止时调用一次该方法
    只执行一次
     */
    public void destroy() {
        System.out.println("Servlet被销毁了");
    }
}

