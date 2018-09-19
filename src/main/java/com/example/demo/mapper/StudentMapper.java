package com.example.demo.mapper;

import com.example.demo.bean.Student;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);


    Student selectByPrimaryKey(String sid);



    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}