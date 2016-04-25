package com.nextrip.core.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by EvilC on 2016/4/23.
 */

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* evilc.treasurebox.dao.*.*(..))")
    public void aspect(){}

    @Before("aspect()")
    public  void before(JoinPoint joinPoint){
        String clazzName = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        LOGGER.info(clazzName + "." + method + "(" + StringUtils.join(joinPoint.getArgs()) + ")");

        try {
            for (String key : DataSourceSelector.METHOD_TYPE_MAP.keySet()) {
                for (String type : DataSourceSelector.METHOD_TYPE_MAP.get(key)) {
                    if (method.startsWith(type)) {
                        HandleDataSource.putDataSource(key);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Hold DataSource fail", e);
        }

    }

}
