package com.snykta.admin.mapper;


import com.snykta.admin.entity.SysUserEntity;
import org.springframework.stereotype.Repository;
import com.snykta.mybatis.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表
 *
 * @author Snykta
 * @date 2024-04-18
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapperPlus<SysUserEntity> {
	
}