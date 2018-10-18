package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: StudentControllerTest
 * @date 2018/10/18 17:15
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes= DemoApplication.class)// 指定spring-boot的启动类
@WebAppConfiguration
public class StudentControllerTest {

    @Autowired
    StudentController studentController;
    @Test
    public void updatePassword() {
        studentController.updatePassword("10000","testpwd","pwd");
    }

    @Test
    public void feedback() {
        studentController.feedback("10000","this is a feedback");
    }
}