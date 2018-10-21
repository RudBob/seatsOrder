package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatControllerTest
 * @date 2018/10/18 17:28
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = DemoApplication.class)// 指定spring-boot的启动类
@WebAppConfiguration
//@Transactional
public class SeatControllerTest {

    @Autowired
    SeatController seatController;

    static String sid = "10000";
    static Integer tid = 10101003;

    @Test
    public void orderSeat() {
        System.out.println("开始预约");
        seatController.orderSeat(sid, tid);
    }

    @Test
    public void getSeat() throws InterruptedException {

        seatController.orderSeat(sid, tid);
        Thread.sleep(1500);
        System.out.println("开始使用");
        seatController.getSeat(sid, tid, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));

    }

    @Test
    public void outSeat() {
        seatController.outSeat(sid,tid);
    }

    @Test
    public void tempOut() throws InterruptedException {

        getSeat();
        Thread.sleep(1500);
        System.out.println("开始暂离");
        seatController.tempOut(sid, tid, 15);
    }

    @Test
    public void cancelTempOut() throws InterruptedException {
        tempOut();
        System.out.println("取消暂离");
        Thread.sleep(1500);

        seatController.cancelTempOut(sid, tid);
    }
}