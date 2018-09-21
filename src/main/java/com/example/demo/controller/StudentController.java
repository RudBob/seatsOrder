package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("login")
    public Student login(@Param(value = "username") String username,
                         @Param(value = "password") String password) {
       Student student = studentService.login(username, password);
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
    @RequestMapping("updatePassword")
    public boolean updatePassword(@Param(value = "sid") String sid,
                                  @Param(value = "oldPassword") String oldPassword,
                                  @Param(value = "newPassword") String newPassword) {
        boolean res = studentService.updatePassword(sid, oldPassword, newPassword);
        return res;
    }
}
