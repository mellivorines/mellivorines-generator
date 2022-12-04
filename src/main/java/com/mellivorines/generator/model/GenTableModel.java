package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenTable;
import com.mellivorines.generator.entity.GenTableProps;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    Integer id;

    Integer datasourceId;

    String tableName;

    String tableComment;

    public GenTableModel() {
    }

    public GenTable toGenTable() {
        return BOOK_CONVERTER.convert(this);
    }

    public GenTableModel(Integer id, int datasourceId, String tableName, String tableComment) {
        this.id = id;
        this.datasourceId = datasourceId;
        this.tableName = tableName;
        this.tableComment = tableComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(int datasourceId) {
        this.datasourceId = datasourceId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof GenTableModel)) return false;

        GenTableModel genTableModel = (GenTableModel) o;

        return new EqualsBuilder().append(getId(), genTableModel.getId()).append(getDatasourceId(), genTableModel.getDatasourceId()).append(getTableName(), genTableModel.getTableName()).append(getTableComment(), genTableModel.getTableComment()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getDatasourceId()).append(getTableName()).append(getTableComment()).toHashCode();
    }
}
