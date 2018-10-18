package com.example.demo.service;

import com.example.demo.bean.Student;
import com.example.demo.mapper.FeedBackMapper;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
    private StudentMapper studentMapper;
    @Autowired
    private FeedBackMapper msgMapper;

    public Student login(String username, String password, HttpSession session) {
        // 使用密码和用户账号查询用户.
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

    public boolean feedback(String sid, String context) {
//        FeedBack
        return false;
    }
}
