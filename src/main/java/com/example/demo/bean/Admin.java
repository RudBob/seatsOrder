package com.example.demo.bean;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: Admin
 * @date 2018/9/19 18:43
 */
public class Admin {
    /**
     * 管理员id
     */
    private Integer aid;
    /**
     * 管理员姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 管理员权限(TODO,暂定)
     */
    private Integer role;

    public Admin() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
