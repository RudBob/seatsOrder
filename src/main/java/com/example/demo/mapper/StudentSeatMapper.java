package com.example.demo.mapper;

import com.example.demo.bean.StudentSeat;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentSeatMapper {

    int deleteByPrimaryKey(Integer sTid);

    int insert(StudentSeat record);

    int insertSelective(StudentSeat record);

    StudentSeat selectByPrimaryKey(Integer sTid);

    int updateByPrimaryKeySelective(StudentSeat record);

    int updateByPrimaryKey(StudentSeat record);
}