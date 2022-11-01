package com.allure.generator.dao;

import com.allure.generator.entity.AllureUserInfo;
import com.allure.generator.entity.AllureUserInfoTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.query.selectable.RootSelectable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AllureUserInfoDao extends BaseDao<AllureUserInfoTable, AllureUserInfo> {

	@Resource
	private JSqlClient sqlClient;

	@Override
	public List<AllureUserInfo> findAllByPage(Class<AllureUserInfoTable> entityTableClazz, int page, int size) {
		List<AllureUserInfo> allureUserInfos = sqlClient.createQuery(entityTableClazz, RootSelectable<AllureUserInfoTable>::select).limit(size, page * size).execute();
		return sqlClient.createQuery(entityTableClazz, RootSelectable<AllureUserInfoTable>::select).limit(size, page * size).execute();
	}

}
