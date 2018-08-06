package com.facts.dao;

import com.facts.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * User持久层
 * @author Administrator
 */
@Repository
public interface UserDao {

    /**
     * 查询全部
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
     * 用户注册
     * @param user
     */
    void addUser(User user);
}
