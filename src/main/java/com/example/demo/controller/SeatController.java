package com.example.demo.controller;

import com.example.demo.bean.Seat;
import com.example.demo.bean.Student;
import com.example.demo.service.SeatService;
import com.example.demo.util.Msg;
import com.example.demo.util.SessionUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Description:
 *
 * @author 任耀
 * @date 2018/9/19 19:12
 */
@RestController
@Transactional
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService seatService;


    /**
     * 学生预约座位.
     *
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("预约座位，默认该预约保留15分钟")
    @RequestMapping(value = "orderSeat", method = RequestMethod.POST)
    public Msg orderSeat(@RequestParam(value = "tid") Integer tid) {
        boolean res = seatService.orderSeat( tid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 得到一个没有被使用的座位id
     */
    @ApiOperation("随机找到一个空座位")
    @RequestMapping(value = "getSeatId", method = RequestMethod.GET)
    public Msg getSeatId() {
        Seat seat = seatService.getSeatId();
        if (seat != null) {
            return Msg.success().add("seatId", seat.getTid());
        }
        return Msg.fail().setMsg("图书馆已满，请稍后重试");
    }

    /**
     * 取消预约
     */
    @ApiOperation("取消预约")
    @RequestMapping(value = "cancelOrder", method = RequestMethod.POST)
    public Msg cancelOrder(@RequestParam(value = "sid") String sid,
                           @RequestParam(value = "tid") Integer tid) {
        seatService.cancelOrder(sid, tid);
        return Msg.success();
    }

    /**
     * 续坐
     */
    @ApiOperation("续坐")
    @RequestMapping(value = "addTime", method = RequestMethod.POST)
    public Msg addTime(@RequestParam(value = "sid") String sid,
                       @RequestParam(value = "tid") Integer tid,
                       @RequestParam(value = "addHours") Integer addHours,
                       @RequestParam(value = "addMinutes", required = false, defaultValue = "0") Integer addMinutes) {

        boolean res = seatService.addTime(sid, tid, addHours, addMinutes);
        if (res) {
            return Msg.success();
        }
        return Msg.fail().setMsg("出现未知错误，请尽快联系管理员查看");
    }

    /**
     * 学生占座.
     *
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("开始使用座位")
    @RequestMapping(value = "getSeat", method = RequestMethod.POST)
    public Msg getSeat(@RequestParam(value = "sid") String sid,
                       @RequestParam(value = "tid") Integer tid,
                       @RequestParam(value = "useHours") Integer hours,
                       @RequestParam(value = "useMinutes") Integer minutes) {
        LocalDateTime startDatetime = LocalDateTime.now();
        LocalDate endDate = startDatetime.toLocalDate();
        LocalTime endTime = startDatetime.toLocalTime().plusHours(hours).plusMinutes(minutes);
        LocalDateTime endDatetime = LocalDateTime.of(endDate, endTime);
        boolean res = seatService.getSeat(sid, tid, startDatetime, endDatetime);
        if (res) {
            return Msg.success();
        }
        return Msg.fail().setMsg("出现未知错误，请尽快联系管理员查看");
    }

    /**
     * 学生还座.
     *
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("离开座位")
    @RequestMapping(value = "outSeat", method = RequestMethod.POST)
    public Msg outSeat(@RequestParam(value = "sid") String sid,
                       @RequestParam(value = "tid") Integer tid) {
        boolean res = seatService.outSeat(sid, tid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail().setMsg("出现未知错误，请联系管理员");
    }

    /**
     * 暂离座位.
     *
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("暂离座位")
    @RequestMapping(value = "tempOut", method = RequestMethod.POST)
    public Msg tempOut(@RequestParam(value = "sid") String sid,
                       @RequestParam(value = "tid") Integer tid,
                       @RequestParam(value = "outTimeMinutes", required = false, defaultValue = "15") Integer outTimeMinutes) {
        boolean res = seatService.tempOut(sid, tid, outTimeMinutes);
        if (res) {
            return Msg.success();
        }
        return Msg.fail().setMsg("请先使用座位");
    }

    /**
     * 暂离座位.
     *
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("结束暂离座位")
    @RequestMapping(value = "cancelTempOut", method = RequestMethod.POST)
    public Msg cancelTempOut(@RequestParam(value = "sid") String sid,
                             @RequestParam(value = "tid") Integer tid) {
        boolean res = seatService.cancelTempOut(sid, tid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
