package com.snykta.admin.listener.event;

import com.snykta.starter.eventbus.BaseEvent;

/**
 * 同步测试事件类
 */
public class SynchronizeEvent extends BaseEvent<String> {

    public SynchronizeEvent(String source) {
        super(source);
    }

}
