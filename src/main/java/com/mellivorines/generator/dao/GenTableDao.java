package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenTable;
import com.mellivorines.generator.entity.GenTableDraft;
import com.mellivorines.generator.entity.GenTableFetcher;
import com.mellivorines.generator.entity.GenTableProps;
import com.mellivorines.generator.entity.GenTableTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.query.Example;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GenTableDao extends BaseDao<GenTableTable, GenTable> {
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

    public List<GenTable> findAllByDatasourceId(Integer id) {
        GenTable genTable = GenTableDraft.$.produce(draft -> draft.setDatabaseId(id));
        return sqlClient.getEntities().findByExample(Example.of(genTable), GenTableProps.TABLE_NAME.asc());
    }
}
