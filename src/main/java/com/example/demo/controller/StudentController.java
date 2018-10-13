package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
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
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Msg login(@RequestParam(value = "username",required = true) String username,
                     @RequestParam(value = "pwd",required = true) String password) {
       Student student = studentService.login(username, password);
       if(student != null){
           return Msg.success().add("student",student);
       }
       return Msg.fail().setMsg("账号或密码错误");
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public Msg logout(@RequestParam(value = "sid",required = true) String sid) {
        Student student = studentService.logout(sid);
        if(student != null){
            return Msg.success().add("student",student);
        }
        return Msg.fail().setMsg("账号或密码错误");
    }
    /**
     * 学生修改密码
     *
     * @param sid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "updatePassword",method = RequestMethod.POST)
    public Msg updatePassword(@RequestParam(value = "sid",required = true) String sid,
                                  @RequestParam(value = "oldPwd",required = true) String oldPassword,
                                  @RequestParam(value = "newPwd",required = true) String newPassword) {
        if(studentService.updatePassword(sid, oldPassword, newPassword)){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
