package com.rent.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();


        if(url.contains("/admin")) {
            if(request.getSession().getAttribute("admin") == null) {
                response.sendRedirect("/login.html");
                return false;
            }
        }

        return true;
    }
}
