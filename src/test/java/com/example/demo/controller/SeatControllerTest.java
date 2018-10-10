package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatControllerTest
 * @date 2018/10/10 11:50
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes=DemoApplication.class)// 指定spring-boot的启动类
public class SeatControllerTest {
    @Autowired
    SeatController seatController;
    @Test
    public void getSeat() {

    }

    @Test
    public void outSeat() {

    }

    @Test
    public void tempOut() {

    }
}