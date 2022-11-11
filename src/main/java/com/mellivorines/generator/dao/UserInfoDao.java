package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.UserInfo;
import com.mellivorines.generator.entity.UserInfoFetcher;
import com.mellivorines.generator.entity.UserInfoTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserInfoDao extends BaseDao<UserInfoTable, UserInfo> {

    @Resource
    private JSqlClient sqlClient;


    @Override
    public List<UserInfo> findAllByPage(Class<UserInfoTable> entityTableClazz, int page, int size) {
        UserInfoTable userInfoTable = new UserInfoTable();
        return sqlClient.createQuery(userInfoTable)
                .groupBy(userInfoTable.id())
                .select(userInfoTable.fetch(UserInfoFetcher.$.userName().password()))
                .limit(size, (page - 1) * size)
                .execute();
    }

}
