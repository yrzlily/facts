package com.facts.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * SpringSecurity相关配置
 * @author Administrator
 */
//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasRole("TOUR")
                .antMatchers("/main/**").hasRole("ADMIN")
                .antMatchers("/login/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login/index")
                .loginProcessingUrl("/check")
                .defaultSuccessUrl("/main/index")
                .failureUrl("/login/index?log=error")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/login/logout")
                .logoutSuccessUrl("/login/index")
                .and()
                .exceptionHandling().accessDeniedPage("/login/403");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(userDetailsService())
                .passwordEncoder(new Pbkdf2PasswordEncoder());
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return new MyUserDetailsServiceImpl();
    }
}
