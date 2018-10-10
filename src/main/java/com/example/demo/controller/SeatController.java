package com.example.demo.controller;

import com.example.demo.service.SeatService;
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
    public boolean getSeat(@RequestParam(value = "sid") String sid,
                           @RequestParam(value = "tid") Integer tid) {
        boolean res = seatService.getSeat(sid, tid);
        return res;
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
    public boolean outSeat(@RequestParam(value = "sid") String sid) {

        boolean res = seatService.outSeat(sid);
        return res;
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
    public boolean tempOut(@RequestParam(value = "sid") String sid) {
        boolean res = seatService.tempOut(sid);
        return res;
    }

}
