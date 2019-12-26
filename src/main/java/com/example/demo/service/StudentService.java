package com.example.demo.service;

import com.example.demo.bean.Student;
import com.example.demo.bean.StudentSeat;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.StudentSeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 任耀
 * @date 2018/9/19 19:17
 */

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private StudentSeatMapper studentSeatMapper;

    /**
     * 使用密码和用户账号查询用户.
     *
     * @param username 账号
     * @param password 密码
     * @return 学生详情
     */
    public Student login(String username, String password) {
        return studentMapper.login(username, password);
    }

    /**
     * 更新密码
     *
     * @param sid         待修改学生的id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return boolean
     */
    public boolean updatePassword(String sid, String oldPassword, String newPassword) {
        // sid得到学生，
        Student student = studentMapper.selectByPrimaryKey(sid);
        //学生密码比对，如果不同，则不更新
        if (student.getPwd().equals(newPassword)) {
            return false;
        }
        // 更新密码，并放入数据库中
        student.setPwd(newPassword);
        studentMapper.updateByPrimaryKey(student);
        return true;
    }


    /**
     * 通过id查找学生
     *
     * @param sid 学生id
     * @return 学生
     */
    public Student getStudent(String sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    /**
     * 得到学生所有历史
     *
     * @param sid 学生id
     * @return 历史记录
     */
    public List<StudentSeat> getHistory(String sid) {
        return studentSeatMapper.selectHistoryBySid(sid);
    }
}
