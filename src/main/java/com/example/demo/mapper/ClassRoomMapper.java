package com.example.demo.mapper;

import com.example.demo.bean.ClassRoom;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ClassRoomMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(ClassRoom record);

    int insertSelective(ClassRoom record);


    ClassRoom selectByPrimaryKey(Integer cid);


    int updateByPrimaryKeySelective(ClassRoom record);

    int updateByPrimaryKey(ClassRoom record);
}