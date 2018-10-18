package com.example.demo.mapper;

import com.example.demo.bean.Admin;


import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AdminMapper {

    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin login(String username, String password);
}