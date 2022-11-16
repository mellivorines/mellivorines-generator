/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : mellivorines

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 16/11/2022 20:59:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_author
-- ----------------------------
DROP TABLE IF EXISTS `gen_author`;
CREATE TABLE `gen_author`
(
    `id`        int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `author`    varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
    `url`       varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者主页url',
    `email`     varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
    `telephone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话号码',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of gen_author
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for gen_base_class
-- ----------------------------
DROP TABLE IF EXISTS `gen_base_class`;
CREATE TABLE `gen_base_class`
(
    `id`         bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `base_name`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '基类包名',
    `base_filed` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '基类编码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='基类管理';

-- ----------------------------
-- Records of gen_base_class
-- ----------------------------
BEGIN;
INSERT INTO `gen_base_class` (`id`, `base_name`, `base_filed`)
VALUES (1, 'com.mellivorines.generator.common.entity', 'BaseEntity');
COMMIT;

-- ----------------------------
-- Table structure for gen_datasource
-- ----------------------------
DROP TABLE IF EXISTS `gen_datasource`;
CREATE TABLE `gen_datasource`
(
    `id`        bigint                                                        NOT NULL AUTO_INCREMENT COMMENT 'id',
    `db_type`   varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库类型',
    `conn_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '连接名',
    `conn_url`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'URL',
    `username`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
    `password`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='数据源管理';

-- ----------------------------
-- Records of gen_datasource
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for gen_field_type
-- ----------------------------
DROP TABLE IF EXISTS `gen_field_type`;
CREATE TABLE `gen_field_type`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `column_type`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
    `attr_type`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性类型',
    `package_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性包名',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `column_type` (`column_type`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 32
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='字段类型管理';

-- ----------------------------
-- Records of gen_field_type
-- ----------------------------
BEGIN;
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (1, 'datetime', 'Date', 'java.util.Date');
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (2, 'date', 'Date', 'java.util.Date');
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (3, 'tinyint', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (4, 'smallint', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (5, 'mediumint', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (6, 'int', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (7, 'integer', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (8, 'bigint', 'Long', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (9, 'float', 'Float', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (10, 'double', 'Double', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (11, 'decimal', 'BigDecimal', 'java.math.BigDecimal');
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (12, 'bit', 'Boolean', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (13, 'char', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (14, 'varchar', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (15, 'tinytext', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (16, 'text', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (17, 'mediumtext', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (18, 'longtext', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (19, 'timestamp', 'Date', 'java.util.Date');
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (20, 'NUMBER', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (21, 'BINARY_INTEGER', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (22, 'BINARY_FLOAT', 'Float', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (23, 'BINARY_DOUBLE', 'Double', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (24, 'VARCHAR2', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (25, 'NVARCHAR', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (26, 'NVARCHAR2', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (27, 'CLOB', 'String', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (28, 'int8', 'Long', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (29, 'int4', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (30, 'int2', 'Integer', NULL);
INSERT INTO `gen_field_type` (`id`, `column_type`, `attr_type`, `package_name`)
VALUES (31, 'numeric', 'BigDecimal', 'java.math.BigDecimal');
COMMIT;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`
(
    `id`            bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `table_name`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表名',
    `table_comment` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '说明',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `table_name` (`table_name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='代码生成表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for gen_table_field
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_field`;
CREATE TABLE `gen_table_field`
(
    `id`              bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `table_id`        bigint                                                        DEFAULT NULL COMMENT '表ID',
    `field_name`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段名称',
    `field_type`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
    `field_comment`   varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
    `attr_name`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性名',
    `attr_type`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性类型',
    `package_name`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性包名',
    `sort`            int                                                           DEFAULT NULL COMMENT '排序',
    `auto_fill`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '自动填充  DEFAULT、INSERT、UPDATE、INSERT_UPDATE',
    `primary_pk`      tinyint                                                       DEFAULT NULL COMMENT '主键 0：否  1：是',
    `base_field`      tinyint                                                       DEFAULT NULL COMMENT '基类字段 0：否  1：是',
    `form_item`       tinyint                                                       DEFAULT NULL COMMENT '表单项 0：否  1：是',
    `form_required`   tinyint                                                       DEFAULT NULL COMMENT '表单必填 0：否  1：是',
    `form_type`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表单类型',
    `form_dict`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表单字典类型',
    `form_validator`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表单效验',
    `grid_item`       tinyint                                                       DEFAULT NULL COMMENT '列表项 0：否  1：是',
    `grid_sort`       tinyint                                                       DEFAULT NULL COMMENT '列表排序 0：否  1：是',
    `query_item`      tinyint                                                       DEFAULT NULL COMMENT '查询项 0：否  1：是',
    `query_type`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '查询方式',
    `query_form_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '查询表单类型',
    `query_dict`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '查询字典类型',
    `creator`         varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '创建者',
    `updater`         varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '更新者',
    `create_time`     datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`     datetime                                                      DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='代码生成表字段';

-- ----------------------------
-- Records of gen_table_field
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
