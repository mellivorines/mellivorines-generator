package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.UserInfo;
import com.mellivorines.generator.entity.UserInfoTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.query.selectable.RootSelectable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserInfoDao extends BaseDao<UserInfoTable, UserInfo> {

    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<UserInfo> findAllByPage(Class<UserInfoTable> entityTableClazz, int page, int size) {
        List<UserInfo> allureUserInfos = sqlClient.createQuery(entityTableClazz, RootSelectable<UserInfoTable>::select).limit(size, page * size).execute();
        return sqlClient.createQuery(entityTableClazz, RootSelectable<UserInfoTable>::select).limit(size, page * size).execute();
    }

}
