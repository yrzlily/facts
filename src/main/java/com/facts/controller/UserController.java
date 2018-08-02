package com.facts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/index")
    public ModelAndView index(ModelAndView view){



        view.setViewName("/index/index");
        view.addObject("age" , 20);
        return view;
    }

}
