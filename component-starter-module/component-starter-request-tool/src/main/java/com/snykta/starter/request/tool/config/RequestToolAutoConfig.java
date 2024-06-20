package com.snykta.starter.request.tool.config;



import com.snykta.starter.request.tool.decoder.FeignResponseDecoder;
import com.snykta.starter.request.tool.interceptor.FeignRequestInterceptor;
import com.snykta.starter.request.tool.interceptor.OkHttpInterceptor;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import java.util.stream.Collectors;


/**
 * Request-Tool 配置
 */
@Configuration
@Slf4j
@PropertySource("classpath:config/application-request.properties")
public class RequestToolAutoConfig implements DisposableBean {

    public RequestToolAutoConfig(){
        log.info("初始化[Request-Tool]模块...");
    }


    /**
     * 自定义feign的解码实现
     * @param messageConverters
     * @param customizers
     * @return
     */
    @Bean
    public Decoder feignDecoder(ObjectFactory<HttpMessageConverters> messageConverters,
                                ObjectProvider<HttpMessageConverterCustomizer> customizers) {
        return new FeignResponseDecoder(messageConverters, customizers);
    }


    /**
     * 设置请求前拦截器
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }



    @Bean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }


    /**
     * 创建okHttp实例对象，并且注入okHttp拦截器，feign底层请求使用此对象
     * @return
     */
    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new OkHttpInterceptor())
                .build();
    }



    @Override
    public void destroy() throws Exception {
        log.info("关闭[Request-Tool]模块...");
    }
}
