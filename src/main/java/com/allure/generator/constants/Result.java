
package com.allure.generator.constants;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("统一结果返回类型")
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    @ApiModelProperty("返回状态码")
    private String code;

    /**
     * 返回消息
     */
    @ApiModelProperty("返回消息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty("返回数据")
    private T result;
}
