package com.example.demo.mapper;

import com.example.demo.bean.Region;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ClassRoomMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(Region record);

    int insertSelective(Region record);


    Region selectByPrimaryKey(Integer cid);


    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}