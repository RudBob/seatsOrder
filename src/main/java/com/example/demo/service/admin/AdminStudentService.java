package com.example.demo.service.admin;

import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.util.PageInfoConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     *
     * @param sid
     */
    public int blockStudent(String sid, Integer blockDays) {
        return 0;
    }

    /**
     * 删！
     *
     * @param sid
     * @return
     */
    public int deleteStudent(String sid) {
        return studentMapper.deleteByPrimaryKey(sid);
    }

    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    public Student getStudentById(String sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    /**
     * 查询
     *
     * @param pNum   页码
     * @param sid    学生编号
     * @param status 状态
     * @return
     */
    public PageInfo<Student> getStuByParam(Integer pNum, Integer sid, Integer status) {
        PageHelper.offsetPage(pNum, PageInfoConstant.PAGE_MAXSIZE);
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentMapper.selectByParam(sid, status));
        return studentPageInfo;
    }
}
