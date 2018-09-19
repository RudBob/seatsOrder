package com.example.demo.mapper;

import com.example.demo.bean.ClassRoom;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassRoomMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);


    ClassRoom selectByPrimaryKey(Integer cid);


    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);
}