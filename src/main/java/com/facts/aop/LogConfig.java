package com.facts.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *日志记录
 * @author Administrator
 */
@Component
@Aspect
public class LogConfig {

    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 切点位置
     */
    @Pointcut("execution(* com.facts.controller.*.*(..))")
    public void pointCut(){ }

    /**
     * 相应切点
     */
    @Pointcut("execution(* com.facts.controller.*.*(..))")
    public void responseCut(){

    }

    /**
     * 请求参数
     * @param joinPoint
     */
    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        //url
        log.info("URL = {}",request.getRequestURL().toString());
        //传输类型
        log.info("HTTP_METHOD = {}",request.getMethod());
        //IP
        log.info("IP = {}" , request.getRemoteAddr());
        //类方法
        log.info("CLASS_METHOD = {}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        log.info("Args = {}",Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 请求结束标识
     */
    @After("pointCut()")
    public void doAfter(){
        System.out.println("end");
    }

    /**
     * 相应参数
     * @param var
     */
    @AfterReturning(returning = "var" , pointcut = "responseCut()")
    public void doAfterReturning(Object var){
        log.info("RESPONSE = {}",var);
    }

}
