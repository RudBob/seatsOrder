package com.example.demo.service;

import com.example.demo.bean.FeedBack;
import com.example.demo.mapper.FeedBackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {
    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     * 学生反馈
     *
     * @param sid     学生id
     * @param context 反馈内容
     * @return
     */
    public boolean feedback(String sid, String context) {
        FeedBack feedBack = new FeedBack(sid, context);
        return feedBackMapper.insert(feedBack) != 0;
    }

    /**
     * 得到学生反馈的内容
     *
     * @param sid 学生id
     * @return 反馈过的信息
     */
    public List<FeedBack> getStuFeedBack(String sid) {
        List<FeedBack> feedBacks = feedBackMapper.selectBySid(sid);
        return feedBacks;
    }
}
