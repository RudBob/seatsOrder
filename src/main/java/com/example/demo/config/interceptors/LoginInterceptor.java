package com.example.demo.config.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ry
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 这个方法是在访问接口之前执行的，
     * 我们只需要在这里写验证登陆状态的业务逻辑，
     * 就可以在用户调用指定接口之前验证登陆状态了
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //这里的 User 是登陆时放入 session 的
        Object user = session.getAttribute("user");
        //如果 session 中没有 user ，表示没登陆
        if (user == null) {
            // 如果他没有登陆这里会跳转至登录页面
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
