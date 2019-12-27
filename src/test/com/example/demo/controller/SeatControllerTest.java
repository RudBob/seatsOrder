package com.example.demo.controller;

import com.example.demo.util.Msg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeatControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * getForEntity：Get请求，返回实体对象（可以是集合）；
     * postForEntity：Post请求，返回实体对象（可以是集合）；
     * postForObject：Post请求，返回对象；
     */
    @Test
    public void doTest() {
        Msg msg = restTemplate.getForObject("/seat/getSeatId", Msg.class);
        System.out.println(msg);
    }
}
