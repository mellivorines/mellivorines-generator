package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenBaseClass;
import com.mellivorines.generator.entity.GenBaseClassFetcher;
import com.mellivorines.generator.entity.GenBaseClassTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BaseClassDao extends BaseDao<GenBaseClassTable, GenBaseClass> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<GenBaseClass> findAllByPage(Class<GenBaseClassTable> entityTableClazz, int page, int size) {
        GenBaseClassTable genBaseClassTable = new GenBaseClassTable();
        return sqlClient.createQuery(genBaseClassTable)
                .groupBy(genBaseClassTable.id())
                .select(genBaseClassTable.fetch(GenBaseClassFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }

}
