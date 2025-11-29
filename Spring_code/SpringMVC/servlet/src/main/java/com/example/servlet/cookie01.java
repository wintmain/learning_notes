package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/cookie01")
public class cookie01 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //cookie存中文会报错
        //cookie大小有上限，4kb
        //存同名会覆盖
        String name = "姓名";
        String value = "文天满";

        //需要用URLEncoder编码
        name = URLEncoder.encode(name);
        value = URLEncoder.encode(value);
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(30);  //-1表示关闭浏览器即消失；0表示就删除；正整数单位为秒，存在本机中
        resp.addCookie(cookie);

        //刷新后才可以获取到cookie
        //获取cookie，解码
        Cookie[] cookies = req.getCookies();
        //遍历之前先判空
        if(cookies!=null&cookies.length>0){
            for(Cookie cook:cookies){
                //解码
                System.out.println(URLDecoder.decode(cook.getName()));
                System.out.println(URLDecoder.decode(cook.getValue()));
            }
        }
    }



    @Override
    public void destroy() {
        super.destroy();
    }
}
