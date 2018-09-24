package com.example.demo.bean;

import java.io.Serializable;

public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 座位id
     */
    private Integer tid;
    /**
     * 教室id
     */
    private Integer crid;
    /**
     * 状态，1表示有人，2表示预约中,3表示检修，0表示可预约.
     */
    private Byte state;
    /**
     * 座位的各种状态码.
     * 0代表可以使用
     * 1代表预约ing
     * 2代表有人使用
     * 3代表暂离座位
     * 4代表维修中.
     * 5代表其他.
     */
    public static final int CAN_USE = 0;
    public static final int ODERING = 1;
    public static final int HAS_ONE = 2;
    public static final int TEMP_OUT = 3;
    public static final int REPAIR = 4;
    public static final int ORTHERS = 5;

    /**
     *  以下为座位的状态改变.
     */
    public void beginOrder(){
        this.state = ODERING;
    }

    public void endOrder(){
        this.state = CAN_USE;
    }


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCrid() {
        return crid;
    }

    public void setCrid(Integer crid) {
        this.crid = crid;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", crid=").append(crid);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}