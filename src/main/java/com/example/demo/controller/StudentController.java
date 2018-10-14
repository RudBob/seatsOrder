package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: StudentController
 * @date 2018/9/19 19:12
 */
@Api(description = "学生相关操作---任耀")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 学生登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 成功 or 失败
     */
    @ApiOperation("学生登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Msg login(@RequestParam(value = "username", required = true) String username,
                     @RequestParam(value = "pwd", required = true) String password,
                     HttpSession session) {
        Student student = studentService.login(username, password,session);
        if (student != null) {
            return Msg.success().add("student", student);
        }
        return Msg.fail().setMsg("账号或密码错误");
    }

    /**
     * 学生登出
     *
     * @param sid
     * @return
     */
    @ApiOperation("学生登出")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Msg logout(@RequestParam(value = "sid", required = true) String sid,
                      HttpSession session) {
        Boolean outFlag = studentService.logout(sid,session);
        if (outFlag) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 学生修改密码
     *
     * @param sid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @ApiOperation("修改学生密码")
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public Msg updatePassword(@RequestParam(value = "sid", required = true) String sid,
                              @RequestParam(value = "oldPwd", required = true) String oldPassword,
                              @RequestParam(value = "newPwd", required = true) String newPassword) {
        if (studentService.updatePassword(sid, oldPassword, newPassword)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
