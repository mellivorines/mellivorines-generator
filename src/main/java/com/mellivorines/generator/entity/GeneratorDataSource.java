package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Table;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_datasource")
public interface GeneratorDataSource extends BaseEntity {

    /**
     * 数据库类型
     */
    @Nullable
    @Column(name = "db_type")
    String dbType();

    /**
     * 连接名
     */
    @Nullable
    @Column(name = "conn_name")
    String connName();

    /**
     * URL
     */
    @Nullable
    @Column(name = "conn_url")
    String connUrl();

    /**
     * 用户名
     */
    @Nullable
    @Column(name = "username")
    String username();

    /**
     * 密码
     */
    @Nullable
    @Column(name = "password")
    String password();

}
