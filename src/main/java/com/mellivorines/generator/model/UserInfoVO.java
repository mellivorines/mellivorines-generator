
package com.mellivorines.generator.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能描述:用户信息视图模型
 *
 * @author lilinxi
 * @since 2022-10-21
 */
@Data
@ApiModel("用户信息视图模型")
public class UserInfoVO {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}
