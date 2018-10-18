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
    @ApiOperation("学生反馈")
    @RequestMapping(value = "feedback", method = RequestMethod.POST)
    public Msg feedback(@RequestParam(value = "sid", required = true) String sid,
                             @RequestParam(value = "context",required = true) String context) {
        if (studentService.feedback(sid, context)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }


}
