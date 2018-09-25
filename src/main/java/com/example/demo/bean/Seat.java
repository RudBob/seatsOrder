package com.example.demo.bean;

import java.io.Serializable;

public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 座位id
     */
    private Integer tid;
    /**
     * 区域id
     */
    private Integer rid;
    /**
     * 状态，1表示有人，2表示预约中,3表示检修，0表示可预约.
     */
    private Byte state;
    /**
     * 座位的学生的id
     */
    private String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Byte getState() {
        return state;
    }

    protected void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", rid=").append(rid);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}