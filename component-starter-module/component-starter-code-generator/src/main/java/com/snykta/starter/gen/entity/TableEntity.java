package com.snykta.starter.gen.entity;

import lombok.Data;

import java.util.List;

@Data
public class TableEntity {
    // 表的名称
    private String tableName;
    // 表的备注
    private String comments;
    // 表的列名(不包含主键)
    private List<ColumnEntity> columns;
    // 类名(第一个字母大写)，如：sys_user => SysUser
    private String className;
    // 类名(第一个字母小写)，如：sys_user => sysUser
    private String classNameSmall;

}
