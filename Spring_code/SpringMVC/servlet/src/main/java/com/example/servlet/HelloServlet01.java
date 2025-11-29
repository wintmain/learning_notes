package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/req01")
public class HelloServlet01 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("s01 uname:"+uname);
        System.out.println("s01 pwd:"+pwd);

//        RequestDispatcher rd = req.getRequestDispatcher("s03");
//        try {
//            //请求转发到s03
//            rd.forward(req,resp);
//            return;
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

        //请求转发
        req.getRequestDispatcher("req03").forward(req,resp);
        //重定向
        resp.sendRedirect("www.baidu.com");

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
