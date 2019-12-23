package com.example.demo.controller;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Student;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public Msg login(@RequestParam(value = "username" ) String username,
                     @RequestParam(value = "pwd" ) String password,
                     HttpServletRequest request) {

        Student student = studentService.login(username, password);
        HttpSession session = request.getSession();

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

    @ApiOperation("用户登录后，前端获取后端session中的内容")
    @RequestMapping(value = "getUserFromSession", method = RequestMethod.POST)
    public Msg getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            return Msg.fail().setMsg("用户未登录");
        } else {
            return Msg.success().add("user", user);
        }
    }

    /**
     * 学生登出
     *
     */
    @ApiOperation("用户登出")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Msg logout(@RequestParam(value = "sid" ) String sid,
                      HttpSession session) {
        session.removeAttribute("user");
        return Msg.success();
    }
}
