package com.example.demo.controller.admin;

import com.example.demo.service.admin.AdminStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(value = "/adminStudent")
public class AdminStudentController {
    @Autowired
    AdminStudentService adminStudentService;
    private static final Integer BLOCK_DAYS = 7;

    /**
     * 拉黑一个学生进入黑名单.
     * 默认为时一周
     *
     * @param sid
     */
    @RequestMapping("/blockStudent")
    public void blockStu(@RequestParam(value = "sid") String sid,
                         @RequestParam(value = "days", required = false) Integer days) {
        if (days == null) {
            days = BLOCK_DAYS;
        }
        //直接传给Service，默认时间一周
        adminStudentService.blockStudent(sid, days);
    }





}
