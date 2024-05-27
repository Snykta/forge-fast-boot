package com.snykta.basic.web.web.utils;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * logback-spring.xml 中获取IP
 */
public class IPLogConvert extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return IpUtil.getIpAddr();
    }
}
