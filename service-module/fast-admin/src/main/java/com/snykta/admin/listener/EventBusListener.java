package com.snykta.admin.listener;


import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.snykta.admin.listener.event.AsynchronousEvent;
import com.snykta.admin.listener.event.SynchronizeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@EnableAsync
public class EventBusListener {

    /**
     * 异步
     * @param asynchronousEvent
     */
    @Async
    @EventListener
    public void doHandlerSync(AsynchronousEvent asynchronousEvent) {
        // 休眠3秒，验证异步
        ThreadUtil.sleep(3, TimeUnit.SECONDS);
        log.info("监听到的异步消息：" + JSONUtil.toJsonStr(asynchronousEvent.getSourceModel()));
    }


    /**
     * 同步
     * @param synchronizeEvent
     */
    @EventListener
    public void doHandlerAsync(SynchronizeEvent synchronizeEvent) {
        // 休眠3秒，验证同步
        ThreadUtil.sleep(3, TimeUnit.SECONDS);
        log.info("监听到的同步消息：" + JSONUtil.toJsonStr(synchronizeEvent.getSourceModel()));
    }

}
