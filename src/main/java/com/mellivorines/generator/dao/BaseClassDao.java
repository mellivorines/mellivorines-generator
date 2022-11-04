package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.BaseClass;
import com.mellivorines.generator.entity.BaseClassFetcher;
import com.mellivorines.generator.entity.BaseClassTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.fluent.Fluent;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BaseClassDao extends BaseDao<BaseClassTable, BaseClass> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<BaseClass> findAllByPage(Class<BaseClassTable> entityTableClazz, int page, int size) {
        Fluent fluent = sqlClient.createFluent();
        BaseClassTable baseClassTable = new BaseClassTable();
        return fluent.query(baseClassTable)
                .groupBy(baseClassTable.id())
                .select(baseClassTable.fetch(BaseClassFetcher.$.packageName().code().fields().remark()))
                .limit(size, (page - 1) * size)
                .execute();
    }

}
