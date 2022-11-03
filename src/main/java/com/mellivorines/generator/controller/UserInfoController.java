
package com.mellivorines.generator.controller;

import com.mellivorines.generator.dao.UserInfoDao;
import com.mellivorines.generator.entity.UserInfo;
import com.mellivorines.generator.entity.UserInfoTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.babyfish.jimmer.sql.ast.mutation.DeleteResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Api(tags = "用户信息处理")
@RequestMapping("api/user-info")
public class UserInfoController {

    @Resource
    UserInfoDao userInfoDao;

    @GetMapping(value = "/list")
    @ApiOperation("所有用户")
    @ResponseBody
    public List<UserInfo> getList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return userInfoDao.findAllByPage(UserInfoTable.class, page, size);
    }

    @PostMapping(value = "/save")
    @ApiOperation("保存用户")
    @ResponseBody
    public UserInfo save(@RequestBody UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新用户")
    @ResponseBody
    public UserInfo update(@RequestBody UserInfo userInfo) {
        return userInfoDao.update(userInfo);
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("删除用户")
    @ResponseBody
    public DeleteResult delete(@RequestBody List<Integer> ids) {
        return userInfoDao.batchDelete(UserInfoTable.class, ids);
    }

}
