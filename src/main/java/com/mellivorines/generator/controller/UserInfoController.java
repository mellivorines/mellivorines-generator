
package com.mellivorines.generator.controller;

import com.mellivorines.generator.dao.UserInfoDao;
import com.mellivorines.generator.entity.UserInfo;
import com.mellivorines.generator.entity.UserInfoFetcher;
import com.mellivorines.generator.entity.UserInfoTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.fluent.Fluent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Api(tags = "用户信息处理")
@RequestMapping("api/user-info")
public class UserInfoController {

    @Resource
    UserInfoDao userInfoDao;

    @Resource
    private JSqlClient sqlClient;

    @PostMapping(value = "/list")
    @ApiOperation("所有用户")
    @ResponseBody
    public List<UserInfo> getList() {
        Fluent fluent = sqlClient.createFluent();
        UserInfoTable mellivorinesUserInfoTable = new UserInfoTable();
        List<UserInfo> userInfoList = fluent.query(mellivorinesUserInfoTable)
                .groupBy(mellivorinesUserInfoTable.id())
                .select(mellivorinesUserInfoTable.fetch(UserInfoFetcher.$.userName().password()))
                .execute();
        return userInfoList;
    }

}
