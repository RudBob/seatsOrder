package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.bean.FeedBack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminServiceTest
 * @date 2018/10/18 17:49
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = DemoApplication.class)// 指定spring-boot的启动类
@WebAppConfiguration
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void login() {
    }

    @Test
    public void showFeedBacks() {
        List<FeedBack> feedBacks = adminService.showFeedBacks();
        for (FeedBack f :
                feedBacks) {
            System.out.println(f);
        }
    }
}