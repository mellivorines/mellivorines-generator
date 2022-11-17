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
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_author
-- ----------------------------
DROP TABLE IF EXISTS `gen_author`;
CREATE TABLE `gen_author`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `author`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者',
    `url`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者网站主页',
    `email`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者Email',
    `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目作者信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_author
-- ----------------------------

-- ----------------------------
-- Table structure for gen_base_class
-- ----------------------------
DROP TABLE IF EXISTS `gen_base_class`;
CREATE TABLE `gen_base_class`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `base_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '基类名称',
    `base_filed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '基类字段（以，拼接）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '基类信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_base_class
-- ----------------------------

-- ----------------------------
-- Table structure for gen_datasource
-- ----------------------------
DROP TABLE IF EXISTS `gen_datasource`;
CREATE TABLE `gen_datasource`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `db_type`   varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库类型',
    `conn_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '连接名',
    `conn_url`  varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'URL',
    `username`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `password`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据源管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_datasource
-- ----------------------------

-- ----------------------------
-- Table structure for gen_field_type
-- ----------------------------
DROP TABLE IF EXISTS `gen_field_type`;
CREATE TABLE `gen_field_type`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `column_type`  varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段类型',
    `attr_type`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性类型',
    `package_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性包名',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `column_type`(`column_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字段类型管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_field_type
-- ----------------------------
INSERT INTO `gen_field_type`
VALUES (1, 'datetime', 'Date', 'java.util.Date');
INSERT INTO `gen_field_type`
VALUES (2, 'date', 'Date', 'java.util.Date');
INSERT INTO `gen_field_type`
VALUES (3, 'tinyint', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (4, 'smallint', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (5, 'mediumint', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (6, 'int', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (7, 'integer', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (8, 'bigint', 'Long', NULL);
INSERT INTO `gen_field_type`
VALUES (9, 'float', 'Float', NULL);
INSERT INTO `gen_field_type`
VALUES (10, 'double', 'Double', NULL);
INSERT INTO `gen_field_type`
VALUES (11, 'decimal', 'BigDecimal', 'java.math.BigDecimal');
INSERT INTO `gen_field_type`
VALUES (12, 'bit', 'Boolean', NULL);
INSERT INTO `gen_field_type`
VALUES (13, 'char', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (14, 'varchar', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (15, 'tinytext', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (16, 'text', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (17, 'mediumtext', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (18, 'longtext', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (19, 'timestamp', 'Date', 'java.util.Date');
INSERT INTO `gen_field_type`
VALUES (20, 'NUMBER', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (21, 'BINARY_INTEGER', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (22, 'BINARY_FLOAT', 'Float', NULL);
INSERT INTO `gen_field_type`
VALUES (23, 'BINARY_DOUBLE', 'Double', NULL);
INSERT INTO `gen_field_type`
VALUES (24, 'VARCHAR2', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (25, 'NVARCHAR', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (26, 'NVARCHAR2', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (27, 'CLOB', 'String', NULL);
INSERT INTO `gen_field_type`
VALUES (28, 'int8', 'Long', NULL);
INSERT INTO `gen_field_type`
VALUES (29, 'int4', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (30, 'int2', 'Integer', NULL);
INSERT INTO `gen_field_type`
VALUES (31, 'numeric', 'BigDecimal', 'java.math.BigDecimal');

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `database_id`   int(11) NULL DEFAULT NULL COMMENT '数据源id',
    `table_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表名',
    `table_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据源获取表信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------

-- ----------------------------
-- Table structure for gen_table_field
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_field`;
CREATE TABLE `gen_table_field`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `table_id`       int(11) NULL DEFAULT NULL COMMENT '表id',
    `column_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表字段名',
    `data_type`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表字段类型',
    `column_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表字段备注',
    `column_key`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表字段键',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '表字段信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_field
-- ----------------------------

SET
FOREIGN_KEY_CHECKS = 1;

