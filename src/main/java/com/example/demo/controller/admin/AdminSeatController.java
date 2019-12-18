package com.example.demo.controller.admin;

import com.example.demo.bean.Seat;
import com.example.demo.service.admin.AdminSeatService;
import com.example.demo.util.Msg;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminSeatController
 * @date 2018/9/24 20:18
 */
@RestController
@Transactional
@RequestMapping("/adminSeat")
public class AdminSeatController {
    @Autowired
    AdminSeatService adminSeatService;

    /**
     * 通过给定的条件查找对应的
     *
     * @param pid
     * @param tid
     * @return
     */
    @RequestMapping(value = "getSeats", method = RequestMethod.POST)
    public Msg getSeats(@RequestParam(value = "pNum", required = false, defaultValue = "1") Integer pid,
                        @RequestParam(value = "tid", required = false) Integer tid,
                        @RequestParam(value = "status", required = false) Integer status) {
        PageInfo<Seat> seatsPage = adminSeatService.getSeatsByParam(pid, tid, status);
        return Msg.success().add("seatsPage", seatsPage);
    }

    /**
     * 更改座位状态修理
     */
    @RequestMapping(value = "seatNeedRepair", method = RequestMethod.POST)
    public Msg seatNeedRepair(Integer tid) {
        //座位需要修理，
        adminSeatService.seatNeedRepair(tid);
        return Msg.success();
    }

    /**
     * 更改座位状态修理.
     */
    @RequestMapping(value = "seatRepaired", method = RequestMethod.POST)
    public Msg seatRepaired(Integer tid) {
        //座位已经修理.
        adminSeatService.hasRepaired(tid);
        return Msg.success();
    }

    /**
     * 对座位的增删改查
     */
    @RequestMapping(value = "removeSeat", method = RequestMethod.POST)
    public Msg deleteByPrimaryKey(@RequestParam(value = "tid") Integer tid) {
        int len = adminSeatService.deleteByPrimaryKey(tid);
        if (len == 1) {
            return Msg.success();
        } else {
            return Msg.fail().setMsg("位置错误");
        }
    }

    @RequestMapping(value = "addSeat", method = RequestMethod.POST)
    public int insertSelective() {
        return adminSeatService.insertSelective();
    }

    @RequestMapping(value = "getSeatByTid", method = RequestMethod.GET)
    public Seat selectByPrimaryKey(Integer tid) {
        return adminSeatService.selectByPrimaryKey(tid);
    }

    @RequestMapping(value = "updateSeat", method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(Seat record) {
        return adminSeatService.updateByPrimaryKeySelective(record);
    }
}
