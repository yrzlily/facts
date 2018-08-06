package com.facts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆管理
 * @author Administrator
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    @GetMapping("/index")
    public ModelAndView index(ModelAndView view){
        view.setViewName("/login/index");
        return view;
    }

    /**
     * 无权访问
     * @return
     */
    @ResponseBody
    @RequestMapping("/403")
    public String error(){
        return "403";
    }

    /**
     * 退出
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

}
