package com.example.demo.controller;

import com.example.demo.bean.Seat;
import com.example.demo.service.SeatService;
import com.example.demo.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatController
 * @date 2018/9/19 19:12
 */
@RestController
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
     * 得到一个没有被使用的座位id
     *
     * @return
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
     * TODO
     */
    @ApiOperation("取消预约")
    @RequestMapping(value = "cancelOrder", method = RequestMethod.POST)
    public Msg cancelOrder(@RequestParam(value = "sid", required = true) String sid,
                           @RequestParam(value = "tid", required = true) Integer tid) {

        return Msg.success();
    }
    /**
     * TODO
     * 续坐
     */
    @ApiOperation("续坐")
    @RequestMapping(value = "addTime", method = RequestMethod.POST)
    public Msg addTime(@RequestParam(value = "sid", required = true) String sid,
                           @RequestParam(value = "tid", required = true) Integer tid) {

        return Msg.success();
    }
    /**
     * 学生占座.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("开始使用座位")
    @RequestMapping(value = "getSeat", method = RequestMethod.POST)
    public Msg getSeat(@RequestParam(value = "sid", required = true) String sid,
                       @RequestParam(value = "tid", required = true) Integer tid,
                       @RequestParam(value = "startDatetime", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDatetime,
                       @RequestParam(value = "endDatetime", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDatetime) {
        boolean res = seatService.getSeat(sid, tid, startDatetime, endDatetime);
        if (res) {
            return Msg.success();
        }
        return Msg.fail().setMsg("出现未知错误，请尽快联系管理员查看");
    }

    /**
     * 学生还座.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("离开座位")
    @RequestMapping(value = "outSeat", method = RequestMethod.POST)
    public Msg outSeat(@RequestParam(value = "sid", required = true) String sid,
                       @RequestParam(value = "tid", required = true) Integer tid) {
        boolean res = seatService.outSeat(sid, tid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail().setMsg("出现未知错误，请联系管理员");
    }

    /**
     * 暂离座位.
     *
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("暂离座位")
    @RequestMapping(value = "tempOut", method = RequestMethod.POST)
    public Msg tempOut(@RequestParam(value = "sid", required = true) String sid,
                       @RequestParam(value = "tid", required = true) Integer tid,
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
     * @return
     * @Param sid 学生id。
     * @Param tid 座位id
     */
    @ApiOperation("结束暂离座位")
    @RequestMapping(value = "cancelTempOut", method = RequestMethod.POST)
    public Msg cancelTempOut(@RequestParam(value = "sid", required = true) String sid,
                             @RequestParam(value = "tid", required = true) Integer tid) {
        boolean res = seatService.cancelTempOut(sid, tid);
        if (res) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
