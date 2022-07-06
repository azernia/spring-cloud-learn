/*
 Navicat Premium Data Transfer

 Source Server         : cloud.lebao.site
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : cloud.lebao.site:3306
 Source Schema         : cloud_admin`

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 21/12/2021 21:44:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(64)  DEFAULT '' COMMENT '菜单名称',
    `parent_id`   bigint(20)   DEFAULT NULL COMMENT '父菜单ID',
    `path`        varchar(128) DEFAULT '' COMMENT '路由路径',
    `component`   varchar(128) DEFAULT NULL COMMENT '组件路径',
    `icon`        varchar(64)  DEFAULT '' COMMENT '菜单图标',
    `sort`        int(11)      DEFAULT '0' COMMENT '排序',
    `visible`     tinyint(1)   DEFAULT '1' COMMENT '状态：0-禁用 1-开启',
    `redirect`    varchar(128) DEFAULT '' COMMENT '跳转路径',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 21
  DEFAULT CHARSET = utf8 COMMENT ='菜单管理';

-- ----------------------------
-- Table structure for sys_oauth_client
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client`;
CREATE TABLE `sys_oauth_client`
(
    `client_id`               varchar(256) NOT NULL,
    `resource_ids`            varchar(256)  DEFAULT NULL,
    `client_secret`           varchar(256)  DEFAULT NULL,
    `scope`                   varchar(256)  DEFAULT NULL,
    `authorized_grant_types`  varchar(256)  DEFAULT NULL,
    `web_server_redirect_uri` varchar(256)  DEFAULT NULL,
    `authorities`             varchar(256)  DEFAULT NULL,
    `access_token_validity`   int(11)       DEFAULT NULL,
    `refresh_token_validity`  int(11)       DEFAULT NULL,
    `additional_information`  varchar(4096) DEFAULT NULL,
    `autoapprove`             varchar(256)  DEFAULT NULL,
    `create_time`             datetime      DEFAULT NULL COMMENT '创建时间',
    `update_time`             datetime      DEFAULT NULL COMMENT '更新时间',
    `update_by`               varchar(255)  DEFAULT NULL COMMENT '更新者',
    `create_by`               varchar(255)  DEFAULT NULL COMMENT '创建者',
    PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(64)  DEFAULT NULL COMMENT '权限名称',
    `menu_id`     int(11)      DEFAULT NULL COMMENT '菜单模块ID\r\n',
    `url_perm`    varchar(128) DEFAULT NULL COMMENT 'URL权限标识',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `update_by`   varchar(255) DEFAULT NULL COMMENT '更新者',
    `create_by`   varchar(255) DEFAULT NULL COMMENT '创建者',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `id` (`id`, `name`) USING BTREE,
    KEY `id_2` (`id`, `name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8 COMMENT ='权限表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`        varchar(64) NOT NULL DEFAULT '' COMMENT '角色名称',
    `code`        varchar(32)          DEFAULT NULL COMMENT '角色编码',
    `sort`        int(11)              DEFAULT NULL COMMENT '显示顺序',
    `status`      tinyint(1)           DEFAULT '1' COMMENT '角色状态：0-正常；1-停用',
    `deleted`     tinyint(1)  NOT NULL DEFAULT '0' COMMENT '逻辑删除标识：0-未删除；1-已删除',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    `update_by`   varchar(255)         DEFAULT NULL COMMENT '更新者',
    `create_by`   varchar(255)         DEFAULT NULL COMMENT '创建者',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8 COMMENT ='角色表';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    `menu_id` bigint(20) NOT NULL COMMENT '菜单ID'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色和菜单关联表';

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`
(
    `role_id`       int(11) DEFAULT NULL COMMENT '角色id',
    `permission_id` int(11) DEFAULT NULL COMMENT '资源id',
    KEY `role_id` (`role_id`) USING BTREE,
    KEY `permission_id` (`permission_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='角色权限表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `username`    varchar(64)   DEFAULT NULL COMMENT '用户名',
    `nickname`    varchar(64)   DEFAULT NULL COMMENT '昵称',
    `gender`      tinyint(1)    DEFAULT '1' COMMENT '性别：1-男 2-女',
    `password`    varchar(100)  DEFAULT NULL COMMENT '密码',
    `avatar`      varchar(2000) DEFAULT '' COMMENT '用户头像',
    `mobile`      varchar(20)   DEFAULT NULL COMMENT '联系方式',
    `status`      tinyint(1)    DEFAULT '1' COMMENT '用户状态：1-正常 0-禁用',
    `email`       varchar(128)  DEFAULT NULL COMMENT '用户邮箱',
    `deleted`     tinyint(1)    DEFAULT '0' COMMENT '逻辑删除标识：0-未删除；1-已删除',
    `create_time` datetime      DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime      DEFAULT NULL COMMENT '更新时间',
    `update_by`   varchar(255)  DEFAULT NULL COMMENT '更新者',
    `create_by`   varchar(255)  DEFAULT NULL COMMENT '创建者',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `login_name` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8 COMMENT ='用户信息表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` int(11) NOT NULL COMMENT '用户ID',
    `role_id` int(11) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户和角色关联表';

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `cloud_admin`.`sys_user` (`id`, `username`, `nickname`, `gender`, `password`, `avatar`, `mobile`, `status`,
                                      `email`, `deleted`, `create_time`, `update_time`, `update_by`, `create_by`)
VALUES (4, 'ams', '管理员', 1, '$2a$10$cmyqsFYXMp0H5d44LmHDbuEpJMeDJqFkKHRvo61g7H8KcORGX0tcG',
        'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg3.53shop.com%2FUploadFile%2Fnewspic%2F2018%2F05%2F17%2F20180517103618371.gif&refer=http%3A%2F%2Fimg3.53shop.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1651571208&t=bb7ea42de6eb55ad0d7a64e3d42f6afc',
        '', 1, '', 0, '2021-12-04 20:14:09', '2021-12-04 20:14:12', NULL, NULL);
INSERT INTO `cloud_admin`.`sys_oauth_client` (`client_id`, `resource_ids`, `client_secret`, `scope`,
                                              `authorized_grant_types`, `web_server_redirect_uri`, `authorities`,
                                              `access_token_validity`, `refresh_token_validity`,
                                              `additional_information`, `autoapprove`, `create_time`, `update_time`,
                                              `update_by`, `create_by`)
VALUES ('ams', NULL, 'ams', 'all', 'authorization_code,password,refresh_token,implicit,wechat,refresh_token',
        'http://www.baidu.com', NULL, 360000000, 720000, NULL, 'true', NULL, NULL, NULL, NULL);
