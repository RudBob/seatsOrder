package com.example.demo.service.admin;

import com.example.demo.bean.Seat;
import com.example.demo.bean.Seats;
import com.example.demo.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminSeatService
 * @date 2018/9/24 17:38
 */
@Service
public class AdminSeatService {
    @Autowired
    private SeatMapper seatMapper;


    /**
     * 座位报修.
     *
     * @param tid
     */
    public boolean seatNeedRepair(Integer tid) {
        Seat seat = selectByPrimaryKey(tid);
        if (seat != null) {
            // 更改状态码
            Seats.waitRepair(seat);
            // 直接调用update语句
            seatMapper.updateByPrimaryKey(seat);
            return true;
        }
        // 抛出异常,座位不存在
        return false;
    }

    /**
     * 座位已经修好了
     *
     * @param tid
     */
    @RequestMapping(value = "")
    public boolean hasRepaired(Integer tid) {
        Seat seat = selectByPrimaryKey(tid);
        if (seat != null) {
            // 更改状态码
            Seats.waitingUse(seat);
            // 直接调用update语句
            seatMapper.updateByPrimaryKey(seat);
            return true;
        }
        // 查不到
        return false;
    }

    public int deleteByPrimaryKey(Integer tid) {
        return seatMapper.deleteByPrimaryKey(tid);
    }

    public int insertSelective(Seat record) {
        return seatMapper.insertSelective(record);
    }

    public Seat selectByPrimaryKey(Integer tid) {
        return seatMapper.selectByPrimaryKey(tid);
    }

    public int updateByPrimaryKeySelective(Seat record) {
        return seatMapper.updateByPrimaryKeySelective(record);
    }

}
