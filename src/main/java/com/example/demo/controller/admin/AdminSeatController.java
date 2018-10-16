package com.example.demo.controller.admin;

import com.example.demo.bean.Seat;
import com.example.demo.service.admin.AdminSeatService;
import com.example.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminSeatController
 * @date 2018/9/24 20:18
 */
@RestController
@RequestMapping("/adminSeat")
public class AdminSeatController {
    @Autowired
    AdminSeatService adminSeatService;

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
    @RequestMapping(value = "deleteSeat", method = RequestMethod.POST)
    public int deleteByPrimaryKey(Integer tid) {
        return adminSeatService.deleteByPrimaryKey(tid);
    }

    @RequestMapping(value = "addSeat", method = RequestMethod.POST)
    public int insertSelective(Seat record) {
        return adminSeatService.insertSelective(record);
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
