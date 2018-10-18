package com.example.demo.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private String sid;

    private String name;

    private String pwd;

    private Integer statuss;

    private Integer tid;

    private static final long serialVersionUID = 1L;

    public Student(String sid, String name, String pwd, int statuss) {
        this.sid = sid;
        this.name = name;
        this.pwd = pwd;
        this.statuss = statuss;
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

    public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", name=").append(name);
        sb.append(", pwd=").append(pwd);
        sb.append(", statuss=").append(statuss);
        sb.append(", tid=").append(tid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}