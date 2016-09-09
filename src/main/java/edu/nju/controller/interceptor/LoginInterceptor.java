package edu.nju.controller.interceptor;

import edu.nju.controller.LoginHelper;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dora on 2016/9/9.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private int openingTime;
    private int closingTime;

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if (LoginHelper.getSignInUser(request.getSession())!=null) {
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}