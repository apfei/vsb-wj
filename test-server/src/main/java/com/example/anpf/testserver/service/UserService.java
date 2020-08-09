package com.example.anpf.testserver.service;

import com.example.anpf.testserver.bean.User;

/**
 * @Author: anpf
 * @Date: 2020/8/9 12:55
 */
public interface UserService {
    User getByName(String name);

    User getByNameAndPassword(String name, String password);
}
