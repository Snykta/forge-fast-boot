package com.snykta.admin.controller;



import com.snykta.admin.listener.event.AsynchronousEvent;
import com.snykta.admin.listener.event.SynchronizeEvent;
import com.snykta.basic.web.web.controller.BaseController;
import com.snykta.eventbus.EventBusTemplate;
import com.snykta.tools.web.result.Ret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("eventBus")
@Api(tags="事件发布测试")
public class EventBusController extends BaseController {


    private final EventBusTemplate eventBusTemplate;

    public EventBusController(EventBusTemplate eventBusTemplate) {
        this.eventBusTemplate = eventBusTemplate;
    }


    @ApiOperation("事件发布测试（同步）")
    @PostMapping(value = "/test-synchronize", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ret<Void> testSynchronize() {
        eventBusTemplate.publish(new SynchronizeEvent("Hello World"));
        return Ret.success();
    }

    @ApiOperation("事件发布测试（异步）")
    @PostMapping(value = "/test-asynchronous", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Ret<Void> tesAsynchronous() {
        eventBusTemplate.publish(new AsynchronousEvent("Hello World"));
        return Ret.success();
    }




}
