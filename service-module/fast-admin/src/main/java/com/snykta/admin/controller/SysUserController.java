package com.snykta.admin.controller;

import cn.hutool.json.JSONUtil;
import com.snykta.basic.web.web.controller.BaseController;
import com.snykta.tools.web.result.Ret;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * 用户信息表
 *
 * @author Snykta
 * @date 2023-09-27
 */
@RestController
public class SysUserController extends BaseController {


    @GetMapping(value = "/")
    public Ret<String> queryPage() {
        return Ret.success("Hello");
    }




}