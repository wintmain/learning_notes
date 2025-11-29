package com.example.servlet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/resp01")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码问题,1.设置服务端的编码格式 2.设置客户端的编码格式
//        resp.setCharacterEncoding("UTF-8");
//        resp.setHeader("content-type","text/html;charset=utf-8");
        //以上两句可以合并
        resp.setContentType("text/html;charset=utf-8");
        //字符流，与字节流不能同时，因为response只能使用一次
//        PrintWriter pw = resp.getWriter();
//        pw.write("<h2>你好</h2>");

        //字节流
        ServletOutputStream sos = resp.getOutputStream();
        sos.write("<h2>我也好</h2>".getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}