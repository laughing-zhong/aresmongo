package com.ares.framework.rpc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor { 
	 

 
    @Override 
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception { 
//        User user=(User) hsr.getSession().getAttribute("LoginUser"); 
//        if(user==null){ 
//            logger.log(Level.INFO, "user not login"); 
//            hsr1.sendRedirect("/SundearEmm"); 
//            return false; 
//        } 
        return true; 
    } 
 
    @Override 
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception { 
    } 
 
    @Override 
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception { 
    } 
} 