package com.mellivorines.generator.exception

class BizException : RuntimeException {
    var code: Int
    var msg: String

    constructor(msg: String) : super(msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.code
        this.msg = msg
    }

    constructor(errorCode: ErrorCode) : super(errorCode.msg) {
        this.code = errorCode.code
        msg = errorCode.msg
    }

    constructor(msg: String, e: Throwable?) : super(msg, e) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.code
        this.msg = msg
    }


    companion object {
        private const val serialVersionUID = 1L
    }
}