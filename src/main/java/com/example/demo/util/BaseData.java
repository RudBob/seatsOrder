package com.example.demo.util;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: BaseData
 * @date 2018/10/17 21:01
 */
public class BaseData {
    /**
     * 正常时的状态码
     */
    public static final int STU_CAN_USE_AGAIN = 0;
    /**
     * 学生正在使用座位的状态码.
     */
    public static final int STU_USING = 1;
    /**
     * 学生暂停使用的状态码
     */
    public static final int STU_PAUSE = 3;

    /**
     * 学生预约座位时的状态码
     */
    public static final int STU_ORDERING = 2;
    /**
     * 学生 使用 座位的关联状态码
     */
    public static final int STU_SEAT_USING = 1;
    /**
     * 学生 预定 座位的关联状态码
     */
    public static final int STU_SEAT_ORDERING = 2;



    /**
     * 学生 暂离 座位的关联关联状态码
     */
    public static final int STU_SEAT_TEMP_OUT = 3;


    /**
     * 座位的各种状态码.
     * 0代表可以使用
     * 1代表有人使用
     * 2代表已经预约
     * 3代表暂离座位
     * 4代表维修中.
     * 5代表其他.
     */
    public static final byte SEAT_CAN_USE_AGAIN = 0;
    public static final byte SEAT_USING = 1;
    public static final byte SEAT_ORDERING = 2;
    public static final byte SEAT_TEMP_OUT = 3;
    public static final byte SEAT_WAIT_REPAIR = 4;
    public static final byte SEAT_ORTHERS = 5;

    // 单位为分钟
    public static final int ORDER_TIME = 15;
}
