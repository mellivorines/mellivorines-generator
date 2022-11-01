
package com.mellivorines.generator.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellivorines.generator.constants.Result;
import com.mellivorines.generator.controller.base.BaseController;
import com.mellivorines.generator.model.UserInfoVO;
import com.mellivorines.generator.service.IUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

/**
 * 功能描述:用户信息相关
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
    public Result<List<UserInfoVO>> getList() {
        return process(result -> userInfoService.getAllUserInfo());
    }

    @PostMapping(value = "/save")
    @ApiOperation("添加用户")
    public Result saveUserInfo(@RequestBody UserInfoVO userInfoVO) {
        return process(result -> userInfoService.saveUserInfo(userInfoVO));
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新用户")
    public Result updateUserInfo(@RequestBody UserInfoVO userInfoVO) {
        return process(result -> userInfoService.updateUserInfo(userInfoVO));
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("删除用户")
    public Result deleteUserInfo(@RequestBody List<Integer> ids) {
        return process(result -> userInfoService.deleteUserInfo(ids));
    }
}
