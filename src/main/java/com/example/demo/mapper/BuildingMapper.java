package com.example.demo.mapper;

import com.example.demo.bean.Building;


import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BuildingMapper {

    int deleteByPrimaryKey(Integer bid);

    int insert(Building record);

    int insertSelective(Building record);


    Building selectByPrimaryKey(Integer bid);


    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}