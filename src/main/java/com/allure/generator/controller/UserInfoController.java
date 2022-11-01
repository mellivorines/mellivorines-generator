
package com.allure.generator.controller;

import com.allure.generator.dao.AllureUserInfoDao;
import com.allure.generator.entity.AllureUserInfo;
import com.allure.generator.entity.AllureUserInfoFetcher;
import com.allure.generator.entity.AllureUserInfoTable;
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
    AllureUserInfoDao allureUserInfoDao;

    @Resource
    private JSqlClient sqlClient;

    @PostMapping(value = "/list")
    @ApiOperation("所有用户")
    @ResponseBody
    public List<AllureUserInfo> getList() {
        Fluent fluent = sqlClient.createFluent();
        AllureUserInfoTable allureUserInfoTable = new AllureUserInfoTable();
        List<AllureUserInfo> execute = fluent.query(allureUserInfoTable)
                .groupBy(allureUserInfoTable.id())
                .select(allureUserInfoTable.fetch(AllureUserInfoFetcher.$.userName().password()))
                .execute();
        return execute;
    }

}
