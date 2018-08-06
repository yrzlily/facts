package com.facts.security;

import com.facts.bean.User;
import com.facts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 认证用户信息
 * @author Administrator
 */
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 认证用户
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserDetails user = null;

        try {
            User logUser = userService.findByUsername(s);
            user = new org.springframework.security.core.userdetails.User(
                    logUser.getUsername() ,
                    logUser.getPassword() ,
                    true , true , true , true ,
                    getAuthorities(logUser.getAccess()));

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 赋予角色权限
     * @param access
     * @return
     */
    private Collection<GrantedAuthority> getAuthorities(Integer access){

        List<GrantedAuthority> authList = new ArrayList<>(2);

        authList.add(new SimpleGrantedAuthority("ROLE_TOUR"));

        if(access.compareTo(1) == 0){
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return authList;
    }

}
