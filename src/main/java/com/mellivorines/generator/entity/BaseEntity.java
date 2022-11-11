package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * <p>
 * 自动生成的base接口，用于写关联关系，每次生成不会覆盖此文件。
 * </p>
 *
 * @Date 2022-10-28 09:15:07
 */
@MappedSuperclass
public interface BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();

    @Nullable
    String creator();

    @Nullable
    String updater();

    @Nullable
    @Column(name = "create_time")
    LocalDateTime createTime();

    @Nullable
    @Column(name = "update_time")
    LocalDateTime updateTime();

}
