package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenTable;
import com.mellivorines.generator.entity.GenTableFetcher;
import com.mellivorines.generator.entity.GenTableTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class GenTableDao extends BaseDao<GenTableTable, GenTable>{
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<GenTable> findAllByPage(Class<GenTableTable> entityTableClazz, int page, int size) {
        GenTableTable genTableTable = new GenTableTable();
        return sqlClient.createQuery(genTableTable)
                .groupBy(genTableTable.id())
                .select(genTableTable.fetch(GenTableFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }
}
