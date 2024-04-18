package com.snykta.gen.controller;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 生成代码的 html 页面路由
 */
@Api(tags = "自动生成代码页面", value = "自动生成代码页面")
@Controller
@ConditionalOnProperty(name = "gen.code.config.enable", havingValue = "true")
public class ViewController {

    @GetMapping("/gen-page")
    public String index() {
        return "index.html";
    }

}
