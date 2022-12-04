package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenDatasource;
import com.mellivorines.generator.entity.GenDatasourceFetcher;
import com.mellivorines.generator.entity.GenDatasourceTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GenDatasourceDao extends BaseDao<GenDatasourceTable, GenDatasource> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<GenDatasource> findAllByPage(Class<GenDatasourceTable> entityTableClazz, int page, int size) {
        GenDatasourceTable genDatasourceTable = new GenDatasourceTable();
        return sqlClient.createQuery(genDatasourceTable)
                .groupBy(genDatasourceTable.id())
                .select(genDatasourceTable.fetch(GenDatasourceFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }
}
