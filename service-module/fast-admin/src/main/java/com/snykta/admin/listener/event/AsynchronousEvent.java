package com.snykta.admin.listener.event;

import com.snykta.starter.eventbus.BaseEvent;

/**
 * 异步测试事件类
 */
public class AsynchronousEvent extends BaseEvent<String> {

    public AsynchronousEvent(String source) {
        super(source);
    }

}
