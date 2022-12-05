package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenFieldType;
import com.mellivorines.generator.entity.GenFieldTypeFetcher;
import com.mellivorines.generator.entity.GenFieldTypeTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GenFieldTypeDao extends BaseDao<GenFieldTypeTable, GenFieldType> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<GenFieldType> findAllByPage(Class<GenFieldTypeTable> entityTableClazz, int page, int size) {
        GenFieldTypeTable genFieldTypeTable = new GenFieldTypeTable();
        return sqlClient.createQuery(genFieldTypeTable)
                .groupBy(genFieldTypeTable.id())
                .select(genFieldTypeTable.fetch(GenFieldTypeFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }
}
