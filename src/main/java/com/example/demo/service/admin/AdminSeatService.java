package com.example.demo.service.admin;

import com.example.demo.bean.Seat;
import com.example.demo.mapper.SeatMapper;
import com.example.demo.util.PageInfoConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
     * 座位报修.,TODO
     *
     * @param tid
     */
    public boolean seatNeedRepair(Integer tid) {
        return false;
    }

    /**
     * 座位已经修好了,TODO
     *
     * @param tid
     */
    public boolean hasRepaired(Integer tid) {
        return false;
    }

    public int deleteByPrimaryKey(Integer tid) {
        return seatMapper.deleteByPrimaryKey(tid);
    }

    public int insertSelective() {
        Seat record = new Seat();
        record.setStatuss((byte) 0);
        return seatMapper.insertSelective(record);
    }

    public Seat selectByPrimaryKey(Integer tid) {
        return seatMapper.selectByPrimaryKey(tid);
    }

    public int updateByPrimaryKeySelective(Seat record) {
        return seatMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 通过参数获取对应的seat们
     *
     * @param pid
     * @param tid
     * @param status
     * @return
     */
    public PageInfo<Seat> getSeatsByParam(int pid, Integer tid, Integer status) {
        PageHelper.startPage(pid, PageInfoConstant.PAGE_MAXSIZE);
        PageInfo<Seat> pageInfo = new PageInfo<>(seatMapper.selectByParams(tid, status));
        return pageInfo;
    }
}
