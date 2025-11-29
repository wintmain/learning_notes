package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
@MultipartConfig
public class downloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件下载。。。");
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到文件名
        String fileName = req.getParameter("fileName");
        if(fileName==null || "".equals(fileName.trim())){
            resp.getWriter().write("请输入文件名");
            resp.getWriter().close();
            return;
        }
        //得到路径
        String path = req.getServletContext().getRealPath("/download/");
        //通过路径得到file对象
        File file = new File(path+fileName);
        if(file.exists()&&file.isFile()){
            //设置响应类型,浏览器无法响应的
            resp.setContentType("application/x-msdownload");
            //设置响应头
            resp.setHeader("Content-Disposition","attachment;filename="+fileName);
            //得到文件输入流
            InputStream in = new FileInputStream(file);
            //得到字节输出流
            ServletOutputStream out = resp.getOutputStream();
            //流的实现逻辑
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
        }else {
            resp.getWriter().write("文件不存在");
            resp.getWriter().close();
            return;
        }


    }
}
