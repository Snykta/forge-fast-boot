package com.snykta.basic.web.handler;


import com.snykta.tools.exception.ServiceException;
import com.snykta.tools.utils.CyObjUtil;
import com.snykta.tools.utils.CyStrUtil;
import com.snykta.tools.web.result.ResultCode;
import com.snykta.tools.web.result.Ret;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * Web全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class ServiceExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public Ret<Void> handleServiceException(ServiceException e, HttpServletRequest request) {
        if (CyStrUtil.isEmpty(e.getMessage())) {
            e.setMessage("系统内部异常");
        }
        if (CyObjUtil.isNull(e.getCode())) {
            e.setCode(ResultCode.ERROR);
        }
        return Ret.fail(e.getCode(), e.getMessage());
    }


    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Ret<Void> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("全局异常捕获 -> 请求地址：{}，不支持：{}请求", requestURI, e.getMethod());
        return Ret.fail("请求方式不支持");
    }



}
