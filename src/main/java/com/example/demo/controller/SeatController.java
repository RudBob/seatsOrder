package com.example.demo.controller;

import com.example.demo.service.SeatService;
import com.example.demo.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatController
 * @date 2018/9/19 19:12
 */
@Controller
@ResponseBody
@Transactional
@RequestMapping("/seat")
@Api(description = "座位相关操作-----任耀")
public class SeatController {
    @Autowired
    SeatService seatService;

    /**
     * 学生预约座位.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("预约座位，默认该预约保留15分钟")
    @ResponseBody
    @RequestMapping(value = "orderSeat", method = RequestMethod.POST)
    public Msg orderSeat(@RequestParam(value = "sid", required = true) String sid,
                         @RequestParam(value = "tid", required = true) Integer tid) {
        boolean res = seatService.orderSeat(sid, tid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 学生占座.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ResponseBody

    @RequestMapping(value = "getSeat", method = RequestMethod.POST)
    public Msg getSeat(@RequestParam(value = "sid", required = true) String sid,
                            @RequestParam(value = "tid", required = true) Integer tid,
                            @RequestParam(value = "startDatetime", required = true) LocalDateTime startDatetime,
                            @RequestParam(value = "endDatetime", required = true) LocalDateTime endDatetime) {
        boolean res = seatService.getSeat(sid, tid, startDatetime, endDatetime);
        if (res) {
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
    @RequestMapping(value = "outSeat", method = RequestMethod.POST)
    public Msg outSeat(@RequestParam(value = "sid", required = true) String sid,
                            @RequestParam(value = "timeOfTempOut", required = true) LocalDateTime timeOfTempOut) {
        boolean res = seatService.outSeat(sid, timeOfTempOut);
        if (res) {
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
    @RequestMapping(value = "tempOut", method = RequestMethod.POST)
    public Msg tempOut(@RequestParam(value = "sid", required = true) String sid) {
        boolean res = seatService.tempOut(sid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }

}
