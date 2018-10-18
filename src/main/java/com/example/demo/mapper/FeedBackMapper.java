package com.example.demo.mapper;


import com.example.demo.bean.FeedBack;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedBackMapper {
   int deleteByPrimaryKey(Integer mid);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
}