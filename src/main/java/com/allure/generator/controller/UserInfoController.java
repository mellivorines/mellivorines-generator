
package com.allure.generator.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allure.generator.constants.Result;
import com.allure.generator.controller.base.BaseController;
import com.allure.generator.repository.entity.UserInfoEntity;
import com.allure.generator.service.IUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

/**
 * 功能描述:
 *
 * @author lWX1117952
 * @since 2022-10-19
 */
@RestController
@AllArgsConstructor
@Api(tags = "用户信息处理")
@RequestMapping("api/user-info")
public class UserInfoController extends BaseController {

    @Resource
    IUserInfoService userInfoService;

    @GetMapping(value = "/list")
    @ApiOperation("所有用户")
    public Result<List<UserInfoEntity>> getList() {
        return process(result -> userInfoService.getAllUserInfo());
    }

    @PostMapping(value = "/login")
    @ApiOperation("添加用户")
    public Result getBuLevelResult(@RequestBody UserInfoEntity userInfoEntity) {
        return process(result -> userInfoService.saveUserInfo(userInfoEntity));
    }
}
