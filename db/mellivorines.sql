/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : mellivorines

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 20/10/2022 15:28:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_base_class
-- ----------------------------
DROP TABLE IF EXISTS `gen_base_class`;
CREATE TABLE `gen_base_class`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `package_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '基类包名',
  `code` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '基类编码',
  `fields` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '基类字段，多个用英文逗号分隔',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '基类管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_base_class
-- ----------------------------
INSERT INTO `gen_base_class` VALUES (1, 'com.mellivorines.generator.common.entity', 'BaseEntity', 'id,creator,create_time,updater,update_time,version,deleted', '使用该基类，则需要表里有这些字段', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for gen_datasource
-- ----------------------------
DROP TABLE IF EXISTS `gen_datasource`;
CREATE TABLE `gen_datasource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `db_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库类型',
  `conn_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '连接名',
  `conn_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据源管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_datasource
-- ----------------------------

-- ----------------------------
-- Table structure for gen_field_type
-- ----------------------------
DROP TABLE IF EXISTS `gen_field_type`;
CREATE TABLE `gen_field_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `column_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段类型',
  `attr_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性类型',
  `package_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性包名',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `column_type`(`column_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字段类型管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_field_type
-- ----------------------------
INSERT INTO `gen_field_type` VALUES (1, 'datetime', 'Date', 'java.util.Date', NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (2, 'date', 'Date', 'java.util.Date', NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (3, 'tinyint', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (4, 'smallint', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (5, 'mediumint', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (6, 'int', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (7, 'integer', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (8, 'bigint', 'Long', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (9, 'float', 'Float', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (10, 'double', 'Double', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (11, 'decimal', 'BigDecimal', 'java.math.BigDecimal', NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (12, 'bit', 'Boolean', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (13, 'char', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (14, 'varchar', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (15, 'tinytext', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (16, 'text', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (17, 'mediumtext', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (18, 'longtext', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (19, 'timestamp', 'Date', 'java.util.Date', NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (20, 'NUMBER', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (21, 'BINARY_INTEGER', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (22, 'BINARY_FLOAT', 'Float', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (23, 'BINARY_DOUBLE', 'Double', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (24, 'VARCHAR2', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (25, 'NVARCHAR', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (26, 'NVARCHAR2', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (27, 'CLOB', 'String', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (28, 'int8', 'Long', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (29, 'int4', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (30, 'int2', 'Integer', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_field_type` VALUES (31, 'numeric', 'BigDecimal', 'java.math.BigDecimal', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for gen_project_modify
-- ----------------------------
DROP TABLE IF EXISTS `gen_project_modify`;
CREATE TABLE `gen_project_modify`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `project_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目名',
  `project_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目标识',
  `project_package` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目包名',
  `project_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目路径',
  `modify_project_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变更项目名',
  `modify_project_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变更标识',
  `modify_project_package` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变更包名',
  `exclusions` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '排除文件',
  `modify_suffix` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变更文件',
  `modify_tmp_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变更临时路径',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目名变更' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_project_modify
-- ----------------------------
INSERT INTO `gen_project_modify` VALUES (1, 'mellivorines-boot', 'mellivorines', 'com.mellivorines', 'D:/mellivorines/mellivorines-boot', 'baba-boot', 'baba', 'com.baba', '.git,.idea,target,logs', 'java,xml,yml,txt', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `gen_project_modify` VALUES (2, 'mellivorines-cloud', 'mellivorines', 'com.mellivorines', 'D:/mellivorines/mellivorines-cloud', 'baba-cloud', 'baba', 'com.baba', '.git,.idea,target,logs', 'java,xml,yml,txt', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表名',
  `class_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类名',
  `table_comment` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  `author` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `package_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目包名',
  `version` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目版本号',
  `generator_type` tinyint(4) NULL DEFAULT NULL COMMENT '生成方式  0：zip压缩包   1：自定义目录',
  `backend_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '后端生成路径',
  `frontend_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前端生成路径',
  `module_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块名',
  `function_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '功能名',
  `form_layout` tinyint(4) NULL DEFAULT NULL COMMENT '表单布局  1：一列   2：两列',
  `datasource_id` bigint(20) NULL DEFAULT NULL COMMENT '数据源ID',
  `baseclass_id` bigint(20) NULL DEFAULT NULL COMMENT '基类ID',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `table_name`(`table_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------

-- ----------------------------
-- Table structure for gen_table_field
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_field`;
CREATE TABLE `gen_table_field`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_id` bigint(20) NULL DEFAULT NULL COMMENT '表ID',
  `field_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段名称',
  `field_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段类型',
  `field_comment` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段说明',
  `attr_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性名',
  `attr_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性类型',
  `package_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性包名',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `auto_fill` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '自动填充  DEFAULT、INSERT、UPDATE、INSERT_UPDATE',
  `primary_pk` tinyint(4) NULL DEFAULT NULL COMMENT '主键 0：否  1：是',
  `base_field` tinyint(4) NULL DEFAULT NULL COMMENT '基类字段 0：否  1：是',
  `form_item` tinyint(4) NULL DEFAULT NULL COMMENT '表单项 0：否  1：是',
  `form_required` tinyint(4) NULL DEFAULT NULL COMMENT '表单必填 0：否  1：是',
  `form_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表单类型',
  `form_dict` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表单字典类型',
  `form_validator` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表单效验',
  `grid_item` tinyint(4) NULL DEFAULT NULL COMMENT '列表项 0：否  1：是',
  `grid_sort` tinyint(4) NULL DEFAULT NULL COMMENT '列表排序 0：否  1：是',
  `query_item` tinyint(4) NULL DEFAULT NULL COMMENT '查询项 0：否  1：是',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '查询方式',
  `query_form_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '查询表单类型',
  `query_dict` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '查询字典类型',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_field
-- ----------------------------

-- ----------------------------
-- Table structure for gen_test_member
-- ----------------------------
DROP TABLE IF EXISTS `gen_test_member`;
CREATE TABLE `gen_test_member`  (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `occupation` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职业',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试1' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_test_member
-- ----------------------------

-- ----------------------------
-- Table structure for gen_test_student
-- ----------------------------
DROP TABLE IF EXISTS `gen_test_student`;
CREATE TABLE `gen_test_student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本号',
  `deleted` tinyint(4) NULL DEFAULT NULL COMMENT '删除标识',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试2' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_test_student
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '123456', 'lilinxi', 'lilinxi', '2022-10-19 11:26:48', '2022-10-19 11:26:52');
INSERT INTO `user_info` VALUES (2, 'lilinxi', '123456', 'lilinxi', 'lilinxi', '2022-10-19 14:23:24', '2022-10-19 14:23:24');
INSERT INTO `user_info` VALUES (3, 'lixingui', '123456', 'lilinxi', 'lilinxi', '2022-10-19 14:29:00', '2022-10-19 14:29:00');

SET FOREIGN_KEY_CHECKS = 1;
