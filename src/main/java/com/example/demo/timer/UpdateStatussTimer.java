package com.example.demo.timer;

import com.example.demo.bean.Seat;
import com.example.demo.bean.Student;
import com.example.demo.bean.StudentSeat;
import com.example.demo.mapper.SeatMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.StudentSeatMapper;
import com.example.demo.util.BaseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @author ry
 * 定时器设置
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class UpdateStatussTimer {
    @Autowired
    StudentSeatMapper studentSeatMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SeatMapper seatMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 每分钟扫描一次studentSeat,将所有过期的扫描出来并改变.
     * fixedRate 单位是毫秒，设为1分钟查一次
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void updateOutTimeRecords() {
        // 得到超时预约
        List<StudentSeat> studentSeats = studentSeatMapper.selectOutTimeRecord();
        // 处理超时预约
        for (StudentSeat studentSeat : studentSeats) {
            Student student = studentMapper.selectByPrimaryKey(studentSeat.getSid());
            Seat seat = seatMapper.selectByPrimaryKey(studentSeat.getTid());
            // 处理异常记录
            dealOutTimeRecord(studentSeat, student, seat);
        }
    }

    /**
     * 处理异常数据
     *
     * @param studentSeat
     * @param student
     * @param seat
     */
    private void dealOutTimeRecord(StudentSeat studentSeat, Student student, Seat seat) {
        int status = studentSeat.getStatuss();
        if (status == BaseData.STU_SEAT_ORDERING) {
            /*
            预约超时，将结果为失败
             */
            studentSeat.setRes(false);
            student.setStatuss(BaseData.STU_NORMAL);
            seat.setStatuss(BaseData.SEAT_NORMAL);
        } else if (status == BaseData.STU_SEAT_USING) {
            /*
            使用超时.结束这段使用即可。状态归位
             */
            studentSeat.setRes(true);
            student.setStatuss(BaseData.STU_NORMAL);
            seat.setStatuss(BaseData.SEAT_NORMAL);
        } else if (status == BaseData.STU_SEAT_TEMP_OUT) {
            /*
             暂离超时.没有继续使用.
              */
            studentSeat.setRes(true);
            seat.setStatuss(BaseData.SEAT_USING);
            student.setStatuss(BaseData.STU_USING);
        } else {
            /*
             未知错误记录
              */
            logger.info("未知错误: 学生号为:" + student.getSid()
                    + "，座位号为 " + seat.getTid()
                    + ", 记录号为:" + studentSeat.getStid());
            // 结果设为 false，以便于管理员及时处理
            studentSeat.setRes(false);
        }
        // 更新状态
        studentMapper.updateByPrimaryKey(student);
        seatMapper.updateByPrimaryKey(seat);
        studentSeatMapper.updateByPrimaryKey(studentSeat);
    }
}
