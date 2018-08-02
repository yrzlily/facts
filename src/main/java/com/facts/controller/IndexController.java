package com.facts.controller;

import com.facts.bean.User;
import com.facts.dao.UserDao;
import com.facts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 首页入口
 * @author Administrator
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView view){
        view.setViewName("/index/index");
        List<User> user = userService.findAll();
        for (User u : user){
            System.out.println(u.getUsername());
        }
        view.addObject("user" , user);
        return view;
    }

}
