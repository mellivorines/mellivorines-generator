
package com.allure.generator.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allure.generator.constants.Result;
import com.allure.generator.controller.base.BaseController;
import com.allure.generator.model.BaseClassVO;
import com.allure.generator.service.IBaseClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

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
    @ApiOperation("所有基类")
    public Result<List<BaseClassVO>> getList() {
        return process(result -> baseClassService.getAll());
    }

    @PostMapping(value = "/save")
    @ApiOperation("添加基类")
    public Result saveBaseClass(@Valid @RequestBody BaseClassVO baseClassVO) {
        return process(result -> baseClassService.saveBaseClass(baseClassVO));
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新基类")
    public Result updateBaseClass(@Valid @RequestBody BaseClassVO baseClassVO) {
        return process(result -> baseClassService.updateBaseClass(baseClassVO));
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("添加基类")
    public Result deleteBaseClass(@Valid @RequestBody List<Integer> ids) {
        return process(result -> baseClassService.deleteBaseClass(ids));
    }
}
