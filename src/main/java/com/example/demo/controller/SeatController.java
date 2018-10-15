package com.example.demo.controller;

import com.example.demo.service.SeatService;
import com.example.demo.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatController
 * @date 2018/9/19 19:12
 */
@Controller
@ResponseBody
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService seatService;

    /**
     * 学生占座.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ResponseBody
    @RequestMapping(value = "getSeat",method = RequestMethod.POST)
    public Msg getSeat(@RequestParam(value = "sid") String sid,
                           @RequestParam(value = "tid") Integer tid) {
        if(seatService.getSeat(sid,tid)){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 学生还座.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ResponseBody
    @RequestMapping(value = "outSeat",method = RequestMethod.POST)
    public Msg outSeat(@RequestParam(value = "sid") String sid) {

        if(seatService.outSeat(sid)){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 暂离座位.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ResponseBody
    @RequestMapping(value = "tempOut",method = RequestMethod.POST)
    public Msg tempOut(@RequestParam(value = "sid") String sid) {
        if(seatService.tempOut(sid)){
            return Msg.success();
        }
        return Msg.fail();
    }

}
