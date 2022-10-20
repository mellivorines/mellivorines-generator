
package com.allure.generator.controller;

import com.allure.generator.constants.Result;
import com.allure.generator.controller.base.BaseController;
import com.allure.generator.repository.entity.BaseClassPO;
import com.allure.generator.service.IBaseClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述:实体基类相关
 *
 * @author lilinxi
 * @since 2022-10-20
 */
@RestController
@AllArgsConstructor
@Api(tags = "实体基类处理")
@RequestMapping("api/base-class")
public class BaseClassController extends BaseController {
    @Resource
    IBaseClassService baseClassService;

    @GetMapping(value = "/list")
    @ApiOperation("所有用户")
    public Result<List<BaseClassPO>> getList() {
        return process(result -> baseClassService.getAll());
    }

    @PostMapping(value = "/login")
    @ApiOperation("添加用户")
    public Result getBuLevelResult(@RequestBody BaseClassPO baseClassPO) {
        return process(result -> baseClassService.save(baseClassPO));
    }
}
