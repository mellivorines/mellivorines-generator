package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.Table;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_config")
public interface GenConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();

    @Column(name = "project")
    String project();

    @Column(name = "module")
    String module();

    @Column(name = "group")
    String group();

    @Nullable
    @Column(name = "artifact")
    String artifact();

    @Nullable
    @Column(name = "version")
    String version();
}
