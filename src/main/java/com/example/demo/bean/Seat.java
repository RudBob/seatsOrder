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
    private Byte status;


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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "tid=" + tid +
                ", rid=" + rid +
                ", status=" + status +
                '}';
    }
}