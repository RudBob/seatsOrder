package com.example.demo.controller.admin;

import com.example.demo.bean.FeedBack;
import com.example.demo.service.admin.AdminFeedbackService;
import com.example.demo.util.Msg;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ry
 * 管理员操作反馈信息
 */
@RestController
@Transactional
@RequestMapping("/adminUserLetter")
public class AdminFeedBackController {
    @Autowired
    AdminFeedbackService adminFeedbackService;

    @ApiOperation("展示所有反馈")
    @RequestMapping(value = "getLetters", method = RequestMethod.POST)
    public Msg showFeedBacks(@RequestParam(value = "pNum", required = false, defaultValue = "1") Integer pNum,
                             @RequestParam(value = "mid", required = false) Integer mid) {
        PageInfo<FeedBack> feedBacks = adminFeedbackService.getLettersByParam(pNum, mid);
        return Msg.success().add("lettersPage", feedBacks);
    }
}
