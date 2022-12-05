package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenTable;
import com.mellivorines.generator.entity.GenTableProps;
import org.babyfish.jimmer.ImmutableConverter;

public class GenTableModel {
    private static final ImmutableConverter<GenTable, GenTableModel> BOOK_CONVERTER =
            ImmutableConverter
                    .newBuilder(GenTable.class, GenTableModel.class)
                    .map(GenTableProps.ID, mapping -> {
                        mapping.useIf(input -> input.id != null);
                    })
                    .autoMapOtherScalars(true)
                    .build();

    public GenTable toGenTable() {
        return BOOK_CONVERTER.convert(this);
    }

    Integer id;

    Integer databaseId;

    String tableName;

    String tableComment;

    public GenTableModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(Integer databaseId) {
        this.databaseId = databaseId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }
}
