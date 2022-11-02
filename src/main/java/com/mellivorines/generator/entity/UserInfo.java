package com.mellivorines.generator.entity;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "user_info")
public interface UserInfo extends UserInfoBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id();

    @Nullable
    @Column(name = "user_name")
    String userName();

    @Nullable
    String password();

}
