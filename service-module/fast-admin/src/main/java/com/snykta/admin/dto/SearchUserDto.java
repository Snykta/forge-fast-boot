package com.snykta.admin.dto;

import com.snykta.tools.web.search.BaseSearchDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询条件Dto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchUserDto extends BaseSearchDto {

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;


}
