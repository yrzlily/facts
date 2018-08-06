package com.facts.service;

import com.facts.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * yrz
 * @author Administrator
 */
@Service
public interface UserService {

    /**
     * 查询详情
     * @return
     */
    List<User> findAll();

    /**
     * 登陆查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 注册用户
     * @param user
     */
    void add(User user);
}
