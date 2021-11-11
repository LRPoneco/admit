package com.example.admit.dao.lanjieqi;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HttpSession session=request.getSession();
        Object ob=session.getAttribute("admit");
        if (ob!=null) {
            System.out.print( "正常访问。。。。\n");
            return true;
        }else {
            response.sendRedirect("/index.html");
            System.out.print( "异常访问。。。。\n");
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView model) throws Exception{
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler,Exception ex) throws Exception{
    }
}