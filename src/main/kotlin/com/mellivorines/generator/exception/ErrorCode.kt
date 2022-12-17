package com.mellivorines.generator.exception

enum class ErrorCode(val code: Int, val msg: String) {
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试")
}