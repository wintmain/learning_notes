package com.wintmain.restfulcrud.component;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-05-02 20:30:51
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查，直接访问某个静态资源，那么登录毫无意义
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // 目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            //未登录，返回登录页面
            request.setAttribute("msg", "没有权限请先登陆");//错误提示信息内容
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
