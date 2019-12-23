package com.example.demo.bean;

import com.example.demo.util.SessionUtil;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Student implements Serializable {
    private String sid;

    private String name;

    private String pwd;

    private Integer statuss;

    private Integer tid;

    private static final long serialVersionUID = 1L;

    /**
     * 在这里更新session
     *
     * @param status 状态码
     */
    public void setStatuss(Integer status) {
        this.statuss = status;
        SessionUtil.updateUserFromDB(this);
    }
}