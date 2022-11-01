
package com.mellivorines.generator.controller.base;

import com.mellivorines.generator.constants.Result;
import com.mellivorines.generator.constants.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * 功能描述:基础的Controller
 *
 * @author lilinxi
 * @since 2022-10-19
 */
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    public Result process(Function<Result, Object> process) {
        Result result = new Result();
        return this.proc(result, process);
    }

    private Result proc(Result result, Function<Result, Object> process) {
        try {
            Object data = process.apply(result);
            if (data instanceof Result) {
                return (Result) data;
            }

            result.setResult(data);
            result.setCode(ResultCode.SUCCESS.code());
            result.setMessage(ResultCode.SUCCESS.desc());
        } catch (Exception var4) {
            log.error("error", var4);
            result.setCode(ResultCode.FAIL.code());
            result.setMessage(var4.getMessage());
        }

        return result;
    }

}
