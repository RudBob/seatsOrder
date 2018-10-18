package com.example.demo.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private String sid;


    private String name;

    private String pwd;
    /**
     * 0 为正常
     * 1 为使用中
     * 2 为暂停使用
     */
    private Integer state;

    private Integer tid;

    private static final long serialVersionUID = 1L;

    public Student() {
    }

    public Student(String username, String pwd) {
        this.name = username;
        this.pwd = pwd;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", tid=" + tid +
                '}';
    }
}