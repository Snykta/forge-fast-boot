package com.snykta.starter.request.tool.interceptor;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;


/**
 * OkHttp拦截器
 */
@Slf4j
public class OkHttpInterceptor implements Interceptor {


    /**
     *
     * 在此可以处理使用Feign调用接口后返回的Response
     *
     */
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        // 原始请求Response
        Response oldResponse = chain.proceed(chain.request());
        return  oldResponse.newBuilder()
                .code(200) // 状态码写死 = 200。不然会被feign的ErrorDecoder异常机制捕获并报错，由于是单体项目，仅把它当作http请求使用，因此不需要ErrorDecoder捕获
                .message(oldResponse.message())
                .protocol(oldResponse.protocol())
                .body(oldResponse.body())
                .headers(oldResponse.headers())
                .build();
    }
}
