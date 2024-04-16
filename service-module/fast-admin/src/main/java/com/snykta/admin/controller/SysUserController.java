//package com.snykta.admin.controller;
//
//
//import cn.dev33.satoken.annotation.SaCheckPermission;
//import cn.dev33.satoken.annotation.SaCheckRole;
//import com.snykta.basic.web.web.controller.BaseController;
//import com.snykta.admin.dto.SearchUserDto;
//import com.snykta.tools.web.page.PageDto;
//import com.snykta.tools.web.result.Ret;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import com.snykta.admin.dto.SysUserDto;
//import com.snykta.admin.service.ISysUserService;
//
//
//
///**
// * 用户信息表
// *
// * @author Snykta
// * @date 2023-09-27
// */
//@RestController
//@RequestMapping("sysUser")
//@Api(tags="用户信息表")
//public class SysUserController extends BaseController {
//
//    private final ISysUserService sysUserService;
//
//    public SysUserController(ISysUserService sysUserService) {
//        this.sysUserService = sysUserService;
//    }
//
//
//    /**
//     * 分页查询用户数据
//     * @param searchUserDto
//     * @return
//     */
//    @SaCheckPermission("sysUser-query")
//    @ApiOperation("分页查询用户数据")
//    @PostMapping(value = "/queryPage", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Ret<PageDto<SysUserDto>> queryPage(@RequestBody SearchUserDto searchUserDto) {
//        return Ret.success(sysUserService.queryPage(searchUserDto));
//    }
//
//
//
//
//}