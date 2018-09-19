package com.example.demo.bean;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: Seat
 * @date 2018/9/19 18:44
 */
public class Seat {
    /**
     * 座位id
     */
    private Integer tid;
    /**
     * 座位对应的教室id
     */
    private Integer cid;
    /**
     * 该座位的状态.
     */
    private Integer state;

    public Seat() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
