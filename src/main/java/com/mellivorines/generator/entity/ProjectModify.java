package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_project_modify")
public interface ProjectModify extends BaseEntity {

    @Nullable
    @Column(name = "project_name")
    String projectName();

    @Nullable
    @Column(name = "project_code")
    String projectCode();

    @Nullable
    @Column(name = "project_package")
    String projectPackage();


    @Nullable
    @Column(name = "project_path")
    String projectPath();

    @Nullable
    @Column(name = "modify_project_name")
    String modifyProjectName();

    @Nullable
    @Column(name = "modify_project_code")
    String modifyProjectCode();

    @Nullable
    @Column(name = "exclusions")
    String exclusions();

    @Nullable
    @Column(name = "modify_suffix")
    String modifySuffix();

    @Nullable
    @Column(name = "modify_tmp_path")
    String modifyTmpPath();

}
