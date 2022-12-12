package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.GenTableField;
import com.mellivorines.generator.entity.GenTableFieldDraft;
import com.mellivorines.generator.entity.GenTableFieldFetcher;
import com.mellivorines.generator.entity.GenTableFieldProps;
import com.mellivorines.generator.entity.GenTableFieldTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.query.Example;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class GenTableFieldDao extends BaseDao<GenTableFieldTable, GenTableField> {
    @Resource
    private JSqlClient sqlClient;
    @Override
    public List<GenTableField> findAllByPage(Class<GenTableFieldTable> entityTableClazz, int page, int size) {
        GenTableFieldTable genTableFieldTable = new GenTableFieldTable();
        return sqlClient.createQuery(genTableFieldTable)
                .groupBy(genTableFieldTable.id())
                .select(genTableFieldTable.fetch(GenTableFieldFetcher.$.allScalarFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }

    public List<GenTableField> findAllByTableID(Class<GenTableField> genTableFieldClass, int id) {
        GenTableField genTableField = GenTableFieldDraft.$.produce(draft -> draft.setTableId(id));
        return sqlClient.getEntities().findByExample(Example.of(genTableField), GenTableFieldProps.COLUMN_NAME.asc());
    }
}
