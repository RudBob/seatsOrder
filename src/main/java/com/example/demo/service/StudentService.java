package com.example.demo.service;

import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: StudentService
 * @date 2018/9/19 19:17
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student login(String username, String password) {
        // TODO MD5加密
        Student student = studentMapper.login(username,password);
        return student;
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
        // TODO MD5加密问题
        //String 之间比较不能使用 ' == '
        //学生密码比对，如果不同，则不更新
        if (student.getPassword().equals(oldPassword)) {
            return false;
        }
        student.setPassword(newPassword);
        studentMapper.updateByPrimaryKey(student);
        return false;
    }
}
