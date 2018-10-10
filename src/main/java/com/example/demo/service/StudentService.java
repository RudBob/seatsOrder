package com.example.demo.service;

import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.util.Md5;
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
        // MD5加密
        String dbPassword = Md5.EncoderByMd5(password);
        // 使用加密后的密码和用户账号查询用户.
        Student student = studentMapper.login(username,dbPassword);
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
        String dbOldPassword = Md5.EncoderByMd5(oldPassword);
        //tip: String 之间比较不能使用 ' == '
        //学生密码比对，如果不同，则不更新
        if (student.getPwd().equals(dbOldPassword)) {
            return false;
        }
        // 加密新密码并set到密码行.
        String dbNewPassword = Md5.EncoderByMd5(newPassword);
        student.setPwd(dbNewPassword);
        studentMapper.updateByPrimaryKey(student);
        return false;
    }

    public Student logout(String sid) {

        return null;
    }
}
