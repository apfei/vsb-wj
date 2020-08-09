package com.example.anpf.testserver.service.Impl;

import com.example.anpf.testserver.bean.User;
import com.example.anpf.testserver.dao.UserDao;
import com.example.anpf.testserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: anpf
 * @Date: 2020/8/9 12:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public User getByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public User getByNameAndPassword(String name, String password) {
        return dao.findByNameAndPassword(name,password);
    }
}
