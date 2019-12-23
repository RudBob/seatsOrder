package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: StudentController
 * @date 2018/9/19 19:12
 */
@Api( "学生相关操作---任耀")
@RestController
@Transactional
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 学生修改密码
     */
    @ApiOperation("修改学生密码")
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public Msg updatePassword(@RequestParam(value = "sid" ) String sid,
                              @RequestParam(value = "oldPwd" ) String oldPassword,
                              @RequestParam(value = "newPwd" ) String newPassword) {
        if (studentService.updatePassword(sid, oldPassword, newPassword)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 查看学生自己的详情
     */
    @ApiOperation("学生信息查看")
    @RequestMapping(value = "getStuInfo", method = RequestMethod.POST)
    public Msg getStuInfo(@RequestParam(value = "sid" ) String sid) {
        // 得到学生对象
        Student student = studentService.getStudent(sid);
        if (student != null) {
            return Msg.success().add("stuInfo", student);
        } else {
            return Msg.fail().setMsg("未知错误");
        }
    }

    /**
     * 学生查看自己的历史记录
     */
    @ApiOperation("学生的历史记录查看")
    @RequestMapping(value = "getStuHistory", method = RequestMethod.POST)
    public Msg getStuHistory(@RequestParam(value = "sid" ) String sid) {
        List<StudentSeat> studentHistory = studentService.getHistory(sid);
        if (studentHistory.size() == 0) {
            return Msg.success().setMsg("暂无历史记录");
        }
        return Msg.success().add("history", studentHistory);
    }
}
