package com.example.demo.bean;

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

}