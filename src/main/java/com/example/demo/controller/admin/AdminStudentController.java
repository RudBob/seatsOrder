package com.example.demo.controller.admin;

import com.example.demo.bean.Student;
import com.example.demo.service.admin.AdminStudentService;
import com.example.demo.util.Msg;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminStudentController
 * @date 2018/9/24 20:18
 */
@RestController
@Transactional
@RequestMapping(value = "/adminStudent")
public class AdminStudentController {
    @Autowired
    AdminStudentService adminStudentService;

    private static final Integer BLOCK_DAYS = 7;

    @RequestMapping(value = "getStuPage", method = RequestMethod.POST)
    public Msg getSeats(@RequestParam(value = "pNum", required = false, defaultValue = "1") Integer pNum,
                        @RequestParam(value = "sid", required = false) Integer sid,
                        @RequestParam(value = "status", required = false) Integer status) {
        PageInfo<Student> stuPage = adminStudentService.getStuByParam(pNum, sid, status);
        return Msg.success().add("stuPage", stuPage);
    }

    /**
     * 拉黑一个学生进入黑名单.
     * 默认为时一周
     *
     * @param sid 学生id
     */
    @RequestMapping(value = "/blockStudent", method = RequestMethod.POST)
    public Msg blockStu(@RequestParam(value = "sid") String sid,
                        @RequestParam(value = "days", required = false, defaultValue = "7")
                                Integer days) {
        //直接传给Service，默认时间一周
        if (adminStudentService.blockStudent(sid, days) > 0) {
            return Msg.success().setMsg("禁言成功");
        } else {
            return Msg.fail().setMsg("未知错误");
        }

    }

    @RequestMapping(value = "/removeStudent", method = RequestMethod.POST)
    public int deleteStudent(@RequestParam(value = "sid") String sid) {
        //直接传给Service，删除
        return adminStudentService.deleteStudent(sid);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public int addStudent(Student student) {
        //直接传给Service，删除
        return adminStudentService.addStudent(student);
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public int updateStudent(@RequestParam(value = "sid") Student student) {
        //直接传给Service，删除
        return adminStudentService.updateStudent(student);
    }

    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam(value = "sid") String sid) {
        //直接传给Service，删除
        return adminStudentService.getStudentById(sid);
    }


}
