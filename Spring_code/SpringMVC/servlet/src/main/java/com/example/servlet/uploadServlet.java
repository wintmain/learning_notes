package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件上传");
        req.setCharacterEncoding("UTF-8");

        String uname = req.getParameter("uname");
        System.out.println("uname:"+uname);

        //获取part对象（Servlet将multipart/form-data的post请求封装成part对象）
        Part part = req.getPart("ufile");
        //通过part对象获取文件名
        String fileName = part.getSubmittedFileName();
        System.out.println("上传的文件名："+fileName);
        //得到文件上传的路径
        String filePath = req.getServletContext().getRealPath("/");
        System.out.println("文件上传的路径："+filePath);

        //上传文件到指定目录
        part.write(filePath+"/"+fileName);

    }
}
