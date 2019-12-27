package com.example.demo.mapper;

import com.example.demo.bean.Seat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ry
 */
@Mapper
public interface SeatMapper {
    /**
     * @param tid
     * @return
     */
    int deleteByPrimaryKey(Integer tid);

    /**
     * @param record
     * @return
     */
    int insert(Seat record);

    /**
     * @param record
     * @return
     */
    int insertSelective(Seat record);

    /**
     * @param tid
     * @return
     */

    Seat selectByPrimaryKey(Integer tid);

    /**
     * 部分更新
     */
    int updateByPrimaryKeySelective(Seat record);

    /**
     * 更新Seat
     */
    int updateByPrimaryKey(Seat record);

    /**
     * 得到无人使用的空座
     */
    List<Seat> getUnusingSeat();

    /**
     * 通过传入的参数选择状态
     */
    List<Seat> selectByParams(@Param(value = "tid") Integer tid, @Param(value = "status") Integer status);
}