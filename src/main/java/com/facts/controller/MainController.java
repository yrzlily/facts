package com.facts.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * 管理页面控制器
 * @author Administrator
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping({"/index" , ""})
    public ModelAndView index(ModelAndView view){
        view.setViewName("/main/index");
        return view;
    }


}
