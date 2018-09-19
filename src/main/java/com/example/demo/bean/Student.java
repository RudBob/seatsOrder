package com.example.demo.bean;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: Student
 * @date 2018/9/19 18:44
 */
public class Student {
    /**
     * 学号
     */
    private String sid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 黑名单
     */
    private Integer stuState;

    /**
     * 座位id
     */
    private Integer tid;

    public Student() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStuState() {
        return stuState;
    }

    public void setStuState(int stuState) {
        this.stuState = stuState;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
