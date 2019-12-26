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

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author 任耀
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
     * 得到一个没有使用的座位
     *
     * @return 返回作为详情
     */
    public Seat getSeatId() {
        return seatMapper.getUnusingSeat();
    }

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

        // 合法的学生，并且座位可以使用.
        if (stu.getStatuss() == BaseData.STU_NORMAL && BaseData.SEAT_NORMAL == seat.getStatuss()) {
            stuOrderSeat(seat, stu);
            return true;
        }
        return false;
    }

    /**
     * 学生预约位置
     *
     * @param seat 位置
     * @param stu  学生
     */
    private void stuOrderSeat(Seat seat, Student stu) {
        LocalDateTime startDatetime = LocalDateTime.now();
        // 预约保留时长:@see BaseData.ORDER_TIME
        LocalDateTime endDatetime = startDatetime.plusMinutes(BaseData.ORDER_TIME);

        // 得到预约的状态码.
        int status = BaseData.STU_SEAT_ORDERING;
        // 生成一个多对多对象
        StudentSeat studentSeat = new StudentSeat(stu.getSid(), seat.getTid(), startDatetime, endDatetime, status);
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
    }

    /**
     * 学生得到座位. 将这条记录插入到db中
     */
    public boolean getSeat(String sid, Integer tid, LocalDateTime startDatetime, LocalDateTime endDatetime) {
        // 得到学生和座位的详情.
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        Student stu = studentMapper.selectByPrimaryKey(sid);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid, startDatetime);

        // 学生并未预约过这个座位
        if (!studentSeat.getStatuss().equals(BaseData.STU_SEAT_ORDERING)
                || BaseData.SEAT_ORDERING != seat.getStatuss()
                || BaseData.STU_ORDERING != stu.getStatuss()) {
            // 未预约。
            return false;
        }

        // 先结束预约的记录.首先设定结束时间，其次改变结果为成功归还
        studentSeat.setEndDatetime(LocalDateTime.now());
        studentSeat.setRes(true);
        studentSeatMapper.updateByPrimaryKey(studentSeat);

        // 新增一条使用座位的记录
        int status = BaseData.STU_SEAT_USING;
        StudentSeat studentSeat2 = new StudentSeat(sid, tid, startDatetime, endDatetime, status);
        studentSeatMapper.insert(studentSeat2);

        // 更改学生和座位对应的状态 并更新
        seat.setStatuss(BaseData.SEAT_USING);
        seatMapper.updateByPrimaryKey(seat);

        // 学生状态码改为使用中,并更新
        stu.setStatuss(BaseData.STU_USING);
        studentMapper.updateByPrimaryKey(stu);
        return true;

    }

    /**
     * 暂离座位.使用学生id和座位id得到数据后，改变数据的状态码
     * 以及结束以上的记录，开始一条新的暂离记录
     */
    public boolean tempOut(String sid, Integer tid, Integer minutes) {
        // 得到一组数据:学生，座位，记录
        Student stu = studentMapper.selectByPrimaryKey(sid);
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid);

        LocalDateTime startTime = studentSeat.getStartDatetime();
        LocalDateTime endTime = studentSeat.getEndDatetime();
        // 时间间隔格式
        Duration duration = java.time.Duration.between(startTime, endTime);

        if (duration.toMinutes() <= minutes) {
            // 剩余时间不足以暂离.
            return false;
        }

        if (stu.getStatuss() == BaseData.STU_USING) {
            // 座位回到可以使用
            seat.setStatuss(BaseData.SEAT_TEMP_OUT);
            // 学生状态为暂离
            stu.setStatuss(BaseData.STU_PAUSE);
            // 结束上一条记录但是不改变结束时间,因为还没有结束.
            studentSeat.setRes(true);
            // 更新上面三者
            update(stu, seat, studentSeat);
            // 开始下一条数据
            LocalDateTime startTempOut = LocalDateTime.now();
            LocalDateTime endTempOut = startTempOut.plusMinutes(minutes);
            StudentSeat studentSeat1 =
                    new StudentSeat(sid, tid, startTempOut, endTempOut, BaseData.STU_SEAT_TEMP_OUT);
            studentSeatMapper.insert(studentSeat1);
            return true;
        }
        return false;
    }

    /**
     * 学生结束暂离，成功结束上一条记录，并且生成一条新的记录
     *
     * @param sid 学生id
     * @param tid 座位id
     * @return 成功与否
     */
    public boolean cancelTempOut(String sid, Integer tid) {
        // 得到一组数据:学生，座位，记录
        Student stu = studentMapper.selectByPrimaryKey(sid);
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid);
        StudentSeat lastUsingHistory = studentSeatMapper.getEndTime(sid, tid);

        LocalDateTime end = studentSeat.getStartDatetime();
        if (stu.getStatuss() == BaseData.STU_PAUSE) {
            // 座位回到使用状态
            seat.setStatuss(BaseData.SEAT_USING);
            // 学生回到使用状态
            stu.setStatuss(BaseData.STU_USING);
            // 结束上一条暂离记录,并且结束上一条使用记录
            studentSeat.setEndDatetime(LocalDateTime.now());
            studentSeat.setRes(true);
            // 更新上面三者
            update(stu, seat, studentSeat);
            // 开始下一条'使用记录' 数据
            LocalDateTime startTempOut = LocalDateTime.now();
            // 继续使用以前的结束时间
            LocalDateTime endTempOut = lastUsingHistory.getEndDatetime();
            StudentSeat studentSeat1 =
                    new StudentSeat(sid, tid, startTempOut, endTempOut, BaseData.STU_SEAT_USING);
            studentSeatMapper.insert(studentSeat1);
            lastUsingHistory.setEndDatetime(end);
            studentSeatMapper.updateByPrimaryKey(lastUsingHistory);
            return true;
        }
        return false;
    }

    /**
     * 学生还座
     *
     * @param sid 学生id
     * @return 成功与否
     */
    public boolean outSeat(String sid, Integer tid) {
        // 得到数据
        Student stu = studentMapper.selectByPrimaryKey(sid);
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid);
        if (stu.getStatuss() == BaseData.STU_USING) {
            // 座位与学生都回到可以使用
            seat.setStatuss(BaseData.SEAT_NORMAL);
            stu.setStatuss(BaseData.STU_NORMAL);
            studentSeat.setEndDatetime(LocalDateTime.now());
            studentSeat.setRes(true);
            // 更新上面三者
            update(stu, seat, studentSeat);
            return true;
        }
        return false;
    }

    /**
     * 续坐几小时几分钟。
     *
     * @param sid        学生id
     * @param tid        座位id
     * @param addHours   增加小时
     * @param addMinutes 增加分钟
     * @return
     */
    public boolean addTime(String sid, Integer tid, Integer addHours, Integer addMinutes) {
        LocalDateTime oldEndDateTime = getEndTime(sid);
        LocalDateTime endDatetime = oldEndDateTime.plusHours(addHours).plusMinutes(addMinutes);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid);
        studentSeat.setEndDatetime(endDatetime);
        studentSeatMapper.updateByPrimaryKey(studentSeat);
        return true;
    }

    /**
     * 取消预约
     *
     * @param sid 学生id
     * @param tid 座位id
     * @return 操作成功
     */
    public void cancelOrder(String sid, Integer tid) {
        Student stu = studentMapper.selectByPrimaryKey(sid);
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid);
        // 改变状态
        stu.setStatuss(BaseData.STU_NORMAL);
        seat.setStatuss(BaseData.SEAT_NORMAL);
        studentSeat.setRes(true);
        // 更新数据库
        update(stu, seat, studentSeat);
    }

    /**
     * 得到用户对这个座位使用的结束时间
     *
     * @param sid
     * @return
     */
    private LocalDateTime getEndTime(String sid) {
        Student stu = studentMapper.selectByPrimaryKey(sid);
        int tid = stu.getTid();
        Seat seat = seatMapper.selectByPrimaryKey(tid);
        StudentSeat studentSeat = studentSeatMapper.selectBySidTid(sid, tid);
        return studentSeat.getEndDatetime();
    }

    /**
     * 更新三个对象在数据库中的值
     *
     * @param student     学生
     * @param seat        座位
     * @param studentSeat 记录
     */
    private void update(Student student, Seat seat, StudentSeat studentSeat) {
        if (studentSeat != null) {
            studentSeatMapper.updateByPrimaryKey(studentSeat);
        }
        if (seat != null) {
            seatMapper.updateByPrimaryKey(seat);
        }
        if (student != null) {
            studentMapper.updateByPrimaryKey(student);
        }
    }
}
