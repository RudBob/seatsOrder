package com.example.demo.service.admin;

import com.example.demo.bean.FeedBack;
import com.example.demo.mapper.FeedBackMapper;
import com.example.demo.util.PageInfoConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ry
 */
@Service
public class AdminFeedbackService {
    @Autowired
    FeedBackMapper feedBackMapper;

    /**
     * 展示所有反馈
     *
     * @return
     */
    public List<FeedBack> showFeedBacks() {
        List<FeedBack> feedBacks = feedBackMapper.selectAll();
        return feedBacks;
    }

    /**
     * 分页获取用户反馈
     *
     * @param pNum
     * @param mid
     * @return
     */
    public PageInfo<FeedBack> getLettersByParam(Integer pNum, Integer mid) {
        PageHelper.startPage(pNum, PageInfoConstant.PAGE_MAXSIZE);
        PageInfo<FeedBack> feedBackPageInfo = new PageInfo<>(feedBackMapper.getLettersByParam(mid));
        return feedBackPageInfo;
    }
}
