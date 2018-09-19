package com.example.demo.bean;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: ClassRoom
 * @date 2018/9/19 18:44
 */
public class ClassRoom {
    /**
     * 教室id
     */
    private Integer cid;
    /**
     * 教室对应的楼的id
     */
    private Integer bid;
    /**
     * 教室所在层数
     */
    private Integer fid;
    /**
     * 教室中的座位数量
     */
    private Integer seatNum;
    /**
     * 教室中已有学生的数量
     */
    private Integer stuNum;
    /**
     * 教室的状态.(可以被禁用)
     */
    private Integer state;

    public ClassRoom() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
