package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: pageController
 * @date 2018/10/13 18:19
 */
@Controller
public class pageController {

    /**
     * 默认跳转
     *
     * @return
     */
//    @GetMapping(value = "/")
//    public String intoIndex() {
//        return "/index";
//    }
    @GetMapping(value = "/admin")
    public String intoAdmin() {
        return "/admin";
    }

    @GetMapping(value = "/continue_seat")
    public String intoContinueSeat() {
        return "/continue_seat";
    }

    @GetMapping(value = "/fast_order")
    public String intoFastOrder() {
        return "/fast_order";
    }

    @GetMapping(value = "/home_page")
    public String intoHomePage() {
        return "/home_page";
    }


    @GetMapping(value = "/user_letters")
    public String intoUserLetters() {
        return "/user_letters";
    }


}
