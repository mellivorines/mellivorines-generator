package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "user_info")
public interface UserInfo extends BaseEntity {

    @Nullable
    @Column(name = "user_name")
    String userName();

    @Nullable
    @Column(name = "password")
    String password();

}
