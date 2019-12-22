package com.example.demo.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @author ry
 */
@Data
@NoArgsConstructor
public class Seat implements Serializable {
    private Integer tid;

    private Byte statuss;

    private String sid;

    private static final long serialVersionUID = 1L;


}