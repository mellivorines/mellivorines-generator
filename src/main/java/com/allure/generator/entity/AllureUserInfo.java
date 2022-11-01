package com.allure.generator.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;


@Entity
@Table(name = "allure_user_info")
public interface AllureUserInfo extends AllureUserInfoBase {

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
