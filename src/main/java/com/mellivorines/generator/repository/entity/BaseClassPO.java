
package com.mellivorines.generator.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能描述:实体类的基类映射类
 *
 * @author lilinxi
 * @since 2022-10-20
 */
@Data
@TableName("mellivorines_gen_base_class")
@EqualsAndHashCode(callSuper = true)
@ApiModel("实体类的基类映射类")
public class BaseClassPO extends BaseEntity {

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
    private String package_name;

    /**
     * 基类编码
     */
    @ApiModelProperty("基类编码")
    private String code;

    /**
     * 基类字段，多个用英文逗号分隔
     */
    @ApiModelProperty("基类字段，多个用英文逗号分隔")
    private String fields;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
