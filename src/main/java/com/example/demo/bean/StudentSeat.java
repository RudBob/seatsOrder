package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StudentSeat implements Serializable {
    private Integer stid;

    private String sid;

    private Integer tid;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDatetime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDatetime;

    private Integer statuss;

    private Boolean res;

    private static final long serialVersionUID = 1L;

    public StudentSeat(String sid, Integer tid, LocalDateTime startDatetime, LocalDateTime endDatetime, int status) {
        this.sid = sid;
        this.tid = tid;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.statuss = status;
    }

}