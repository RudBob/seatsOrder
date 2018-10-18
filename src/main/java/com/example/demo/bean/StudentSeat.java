package com.example.demo.bean;

import com.example.demo.util.BaseData;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentSeat implements Serializable {
    private Integer STid;

    private String sid;

    private Integer tid;

    private LocalDateTime beginDatetime;

    private LocalDateTime endDatetime;
    /**
     * 相应的状态码啊在BaseDatSetting 中进行了定义
     *
     * @see BaseData
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public StudentSeat(String sid, Integer tid, LocalDateTime startDatetime, LocalDateTime endDatetime, Integer stuSeatUsing) {
        this.sid = sid;
        this.tid = tid;
        this.beginDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.status = stuSeatUsing;
    }

    public Integer getSTid() {
        return STid;
    }

    public void setSTid(Integer STid) {
        this.STid = STid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public LocalDateTime getBeginDatetime() {
        return beginDatetime;
    }

    public void setBeginDatetime(LocalDateTime beginDatetime) {
        this.beginDatetime = beginDatetime;
    }

    public LocalDateTime getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(LocalDateTime endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentSeat{" +
                "STid=" + STid +
                ", sid='" + sid + '\'' +
                ", tid=" + tid +
                ", beginDatetime=" + beginDatetime +
                ", endDatetime=" + endDatetime +
                '}';
    }
}