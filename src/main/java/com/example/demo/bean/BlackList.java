package com.example.demo.bean;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: BlackList
 * @date 2018/9/19 18:43
 */
public class BlackList {
    private Integer sid;
    private LocalDateTime intoDate;

    public BlackList() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public LocalDateTime getIntoDate() {
        return intoDate;
    }

    public void setIntoDate(LocalDateTime intoDate) {
        this.intoDate = intoDate;
    }
}
