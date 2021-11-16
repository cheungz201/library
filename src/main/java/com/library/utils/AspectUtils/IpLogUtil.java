package com.library.utils.AspectUtils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-15 21:36
 * @Version: 1.0.0
 * @Description: 请求ip记录
 **/
@Aspect
@Component
@Slf4j
public class IpLogUtil {

    /**
     * 所有controller的切面表达式
     */
    @Pointcut("execution(public * com.library.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 记录来路ip
     * @param joinPoint
     */
    @Before("webLog()")
    public void ipLogBefore(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        for (Object o : args){
            if (o instanceof HttpServletRequest){
                request = (HttpServletRequest) o;
                break;
            }
        }
        if (request != null){
            log.info("访问开始"+"URL : " + request.getRequestURL().toString() + ",IP : " + request.getRemoteAddr() +
                    ",CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." +
                    joinPoint.getSignature().getName() + ",ARGS : " + Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(Object object) {
        // 处理完请求，返回内容
        log.info("访问结束 : " + object);
    }
}
