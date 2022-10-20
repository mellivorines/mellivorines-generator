
package com.allure.generator.controller;

import com.allure.generator.constants.Result;
import com.allure.generator.controller.base.BaseController;
import com.allure.generator.repository.entity.UserInfoPO;
import com.allure.generator.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述:
 *
 * @author lilinxi
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
    public Result<List<UserInfoPO>> getList() {
        return process(result -> userInfoService.getAllUserInfo());
    }

    @PostMapping(value = "/login")
    @ApiOperation("添加用户")
    public Result getBuLevelResult(@RequestBody UserInfoPO userInfoPO) {
        return process(result -> userInfoService.saveUserInfo(userInfoPO));
    }
}
