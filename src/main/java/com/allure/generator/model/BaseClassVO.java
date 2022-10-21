
package com.allure.generator.model;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-21
 */
@Data
@ApiModel("实体类的基类视图模型")
public class BaseClassVO {
    /**
     * 主键
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 基类包名
     */
    @ApiModelProperty("基类包名")
    @NotBlank(message = "基类包名不能为空！")
    private String packageName;

    /**
     * 基类编码
     */
    @ApiModelProperty("基类编码")
    @NotBlank(message = "基类编码不能为空！")
    private String code;

    /**
     * 基类字段，多个用英文逗号分隔
     */
    @ApiModelProperty("基类字段，多个用英文逗号分隔")
    @NotBlank(message = "基类字段不能为空！")
    private String fields;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
