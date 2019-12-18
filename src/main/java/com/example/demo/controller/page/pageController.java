package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description: 算是某种过滤器fliter，管理跳转class
 *
 * @author 任耀
 * @ClassName: pageController
 * @date 2018/10/13 18:19
 */
@Controller
public class pageController {

    @GetMapping(value = "/admin")
    public String intoAdmin() {
        return "/admin";
    }

    @GetMapping(value = "/adminSeat")
    public String intoAdminSeat() {
        return "/adminSeat";
    }

    @GetMapping(value = "/adminStudent")
    public String intoAdminStudent() {
        return "/adminStudent";
    }

    @GetMapping(value = "/continue_seat")
    public String intoContinueSeat() {
        return "/continue_seat";
    }

    @GetMapping(value = "/order_seat")
    public String intoFastOrder() {
        return "/order_seat";
    }

    @GetMapping(value = "/home_page")
    public String intoHomePage() {
        return "/home_page";
    }


    @GetMapping(value = "/user_letters")
    public String intoUserLetters() {
        return "/user_letters";
    }

    @GetMapping(value = "/seat_flat")
    public String intoSeatFlat() {
        return "/seat_flat";
    }

    @GetMapping(value = "/personal")
    public String intoPersonal() {
        return "/personal";
    }
}
