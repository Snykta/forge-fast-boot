package com.snykta.admin.service;


import com.snykta.admin.dto.SearchUserDto;
import com.snykta.admin.dto.SysUserDto;
import com.snykta.admin.entity.SysUserEntity;
import com.snykta.tools.web.page.PageDto;

/**
 * 用户信息表
 *
 * @author Snykta
 * @date 2024-04-18
 */
public interface ISysUserService {

    /**
     * 分页查询用户数据
     *
     * @param searchUserDto
     * @return {@link com.snykta.tools.web.page.PageDto<com.snykta.admin.dto.SysUserDto>}
     * @author 王畅通
     * @history
     */
    PageDto<SysUserDto> queryPage(SearchUserDto searchUserDto);
}