package com.example.demo.bean;

import com.example.demo.menu.FeedbackStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ry
 * 用户反馈
 */
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
    private Timestamp feedbackTime;

    /**
     * 反馈的状态
     */
    private FeedbackStatusEnum statusEnum;

    public FeedBack() {
    }

    public FeedBack(Integer mid, String context, String sid) {
        this.mid = mid;
        this.context = context;
        this.sid = sid;
    }

    private static final long serialVersionUID = 1L;

    public FeedBack(String sid, String context) {
        this.sid = sid;
        this.context = context;
        this.feedbackTime = Timestamp.valueOf(LocalDateTime.now());
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Timestamp feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mid=").append(mid);
        sb.append(", context=").append(context);
        sb.append(", sid=").append(sid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}