package com.snykta.starter.redis.lock.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;


@Slf4j
@Configuration
public class RedisLockAutoConfig implements DisposableBean {

    public RedisLockAutoConfig(){
        log.info("初始化[RedisLock]模块...");
    }




    /**
     * lua脚本主要用于自定义限流使用
     * @return
     */
    @Bean
    public RedisScript<Long> limitRedisScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("scripts/limit.lua")));
        redisScript.setResultType(Long.class);
        return redisScript;
    }



    @Override
    public void destroy() throws Exception {
        log.info("关闭[RedisLock]模块...");
    }


}
