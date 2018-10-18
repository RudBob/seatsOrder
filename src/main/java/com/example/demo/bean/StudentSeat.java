package com.example.demo.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StudentSeat implements Serializable {
    private Integer sTid;

    private String sid;

    private Integer tid;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    private Integer statuss;

    private Boolean res;

    public StudentSeat() {
    }

    private static final long serialVersionUID = 1L;

    public StudentSeat(String sid, Integer tid, LocalDateTime startDatetime, LocalDateTime endDatetime, int status) {
        this.sid = sid;
        this.tid = tid;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.statuss = status;
    }

    public Integer getsTid() {
        return sTid;
    }

    public void setsTid(Integer sTid) {
        this.sTid = sTid;
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

    public LocalDateTime getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(LocalDateTime startDatetime) {
        this.startDatetime = startDatetime;
    }

    public LocalDateTime getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(LocalDateTime endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }

    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sTid=").append(sTid);
        sb.append(", sid=").append(sid);
        sb.append(", tid=").append(tid);
        sb.append(", startDatetime=").append(startDatetime);
        sb.append(", endDatetime=").append(endDatetime);
        sb.append(", statuss=").append(statuss);
        sb.append(", res=").append(res);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}