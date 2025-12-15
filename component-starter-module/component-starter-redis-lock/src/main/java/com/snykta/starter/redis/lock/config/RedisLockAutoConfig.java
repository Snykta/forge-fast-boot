package com.snykta.starter.redis.lock.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class RedisLockAutoConfig implements DisposableBean {

    public RedisLockAutoConfig(){
        log.info("初始化[RedisLock]模块...");
    }



    @Override
    public void destroy() throws Exception {
        log.info("关闭[RedisLock]模块...");
    }


}
