package com.example.demo.bean;

import com.example.demo.menu.FeedbackStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ry
 * 用户反馈
 */
@Data
@NoArgsConstructor
public class FeedBack implements Serializable {
    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 学生反馈的具体内容
     */
    private String context;

    /**
     * 反馈学生的id
     */
    private String sid;

    /**
     * 反馈时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp feedbackTime;

    /**
     * 反馈的状态
     */
    private FeedbackStatusEnum statusEnum;


    private static final long serialVersionUID = 1L;

    public FeedBack(String sid, String context) {
        this.sid = sid;
        this.context = context;
        this.feedbackTime = Timestamp.valueOf(LocalDateTime.now());
    }

}