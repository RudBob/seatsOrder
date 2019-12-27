package com.example.demo.service;

import com.example.demo.bean.FeedBack;
import com.example.demo.bean.Student;
import com.example.demo.mapper.FeedBackMapper;
import com.example.demo.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FeedBackService {
    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     * 学生反馈
     *
     * @param context 反馈内容
     */
    public boolean feedback(String context) {
        String sid = SessionUtil.getStuFromSession().getSid();
        FeedBack feedBack = new FeedBack(sid, context);
        return feedBackMapper.insert(feedBack) != 0;
    }

    /**
     * 得到学生反馈的内容
     *
     * @return 反馈过的信息
     */
    public List<FeedBack> getStuFeedBack() {
        HttpSession session = SessionUtil.getSession();
        Student stu = (Student) session.getAttribute("user");
        String sid = stu.getSid();
        return feedBackMapper.selectBySid(sid);
    }
}
