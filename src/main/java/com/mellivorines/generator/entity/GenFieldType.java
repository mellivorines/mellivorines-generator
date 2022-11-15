package com.mellivorines.generator.entity;


import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.Table;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_field_type")
public interface GenFieldType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();

    @Nullable
    @Column(name = "column_type")
    String columnType();

    @Nullable
    @Column(name = "attr_type")
    String attrType();

    @Nullable
    @Column(name = "package_name")
    String packageName();

}
