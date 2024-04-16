package com.snykta.gen.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 生成代码的 html 页面路由
 */
@Controller
@RequestMapping("/page/gen")
@ConditionalOnProperty(name = "gen.code.config.enable", havingValue = "true")
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

}
