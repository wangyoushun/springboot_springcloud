package com.six.springboot.task;

import java.lang.reflect.Method;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.six.springboot.redis.RedisTool;
import com.six.springboot.redis.RedisUtil;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
@Aspect
@Component
public class TaskAspect {

    @Around("execution(* com.six.springboot.task.*.*(..))")
    public Object taskRun(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String name = method.getName();
    	String requestId = UUID.randomUUID().toString();
		log.info(name+" b,  requestId="+requestId);
		Jedis jedis = RedisUtil.getJedis();
		
		boolean tryGetDistributedLock = RedisTool.tryGetDistributedLock(jedis, name, requestId, 1000 * 60);
		Object result = null;
		if(tryGetDistributedLock) {
			result = joinPoint.proceed();
			 RedisTool.releaseDistributedLock(jedis, name, requestId);
		}
        return result;
    }
}