package com.example.demo.controller.admin;

import com.example.demo.bean.Seat;
import com.example.demo.service.admin.AdminSeatService;
import com.example.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public boolean seatNeedRepair(Integer tid){
        //座位需要修理，
        boolean result =  adminSeatService.seatNeedRepair(tid);
        return result;
    }
    /**
     * 更改座位状态修理.
     */
    public Msg seatHasRepaired(Integer tid){
        //座位已经修理.
        adminSeatService.hasRepaired(tid);
        return Msg.success();
    }

    /**
     * 对座位的增删改查
     */
    public int deleteByPrimaryKey(Integer tid) {
        return adminSeatService.deleteByPrimaryKey(tid);
    }

    public int insertSelective(Seat record) {
        return adminSeatService.insertSelective(record);
    }

    public Seat selectByPrimaryKey(Integer tid) {
        return adminSeatService.selectByPrimaryKey(tid);
    }

    public int updateByPrimaryKeySelective(Seat record) {
        return adminSeatService.updateByPrimaryKeySelective(record);
    }
}