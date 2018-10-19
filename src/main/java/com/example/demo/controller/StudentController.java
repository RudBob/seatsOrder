package com.example.demo.controller;

import com.example.demo.bean.FeedBack;
import com.example.demo.bean.Student;
import com.example.demo.bean.StudentSeat;
import com.example.demo.service.StudentService;
import com.example.demo.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: StudentController
 * @date 2018/9/19 19:12
 */
@Api(description = "学生相关操作---任耀")
@RestController
@Transactional
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

    /**
     * @param sid
     * @param context 反馈正文，String类型，所以不接受文本
     * @return
     */
    @ApiOperation("学生反馈")
    @RequestMapping(value = "feedback", method = RequestMethod.POST)
    public Msg feedback(@RequestParam(value = "sid", required = true) String sid,
                        @RequestParam(value = "context", required = true) String context) {
        if (studentService.feedback(sid, context)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 查看学生自己的详情
     *
     * @param sid
     * @return
     */
    @ApiOperation("学生信息查看")
    @RequestMapping(value = "getStuInfo", method = RequestMethod.POST)
    public Msg getStuInfo(@RequestParam(value = "sid", required = true) String sid) {
        // 得到学生对象
        Student student = studentService.getStudent(sid);
        if (student != null) {
            return Msg.success().add("stuInfo", student);
        } else {
            return Msg.fail().setMsg("未知错误");
        }
    }

    /**
     * 学生查看自己的反馈
     *
     * @param sid
     * @return
     */
    @ApiOperation("学生查看自己的反馈")
    @RequestMapping(value = "getStuFeedBack", method = RequestMethod.POST)
    public Msg getStuFeedBack(@RequestParam(value = "sid", required = true) String sid) {
        List<FeedBack> feedBacks = studentService.getStuFeedBack(sid);
        return Msg.success().add("stuFeedBack", feedBacks);
    }

    /**
     * 学生查看自己的历史记录
     *
     * @param sid
     * @return
     */
    @ApiOperation("学生的历史记录查看")
    @RequestMapping(value = "getStuHistory", method = RequestMethod.POST)
    public Msg getStuHistory(@RequestParam(value = "sid", required = true) String sid) {
        List<StudentSeat> studentHistory = studentService.getHistory(sid);
        if (studentHistory.size() == 0) {
            return Msg.success().setMsg("暂无历史记录");
        }
        return Msg.success().add("history", studentHistory);
    }
}
