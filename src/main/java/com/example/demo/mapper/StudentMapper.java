package com.example.demo.mapper;

import com.example.demo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student login(@Param("name") String username, @Param("pwd") String password);

    List<Student> selectByParam(@Param("sid") Integer sid,@Param("status") Integer status);

}