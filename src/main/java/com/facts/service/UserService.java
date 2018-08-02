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

}
