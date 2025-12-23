package com.snykta.admin.config;


import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class SaTokenWebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(saInterceptor()).addPathPatterns("/**");
    }


    public SaInterceptor saInterceptor() {
        log.info("开始注册[Security]模块的全局拦截器...");
        return new SaInterceptor(handler -> {
            SaRouter
                    .match("/**")                                 // 拦截的 path 列表，可以写多个 */
                    .notMatch("/sysUser/login")                    // 排除掉的 path 列表，可以写多个
                    .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式
        });
    }


}
