package com.example.servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value="/req02")
public class HelloServlet02 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        // 设置编码，在解析之前，POST请求会有这样的问题
        // 只针对POST请求
        request.setCharacterEncoding("UTF-8");
        /* Resqust常用方法*/
        String url = request.getRequestURL()+"";
        System.out.println("获取请求时的完整路径："+url);

        String uri = request.getRequestURI().toString();
        System.out.println("获取请求时的部分路径："+uri);

        String method = request.getMethod().toString();
        System.out.println("获取请求方式："+method);

        String queryString = request.getQueryString();
        System.out.println("获得请求时的参数字符串："+queryString);

        String protocol = request.getProtocol();
        System.out.println("当前协议版本："+protocol);

        String webapp =request.getContextPath();
        System.out.println("获取项目的站点名："+webapp);

        /*
        获取参数的方法
        */

        // 很重要，字符串
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        System.out.println("uname:"+uname+",pwd:"+pwd);

        //多个是一个字符串数组
        String[] hobbies = request.getParameterValues("hobby");
        if(hobbies !=null &&hobbies.length>0){
            for(String hobby:hobbies){
                System.out.println("爱好："+hobby);
            }
        }
    }

    public void destroy() {
    }
}