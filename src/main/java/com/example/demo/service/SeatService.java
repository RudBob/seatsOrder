package com.example.demo.service;

import com.example.demo.bean.Seat;
import com.example.demo.bean.Seats;
import com.example.demo.bean.Student;
import com.example.demo.mapper.SeatMapper;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: SeatService
 * @date 2018/9/19 19:17
 */
@Service
public class SeatService {
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    StudentMapper studentMapper;

    /**
     * 学生预约座位.
     *
     * @param sid
     * @param tid
     * @return
     */
    public boolean getSeat(String sid, Integer tid) {
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        if (seat.getState() == 0) {
            Student student = studentMapper.selectByPrimaryKey(sid);
            if (student.getState() == 0) {
                // 改变学生，座位的状态.
                orderSuccess(seat, student);
                return true;
            } else {
                // TODO 学生的状态为黑名单ing,不可预约.
                return false;
            }
        } else {
            // TODO 此时座位的状态为不可预约
            return false;
        }
    }

    /**
     * 学生可以预约座位，改变双方的状态
     *
     * @param seat
     * @param student
     */
    private void orderSuccess(Seat seat, Student student) {
        // 更新
        Seats.seatHasOrder(seat);
        student.setState(1);
        student.setTid(seat.getTid());
        updateSeat_Student(seat, student);
    }

    /**
     * 学生还座
     *
     * @param sid
     * @return
     */
    public boolean outSeat(String sid) {
        Student student = studentMapper.selectByPrimaryKey(sid);
        Seat seat = seatMapper.selectByPrimaryKey(student.getTid());
        if (student.getState() != 0 && seat.getState() != 0) {
            outSuccess(seat, student);
            return true;
        }
        return false;
    }

    /**
     * 用户还座成功，更改各种状态.
     *
     * @param seat
     * @param student
     */
    private void outSuccess(Seat seat, Student student) {
        Seats.waitingUse(seat);
        student.setTid(0);
        student.setState(0);
        updateSeat_Student(seat, student);
    }

    /**
     * 暂离座位.
     *
     * @param sid
     * @return
     */
    public boolean tempOut(String sid) {
        Student student = studentMapper.selectByPrimaryKey(sid);
        Seat seat = seatMapper.selectByPrimaryKey(student.getTid());
        // 暂离座位.
        student.setState(2);
        Seats.tempOut(seat);
        updateSeat_Student(seat, student);
        return false;
    }

    /**
     * 更新学生与座位之间的状态.
     *
     * @param seat
     * @param student
     */
    private void updateSeat_Student(Seat seat, Student student) {
        seatMapper.updateByPrimaryKey(seat);
        studentMapper.updateByPrimaryKey(student);
    }

}
