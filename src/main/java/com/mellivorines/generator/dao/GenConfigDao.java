package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenConfig;
import com.mellivorines.generator.entity.GenConfigFetcher;
import com.mellivorines.generator.entity.GenConfigTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GenConfigDao extends BaseDao<GenConfigTable, GenConfig> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<GenConfig> findAllByPage(Class<GenConfigTable> entityTableClazz, int page, int size) {
        GenConfigTable genConfigTable = new GenConfigTable();
        return sqlClient.createQuery(genConfigTable)
                .groupBy(genConfigTable.id())
                .select(genConfigTable.fetch(GenConfigFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }
}
