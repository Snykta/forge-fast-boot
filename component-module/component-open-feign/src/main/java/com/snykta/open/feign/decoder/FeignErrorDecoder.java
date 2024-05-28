package com.snykta.open.feign.decoder;


import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import com.snykta.open.feign.utils.FeignResponseUtil;
import com.snykta.tools.exception.ServiceException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;


/**
 * 自定义feign异常结果解码器 Exception.class异常
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {


    /**
     * 内部异常或者响应状态码!=200都会被此异常捕获
     *
     * @history
     */
    @Override
    public ServiceException decode(String methodKey, Response response) {
        ServiceException serviceException = new ServiceException("内部组件服务异常");
        try {
            String body = null;
            if (FeignResponseUtil.isGZip(response)) {
                body = FeignResponseUtil.unGZip(response);
            } else {
                body = IoUtil.read(response.body().asReader(CharsetUtil.CHARSET_UTF_8));
            }
            serviceException = new ServiceException(body);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return serviceException;
    }
}
