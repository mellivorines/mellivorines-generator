package com.mellivorines.generator.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class GenTableFieldModel {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof GenTableFieldModel)) return false;

        GenTableFieldModel genTableFieldModel = (GenTableFieldModel) o;

        return new EqualsBuilder().append(getId(), genTableFieldModel.getId()).append(getTableId(), genTableFieldModel.getTableId()).append(getColumnName(), genTableFieldModel.getColumnName()).append(getDataType(), genTableFieldModel.getDataType()).append(getColumnComment(), genTableFieldModel.getColumnComment()).append(getColumnKey(), genTableFieldModel.getColumnKey()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getTableId()).append(getColumnName()).append(getDataType()).append(getColumnComment()).append(getColumnKey()).toHashCode();
    }
}
