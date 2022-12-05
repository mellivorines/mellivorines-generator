package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenFieldType;
import com.mellivorines.generator.entity.GenFieldTypeProps;
import org.babyfish.jimmer.ImmutableConverter;

public class GenFieldTypeModel {
    private static final ImmutableConverter<GenFieldType, GenFieldTypeModel> BOOK_CONVERTER =
            ImmutableConverter
                    .newBuilder(GenFieldType.class, GenFieldTypeModel.class)
                    .map(GenFieldTypeProps.ID, mapping -> {
                        mapping.useIf(input -> input.id != null);
                    })
                    .autoMapOtherScalars(true)
                    .build();

    public GenFieldType toGenFieldType() {
        return BOOK_CONVERTER.convert(this);
    }

    private Integer id;

    private String columnType;

    private String attrType;

    private String packageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
