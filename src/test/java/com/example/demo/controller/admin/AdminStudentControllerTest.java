package com.example.demo.controller.admin;

import com.example.demo.DemoApplication;
import com.example.demo.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminStudentControllerTest
 * @date 2018/10/10 12:01
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes= DemoApplication.class)// 指定spring-boot的启动类
@WebAppConfiguration
public class AdminStudentControllerTest {
    @Autowired
    AdminStudentController adminStudentController;
    @Test
    public void blockStu() {
    }

    @Test
    public void deleteStudent() {
    }

    @Test
    public void addStudent() {
        Student s = new Student("test账号","123456");
        s.setSid("10001");
        s.setState(0);
        s.setName("test账号");
        adminStudentController.addStudent(s);
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void getStudentById() {
    }
}