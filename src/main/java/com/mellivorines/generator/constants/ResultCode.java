
package com.mellivorines.generator.constants;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
public enum ResultCode {

    SUCCESS("200", "成功"), // 成功

    FAIL("400", "失败"), // 失败

    UNAUTHORIZED("401", "未认证"), // 未认证（签名错误）

    NOT_FOUND("404", "接口不存在"), // 接口不存在

    INTERNAL_SERVER_ERROR("500", "服务器内部错误");// 服务器内部错误

    private final String code;
    private String desc;

    ResultCode(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String desc() {
        return this.desc;
    }

    public String code() {
        return this.code;
    }
}
