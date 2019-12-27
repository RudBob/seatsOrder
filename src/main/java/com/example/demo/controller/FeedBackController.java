package com.example.demo.controller;

import com.example.demo.bean.FeedBack;
import com.example.demo.bean.Student;
import com.example.demo.service.FeedBackService;
import com.example.demo.util.Msg;
import com.example.demo.util.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api("反馈的相关操作---任耀")
@RestController
@Transactional
public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;

    /**
     * @param context 反馈正文，String类型，所以不接受文本
     */
    @ApiOperation("学生反馈")
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public Msg feedback(@RequestParam(value = "context") String context) {
        if (feedBackService.feedback(context)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 学生查看自己的反馈
     */
    @ApiOperation("学生查看自己的反馈")
    @RequestMapping(value = "/getStuFeedBack", method = RequestMethod.GET)
    public Msg getStuFeedBack() {
        List<FeedBack> feedBacks = feedBackService.getStuFeedBack();
        return Msg.success().add("stuFeedBack", feedBacks);
    }

}
