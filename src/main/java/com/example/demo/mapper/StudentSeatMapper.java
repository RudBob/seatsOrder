package com.example.demo.mapper;

import com.example.demo.bean.StudentSeat;
import com.example.demo.bean.StudentSeatExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StudentSeatMapper {

    int deleteByPrimaryKey(Integer sTid);

    int insert(StudentSeat record);

    int insertSelective(StudentSeat record);


    StudentSeat selectByPrimaryKey(Integer sTid);


    int updateByPrimaryKeySelective(StudentSeat record);

    int updateByPrimaryKey(StudentSeat record);
}