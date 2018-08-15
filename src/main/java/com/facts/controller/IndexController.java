package com.facts.controller;

import com.facts.bean.User;
import com.facts.dao.UserDao;
import com.facts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;


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

        return view;
    }

    /**
     * 角色返回页面
     * @param view
     * @return
     */
    @GetMapping("index/role")
    public ModelAndView role(ModelAndView view){

        Set<String> role = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        if(role.contains("ROLE_ADMIN")){
            view.setViewName("/main/index");
        }else{
            view.setViewName("/user/index");
        }

        return view;
    }

}
