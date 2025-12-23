package com.snykta.starter.mybatis.interceptor;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "sql.log.show")
public class SqlLogShowProperties {

    /**
     * 是否开启 SQL 日志拦截
     */
    private boolean enabled = false;
}
