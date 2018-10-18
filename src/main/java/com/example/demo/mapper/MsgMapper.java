package com.example.demo.mapper;

import com.example.demo.bean.Msg;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgMapper {

    int deleteByPrimaryKey(Integer mid);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);
}