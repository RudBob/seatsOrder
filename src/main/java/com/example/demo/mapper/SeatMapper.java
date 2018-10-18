package com.example.demo.mapper;

import com.example.demo.bean.Seat;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeatMapper {

    int deleteByPrimaryKey(Integer tid);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);
}