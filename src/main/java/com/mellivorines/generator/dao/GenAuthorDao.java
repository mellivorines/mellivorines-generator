package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenAuthor;
import com.mellivorines.generator.entity.GenAuthorFetcher;
import com.mellivorines.generator.entity.GenAuthorTable;
import org.babyfish.jimmer.sql.JSqlClient;

import javax.annotation.Resource;
import java.util.List;

public class GenAuthorDao extends BaseDao<GenAuthorTable, GenAuthor>{
    @Resource
    private JSqlClient sqlClient;
    @Override
    public List<GenAuthor> findAllByPage(Class<GenAuthorTable> entityTableClazz, int page, int size) {
        GenAuthorTable genAuthorTable = new GenAuthorTable();
        return sqlClient.createQuery(genAuthorTable)
                .groupBy(genAuthorTable.id())
                .select(genAuthorTable.fetch(GenAuthorFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }

}
