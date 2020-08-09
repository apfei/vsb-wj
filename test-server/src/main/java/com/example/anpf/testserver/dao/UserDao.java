package com.example.anpf.testserver.dao;

import com.example.anpf.testserver.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: anpf
 * @Date: 2020/8/9 0:19
 */
public interface UserDao extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByNameAndPassword(String name, String password);
}
