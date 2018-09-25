package com.example.demo.bean;

/**
 * Description: 作为Seat的伴随类，提供给Seat的状态改变.
 *
 * @author 任耀
 * @ClassName: Seats
 * @date 2018/9/25 10:26
 */
public class Seats {
    /**
     * 座位的各种状态码.
     * 0代表可以使用
     * 1代表已经预约
     * 2代表有人使用
     * 3代表暂离座位
     * 4代表维修中.
     * 5代表其他.
     */
    private static final byte CAN_USE = 0;
    private static final byte HasOrder = 1;
    private static final byte HAS_ONE = 2;
    private static final byte TEMP_OUT = 3;
    private static final byte WAIT_REPAIR = 4;
    private static final byte ORTHERS = 5;

    /**
     * 正在被预约
     *
     * @param seat
     */
    public static void seatHasOrder(Seat seat) {
        seat.setState(HasOrder);
    }

    /**
     * 这个座位可以使用了
     *
     * @param seat
     */
    public static void waitingUse(Seat seat) {
        seat.setState(CAN_USE);
    }

    /**
     * 座位有人了
     */
    public static void useing(Seat seat) {
        seat.setState(HAS_ONE);
    }

    /**
     * 位置主人暂时离开了
     */
    public static void tempOut(Seat seat) {
        seat.setState(TEMP_OUT);
    }

    /**
     * 座位除了问题,需要修理
     */
    public static void waitRepair(Seat seat) {
        seat.setState(WAIT_REPAIR);
    }

    /**
     * 其他原因导致座位不可以使用
     */
    public static void otherReasons(Seat seat) {
        seat.setState(ORTHERS);
    }

}
