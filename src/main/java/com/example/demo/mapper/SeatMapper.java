package com.example.demo.mapper;

import com.example.demo.bean.Seat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SeatMapper {

    int deleteByPrimaryKey(Integer tid);

    int insert(Seat record);

    int insertSelective(Seat record);


    Seat selectByPrimaryKey(Integer tid);

    /**
     * 部分更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Seat record);

    /**
     * 更新Seat
     * @param record
     * @return
     */
    int updateByPrimaryKey(Seat record);

    /**
     * 得到无人使用的空座
     * @return
     */
    Seat getUnusingSeat();
}