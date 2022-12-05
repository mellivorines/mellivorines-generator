package com.mellivorines.generator.model;

import com.mellivorines.generator.entity.GenDatasource;
import com.mellivorines.generator.entity.GenDatasourceProps;
import org.babyfish.jimmer.ImmutableConverter;

public class GenDatasourceModel {
    private static final ImmutableConverter<GenDatasource, GenDatasourceModel> BOOK_CONVERTER =
            ImmutableConverter
                    .newBuilder(GenDatasource.class, GenDatasourceModel.class)
                    .map(GenDatasourceProps.ID, mapping -> {
                        mapping.useIf(input -> input.id != null);
                    })
                    .autoMapOtherScalars(true)
                    .build();

    public GenDatasource toGenDatasource() {
        return BOOK_CONVERTER.convert(this);
    }

    private Integer id;

    private String dbType;

    private String connName;

    private String connUrl;

    private String username;

    private String password;

    public GenDatasourceModel() {
    }

    public GenDatasourceModel(Integer id, String dbType, String connName, String connUrl, String username, String password) {
        this.id = id;
        this.dbType = dbType;
        this.connName = connName;
        this.connUrl = connUrl;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getConnName() {
        return connName;
    }

    public void setConnName(String connName) {
        this.connName = connName;
    }

    public String getConnUrl() {
        return connUrl;
    }

    public void setConnUrl(String connUrl) {
        this.connUrl = connUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
