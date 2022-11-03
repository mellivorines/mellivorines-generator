package com.mellivorines.generator.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_base_class")
public interface BaseClass extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();

    @Nullable
    @Column(name = "package_name")
    String packageName();

    @Nullable
    @Column(name = "code")
    String code();

    @Nullable
    @Column(name = "fields")
    String fields();


    @Nullable
    @Column(name = "remark")
    String remark();
}
