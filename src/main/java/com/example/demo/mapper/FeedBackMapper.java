package com.example.demo.mapper;


import com.example.demo.bean.FeedBack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ry
 */
@Mapper
public interface FeedBackMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    FeedBack selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);

    List<FeedBack> selectAll();

    List<FeedBack> selectBySid(@Param("sid") String sid);

    List<FeedBack> getLettersByParam(@Param("mid") Integer mid);
}