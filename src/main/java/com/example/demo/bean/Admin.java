package com.example.demo.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @author ry
 */
@Data
@NoArgsConstructor
public class Admin implements Serializable {
    private Integer aid;

    private String name;

    private String pwd;

    private String role;

    private static final long serialVersionUID = 1L;

}