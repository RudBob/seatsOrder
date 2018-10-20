package com.example.demo.mapper;

import com.example.demo.bean.StudentSeat;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface StudentSeatMapper {

    int deleteByPrimaryKey(Integer sTid);

    int insert(StudentSeat record);

    int insertSelective(StudentSeat record);

    StudentSeat selectByPrimaryKey(Integer sTid);

    int updateByPrimaryKeySelective(StudentSeat record);

    int updateByPrimaryKey(StudentSeat record);

    List<StudentSeat> selectHistoryBySid(@Param("sid") String sid);

    StudentSeat selectBySidTid(@Param("sid") String sid, @Param("tid") Integer tid, @Param("now") LocalDateTime now);

    default StudentSeat selectBySidTid( String sid, Integer tid) {
        return selectBySidTid(sid, tid, LocalDateTime.now());
    }

    StudentSeat getEndTime(@Param("sid") String sid, @Param("tid") Integer tid);
}