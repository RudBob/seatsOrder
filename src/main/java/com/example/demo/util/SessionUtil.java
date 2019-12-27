package com.example.demo.util;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Student;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static void updateUserFromDB(Student stu) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user", stu);
    }

    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static Student getStuFromSession() {
        return (Student) getSession().getAttribute("user");
    }

    public static Admin getAdminFromSession() {
        return (Admin) getSession().getAttribute("user");
    }
}
