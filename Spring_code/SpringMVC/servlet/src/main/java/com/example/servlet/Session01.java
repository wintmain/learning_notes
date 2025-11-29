package com.example.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session01")
public class Session01 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //设置session与对象
        session.setAttribute("uname","admin");
        session.setAttribute("upwd","123456");
        //移除域对象
        session.removeAttribute("upwd");

        //session对象的最大不活动时间
        System.out.println(session.getMaxInactiveInterval());
        //修改
        session.setMaxInactiveInterval(15);//15s

        //立即销毁
        session.invalidate();


        //获取session的会话标识符
        String id = session.getId();
        System.out.println("session的会话标识符:"+id);
        //获取session的创建时间
        System.out.println("session的创建时间:"+session.getCreationTime());
        //获取最后一次访问时间
        System.out.println("最后一次访问时间"+session.getLastAccessedTime());
        //判断是否是新的session对象
        System.out.println("是否是新的session对象"+session.isNew());


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
