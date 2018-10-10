package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: StudentController
 * @date 2018/9/19 19:12
 */
@Controller
@ResponseBody
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
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Student login(@RequestParam(value = "username",required = true) String username,
                         @RequestParam(value = "pwd",required = true) String password) {
       Student student = studentService.login(username, password);
        return student;
    }

    @ResponseBody
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public Student logout(@Param(value = "sid") String sid) {
        Student student = studentService.logout(sid);
        return student;
    }
    /**
     * 学生修改密码
     *
     * @param sid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updatePassword",method = RequestMethod.POST)
    public boolean updatePassword(@Param(value = "sid") String sid,
                                  @Param(value = "oldPwd") String oldPassword,
                                  @Param(value = "newPwd") String newPassword) {
        boolean res = studentService.updatePassword(sid, oldPassword, newPassword);
        return res;
    }
}
