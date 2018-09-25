package com.example.demo.controller.admin;

import com.example.demo.service.AdminService;
import com.example.demo.service.admin.AdminSeatService;
import com.example.demo.service.admin.AdminStudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminController
 * @date 2018/9/19 19:09
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    AdminStudentService adminStudentService;

    @Autowired
    AdminSeatService adminSeatService;



}
