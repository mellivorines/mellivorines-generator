package com.mellivorines.generator.entity;


import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.Table;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_datasource")
public interface GenDatasource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();


    @Nullable
    @Column(name = "db_type")
    String dbType();

    @Nullable
    @Column(name = "conn_name")
    String connName();

    @Nullable
    @Column(name = "conn_url")
    String connUrl();

    @Nullable
    @Column(name = "username")
    String username();

    @Nullable
    @Column(name = "password")
    String password();

}
