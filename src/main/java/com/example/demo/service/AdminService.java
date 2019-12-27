package com.example.demo.service;

import com.example.demo.bean.Admin;
import com.example.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 任耀
 * @ClassName: AdminService
 * @date 2018/9/19 19:15
 */
@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin login(String username, String password) {
        return adminMapper.login(username, password);
    }
}
