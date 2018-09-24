package com.example.demo.service.admin;

import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminStudentSerbice
 * @date 2018/9/24 17:35
 */
@Service
public class AdminStudentService {
    @Autowired
    StudentMapper studentMapper;
    /**
     * 拉黑学生，默认为时一周
     * @param sid
     */
    public void blockStudent(String sid, Integer blockDays) {

    }

}
