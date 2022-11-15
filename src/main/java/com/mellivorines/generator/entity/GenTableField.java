package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.Table;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_table_field")
public interface GenTableField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();

    @Column(name = "table_id")
    int tableId();

    @Nullable
    @Column(name = "column_name")
    String columnName();

    @Nullable
    @Column(name = "data_type")
    String dataType();

    @Nullable
    @Column(name = "column_comment")
    String columnComment();

    @Nullable
    @Column(name = "column_key")
    String columnKey();

}
