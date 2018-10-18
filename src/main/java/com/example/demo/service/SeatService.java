package com.example.demo.service;

import com.example.demo.bean.Seat;
import com.example.demo.bean.Student;
import com.example.demo.bean.StudentSeat;
import com.example.demo.mapper.SeatMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.StudentSeatMapper;
import com.example.demo.util.BaseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Autowired
    StudentSeatMapper studentSeatMapper;


    /**
     * @param sid 学生id，用来得到并改变学生的状态码
     * @param tid 座位id，用来得到并改变座位的状态码
     * @return Boolean      双id是否合法并是否更改成功
     * @despriction 预约座位.
     */
    public Boolean orderSeat(String sid, Integer tid) {
        // 得到学生和座位的详情.
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        Student stu = studentMapper.selectByPrimaryKey(sid);
        LocalDateTime startDatetime = LocalDateTime.now();
        // 预约保留时长:@see BaseData.ORDER_TIME
        LocalDateTime endDatetime = startDatetime.plusMinutes(BaseData.ORDER_TIME);

        // 合法的学生，并且座位可以使用.
        if (stu.getStatuss() == 0 && BaseData.SEAT_CAN_USE_AGAIN == seat.getStatuss()) {
            // 得到预约的状态码.
            int status = BaseData.STU_SEAT_ORDERING;
            // 生成一个多对多对象
            StudentSeat studentSeat = new StudentSeat(sid, tid, startDatetime, endDatetime, status);
            // 插入数据，并改变seat和stu的状态码
            studentSeatMapper.insert(studentSeat);
            // 更改学生和座位对应的状态
            seat.setStatuss(BaseData.SEAT_ORDERING);
            seat.setSid(stu.getSid());
            // 学生状态码改为预约中
            stu.setStatuss(BaseData.STU_ORDERING);
            stu.setTid(seat.getTid());
            seatMapper.updateByPrimaryKey(seat);
            studentMapper.updateByPrimaryKey(stu);
            return true;
        }
        return false;
    }

    /**
     * 学生得到座位. 将这条记录插入到
     *
     * @param sid
     * @param tid
     * @return
     */
    public boolean getSeat(String sid, Integer tid, LocalDateTime startDatetime, LocalDateTime endDatetime) {
        // 得到学生和座位的详情.
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        Student stu = studentMapper.selectByPrimaryKey(sid);
        // TODO
        StudentSeat studentSeat = null;
        if (studentSeat.getStatuss() != BaseData.STU_SEAT_ORDERING) {
            // 未预约。
            return false;
        }
        // 学生已经预约过这个座位了
        if (stu.getStatuss() == BaseData.STU_ORDERING &&
                seat.getStatuss() == BaseData.SEAT_ORDERING
        ) {
            int status = BaseData.STU_SEAT_USING;
            // 生成一个多对多对象
            StudentSeat studentSeat2 = new StudentSeat(sid, tid, startDatetime, endDatetime, status);
            // 插入数据，并改变seat和stu的状态码
            studentSeatMapper.insert(studentSeat2);

            // 更改学生和座位对应的状态 并更新
            seat.setStatuss(BaseData.SEAT_USING);
            seatMapper.updateByPrimaryKey(seat);

            // 学生状态码改为使用中,并更新
            stu.setStatuss(BaseData.STU_USING);
            studentMapper.updateByPrimaryKey(stu);
            return true;
        }
        return false;
    }


    /**
     * 学生还座
     *
     * @param sid
     * @return
     */
    public boolean outSeat(String sid, LocalDateTime timeOfTempOut) {
        // 得到数据
        Student stu = studentMapper.selectByPrimaryKey(sid);
        StudentSeat studentSeat = null;
        int tid = studentSeat.getTid();
        Seat seat = seatMapper.selectByPrimaryKey(tid);

        if (stu.getStatuss() == 1) {
            // 座位与学生都回到可以使用
            seat.setStatuss(BaseData.SEAT_CAN_USE_AGAIN);
            stu.setStatuss(BaseData.STU_CAN_USE_AGAIN);
            // 将使用记录变为历史记录.
//            studentSeat.setStatuss(BaseData.STU);
            // 更新上面三者
            updateStuSeatSS(stu, seat, studentSeat);
        }
        return false;
    }

    private void updateStuSeatSS(Student stu, Seat seat, StudentSeat studentSeat) {
        studentMapper.updateByPrimaryKey(stu);
        seatMapper.updateByPrimaryKey(seat);
        studentSeatMapper.updateByPrimaryKey(studentSeat);
    }

    /**
     * 暂离座位.
     *
     * @param sid
     * @return
     */
    public boolean tempOut(String sid) {
// 得到数据
        Student stu = studentMapper.selectByPrimaryKey(sid);
        StudentSeat studentSeat = null;
        int tid = studentSeat.getTid();
        Seat seat = seatMapper.selectByPrimaryKey(tid);

        if (stu.getStatuss() == 1) {
            // 座位回到可以使用
            seat.setStatuss(BaseData.SEAT_TEMP_OUT);
            // 学生状态为暂离
            stu.setStatuss(BaseData.STU_PAUSE);
            // 将使用记录变为历史记录.
            studentSeat.setStatuss(BaseData.STU_SEAT_TEMP_OUT);

            // 更新上面三者
            updateStuSeatSS(stu, seat, studentSeat);
            return false;
        }


        return true;
    }

}
