
package com.allure.generator.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Data
@TableName("allure_user_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户实体映射类")
public class UserInfoPO extends BaseEntity {
    /**
     * 主键
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;

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
