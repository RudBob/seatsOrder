package com.example.demo.bean;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: Building
 * @date 2018/9/19 18:44
 */
public class Building {
    /**
     * 楼号
     */
    private Integer bid;
    /**
     * 楼名
     */
    private String bname;
    /**
     * 最大层数
     */
    private Integer maxFloor;
    /**
     * 楼的状态
     */
    private Integer state;

    public Building() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(Integer maxFloor) {
        this.maxFloor = maxFloor;
    }
}
