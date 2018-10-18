package com.example.demo.bean;

import java.io.Serializable;

public class Seat implements Serializable {
    private Integer tid;

    private Integer rid;

    private Byte statuss;

    private String sid;

    public Seat() {
    }

    private static final long serialVersionUID = 1L;

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

    public Byte getStatuss() {
        return statuss;
    }

    public void setStatuss(Byte statuss) {
        this.statuss = statuss;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", rid=").append(rid);
        sb.append(", statuss=").append(statuss);
        sb.append(", sid=").append(sid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}