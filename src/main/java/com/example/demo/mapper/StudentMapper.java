package com.example.demo.mapper;

import com.example.demo.bean.Student;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(@Param("sid") String sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    Student login(@Param("username") String username, @Param("password") String password);
}