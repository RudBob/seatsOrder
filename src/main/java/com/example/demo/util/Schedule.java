package com.example.demo.util;

import com.example.demo.bean.Seat;
import com.example.demo.bean.Student;
import com.example.demo.bean.StudentSeat;
import com.example.demo.mapper.SeatMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.StudentSeatMapper;
import com.example.demo.service.SeatService;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;


/**
 * Description: 定时器定时执行任务
 *
 * @author 任耀
 * @ClassName: Schedule
 * @date 2018/10/23 9:24
 */
//@Component
public class Schedule {
    @Autowired
    StudentSeatMapper studentSeatMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    StudentService studentService;
    @Autowired
    SeatService seatService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //秒(0-59),分，小时，日期天/日(1-31)，日期月份(1-12),星期（1-7），年(1997-2099,可以省略)
    @Scheduled(cron = "0 0/1 * * * ?")
    public void scheduleTask() {
        // 每分钟都要检查记录是否超时，如果超时，将结果改为false。
        List<StudentSeat> studentSeats = studentSeatMapper.selectExcRecord();
        // 改变对应的状态码
        for (StudentSeat studentSeat : studentSeats) {
            catchException(studentSeat);
        }
    }

    private void catchException(StudentSeat studentSeat) {
        // 得到对应学生和座位的数据
        Student student = studentMapper.selectByPrimaryKey(studentSeat.getSid());
        Seat seat = seatMapper.selectByPrimaryKey(studentSeat.getTid());
        // 预约超时
        if (studentSeat.getStatuss() == BaseData.STU_SEAT_ORDERING) {
            //预约超时，将结果为失败
            studentSeat.setRes(false);
            //学生和座位的状态进行更改
            student.setStatuss(BaseData.STU_NORMAL);
            seat.setStatuss(BaseData.SEAT_NORMAL);
        } else if (studentSeat.getStatuss() == BaseData.STU_SEAT_USING) {
            //使用超时.结束这段使用即可
            studentSeat.setRes(true);
            // 改变学生和座位的状态即可
            student.setStatuss(BaseData.STU_NORMAL);
            seat.setStatuss(BaseData.SEAT_NORMAL);
        } else if (studentSeat.getStatuss() == BaseData.STU_SEAT_TEMP_OUT) {
            // 暂离超时.没有继续使用.
            studentSeat.setRes(true);
            // 座位回到使用状态
            seat.setStatuss(BaseData.SEAT_USING);
            // 学生回到使用状态
            student.setStatuss(BaseData.STU_USING);
        } else {
            // 未知错误记录
            logger.info("未知错误: 学生号为:" + student.getSid()
                    + "，座位号为 " + seat.getTid()
                    + ", 记录号为:" + studentSeat.getStid());
            // 结果设为 false，以便于处理
            studentSeat.setRes(false);
        }
        studentMapper.updateByPrimaryKey(student);
        seatMapper.updateByPrimaryKey(seat);
        studentSeatMapper.updateByPrimaryKey(studentSeat);
    }

}
