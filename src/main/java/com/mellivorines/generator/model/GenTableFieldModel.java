package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenTableField;
import com.mellivorines.generator.entity.GenTableFieldProps;
import org.babyfish.jimmer.ImmutableConverter;

public class GenTableFieldModel {
    private static final ImmutableConverter<GenTableField, GenTableFieldModel> BOOK_CONVERTER =
            ImmutableConverter
                    .newBuilder(GenTableField.class, GenTableFieldModel.class)
                    .map(GenTableFieldProps.ID, mapping -> {
                        mapping.useIf(input -> input.id != null);
                    })
                    .autoMapOtherScalars(true)
                    .build();

    public GenTableField toGenTableField() {
        return BOOK_CONVERTER.convert(this);
    }

    Integer id;

    Integer tableId;

    String columnName;

    String dataType;

    String columnComment;

    String columnKey;

    public GenTableFieldModel() {
    }

    public GenTableFieldModel(Integer id, Integer tableId, String columnName, String dataType, String columnComment, String columnKey) {
        this.id = id;
        this.tableId = tableId;
        this.columnName = columnName;
        this.dataType = dataType;
        this.columnComment = columnComment;
        this.columnKey = columnKey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }
}
