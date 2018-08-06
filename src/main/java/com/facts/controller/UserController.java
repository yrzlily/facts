package com.facts.controller;

import com.facts.bean.User;
import com.facts.service.UserService;
import com.facts.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户中心
     * @param view
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView view){

        view.setViewName("/index/index");
        view.addObject("age" , 20);
        return view;
    }

    /**
     * 添加新用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ResponseBody
    public Object add(User user){


        user.setUsername(user.getUsername());
        user.setPassword(BCrypt.hashpw(user.getPassword() , BCrypt.gensalt()));
        user.setUsername(user.getUsername());
        userService.add(user);
        return ResultUtils.success(user);
    }


    /**
     * 密码检验测试
     * @param username
     * @param password
     */
    @PostMapping("/match")
    @ResponseBody
    public String match(@RequestParam(value = "username" )String username , @RequestParam(value = "password")String password){
        User user = userService.findByUsername(username);

        System.out.println("user :" + user.getPassword());
        System.out.println("salt :" + password);

        if(BCrypt.checkpw(password , user.getPassword())){
            System.out.println("ok");
        }else{
            System.out.println("no");
        }
        return user.getPassword();

    }

    @ResponseBody
    @PostMapping("/error")
    public String error(){
        return "error";
    }
}
