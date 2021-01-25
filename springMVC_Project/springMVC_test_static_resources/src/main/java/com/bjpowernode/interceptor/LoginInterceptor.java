package com.bjpowernode.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 杨廷甲
 * 2020-12-14
 */

//设置拦截器页面，对用户session进行验证
    //就是这里的拦截的意思就是，你必须是要先登录了的 才会有session这个会话作用域对象，才能进行访问其他资源，
    //如果你还没有登录，那么你是没有权限去访问其他文件的，就是对除了登录页面以外的其他的资源进行的一个权限保护
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进行登录权限验证
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null){
            //此时说明没有登陆过，就必须先去登录页面进行登录
            request.setAttribute("msg", "您还没有登录请先去登录");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            //没有登录则截断请求
            return false;
        }
        //放行其他请求
        return true;
    }
}
