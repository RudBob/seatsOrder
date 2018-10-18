package com.example.demo.controller;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Student;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: LoginController
 * @date 2018/10/18 13:56
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;

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
        if (student != null) {

            return Msg.success().add("student", student);
        } else {
            Admin admin = adminService.login(username, password, session);
            if (admin != null) {
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
        // TODO 待增加管理员登出逻辑
        Boolean outFlag = studentService.logout(sid, session);
        if (outFlag) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
