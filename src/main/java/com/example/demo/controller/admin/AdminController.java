package com.example.demo.controller.admin;

import com.example.demo.bean.FeedBack;
import com.example.demo.service.AdminService;
import com.example.demo.util.Msg;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.SecretKey;
import java.util.List;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminController
 * @date 2018/9/19 19:09
 */

@RestController
@Transactional
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ApiOperation("展示所有反馈")
    @RequestMapping(value = "showFeedBacks", method = RequestMethod.GET)
    public Msg showFeedBacks() {
        List<FeedBack> feedBacks = adminService.showFeedBacks();
        return Msg.success().add("feedBacks", feedBacks);
    }


}
