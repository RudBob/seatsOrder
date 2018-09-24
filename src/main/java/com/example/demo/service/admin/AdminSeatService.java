package com.example.demo.service.admin;

import com.example.demo.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminSeatService
 * @date 2018/9/24 17:38
 */
@Service
public class AdminSeatService {
    @Autowired
    SeatMapper seatMapper;

}
