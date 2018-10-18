package com.example.demo.controller;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Student;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: LoginController
 * @date 2018/10/18 13:56
 */
@RestController
@Transactional
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;

    /**
     * 学生登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 成功 or 失败
     */
    @ApiOperation("用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Msg login(@RequestParam(value = "username", required = true) String username,
                          @RequestParam(value = "pwd", required = true) String password,
                          HttpSession session) {
        Student student = studentService.login(username, password, session);
        if(session == null){
            session = new HttpSession() {
                @Override
                public long getCreationTime() {
                    return 0;
                }

                @Override
                public String getId() {
                    return null;
                }

                @Override
                public long getLastAccessedTime() {
                    return 0;
                }

                @Override
                public ServletContext getServletContext() {
                    return null;
                }

                @Override
                public void setMaxInactiveInterval(int i) {

                }

                @Override
                public int getMaxInactiveInterval() {
                    return 0;
                }

                @Override
                public HttpSessionContext getSessionContext() {
                    return null;
                }

                @Override
                public Object getAttribute(String s) {
                    return null;
                }

                @Override
                public Object getValue(String s) {
                    return null;
                }

                @Override
                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                @Override
                public String[] getValueNames() {
                    return new String[0];
                }

                @Override
                public void setAttribute(String s, Object o) {

                }

                @Override
                public void putValue(String s, Object o) {

                }

                @Override
                public void removeAttribute(String s) {

                }

                @Override
                public void removeValue(String s) {

                }

                @Override
                public void invalidate() {

                }

                @Override
                public boolean isNew() {
                    return false;
                }
            };
        }
        if (student != null) {
            //加到session中
            session.setAttribute("user", student);
            return Msg.success().add("student", student);
        } else {
            Admin admin = adminService.login(username, password, session);
            if (admin != null) {
                session.setAttribute("user", admin);
                return Msg.success().add("admin", admin);
            }
        }
        return Msg.fail().setMsg("账号或密码错误");
    }

    /**
     * 学生登出
     *
     * @param sid
     * @return
     */
    @ApiOperation("用户登出")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Msg logout(@RequestParam(value = "sid", required = true) String sid,
                           HttpSession session) {
        session.removeAttribute("user");
        return Msg.success();
    }
}
