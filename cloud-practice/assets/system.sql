-- MySQL dump 10.13  Distrib 8.0.29, for macos12.2 (arm64)
--
-- Host: 182.92.152.31    Database: my_admin
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `sys_client`
--

DROP TABLE IF EXISTS `sys_client`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_client`
(
    `id`                             int       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`                        int       NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`                        bit(1)    NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time`                    timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`                    timestamp NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `client_id`                      varchar(256)       DEFAULT NULL COMMENT '必填，Oauth2 client_id',
    `client_secret`                  varchar(256)       DEFAULT NULL COMMENT '必填，Oauth2 client_secret',
    `scope`                          varchar(256)       DEFAULT NULL COMMENT '必填，Oauth2 权限范围，比如 read，write，all 等可自定义',
    `resource_ids`                   varchar(256)       DEFAULT NULL COMMENT '可选，资源id集合，多个资源用英文逗号隔开',
    `authorized_grant_types`         varchar(256)       DEFAULT NULL COMMENT '必填，Oauth2 授权类型，支持类型：authorization_code,password,refresh_token,implicit,client_credentials,多个用英文逗号隔开',
    `registered_redirect_uris`       varchar(256)       DEFAULT NULL COMMENT '可选，客户端的重定向URI,当grant_type为authorization_code或implicit时,此字段是需要的,逗号分隔',
    `authorities`                    varchar(256)       DEFAULT NULL COMMENT '可选，指定客户端所拥有的Spring Security的权限值',
    `access_token_validity_seconds`  int                DEFAULT NULL COMMENT '可选，access_token的有效时间值(单位:秒)，不填写框架(类refreshTokenValiditySeconds)默认12小时',
    `refresh_token_validity_seconds` int                DEFAULT NULL COMMENT '可选，refresh_token的有效时间值(单位:秒)，不填写框架(类refreshTokenValiditySeconds)默认30天',
    `additional_information`         varchar(4096)      DEFAULT NULL COMMENT '预留字段，格式必须是json',
    `auto_approve`                   varchar(256)       DEFAULT NULL COMMENT '授权码模式自动审批scopes，以英文逗号分隔',
    PRIMARY KEY (`id`),
    UNIQUE KEY `client_id` (`client_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统客户端信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_client`
--

LOCK TABLES `sys_client` WRITE;
/*!40000 ALTER TABLE `sys_client`
    DISABLE KEYS */;
INSERT INTO `sys_client`
VALUES (1, 0, _binary '\0', '2022-06-28 01:38:52', NULL, 'rui',
        '$2a$10$VKBPnlfn0rp9xFmGpbrHD.P/DC3OcV/pqVT4Vk0qjBsG8SdMbTvjy', 'web_app', NULL,
        'password,refresh_token,authorization_code,implicit', NULL, NULL, 7200, 36000, NULL, NULL);
/*!40000 ALTER TABLE `sys_client`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_log`
(
    `id`            int          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`       int          NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`       bit(1)       NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `request_url`   varchar(255) NOT NULL COMMENT '请求地址',
    `business_name` varchar(50)  NOT NULL COMMENT '业务名称',
    `http_method`   varchar(10)  NOT NULL COMMENT '请求方式',
    `class_name`    varchar(100) NOT NULL COMMENT '类名',
    `method`        varchar(100) NOT NULL COMMENT '请求方法',
    `ip`            varchar(100) NOT NULL COMMENT '请求IP',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu`
(
    `id`             int         NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`        int         NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`        bit(1)      NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time`    timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    timestamp   NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `name`           varchar(50) NOT NULL COMMENT '菜单名称',
    `path`           varchar(100)         DEFAULT NULL COMMENT '菜单路径',
    `component`      varchar(50)          DEFAULT NULL COMMENT '菜单组件',
    `component_name` varchar(50)          DEFAULT NULL COMMENT '组件名称',
    `icon`           varchar(50)          DEFAULT NULL COMMENT '菜单图标',
    `hidden`         bit(1)      NOT NULL DEFAULT b'0' COMMENT '是否隐藏',
    `authority`      varchar(255)         DEFAULT NULL COMMENT '权限标识',
    `always_show`    bit(1)               DEFAULT b'0' COMMENT '是否为根目录',
    `parent_id`      int                  DEFAULT '-1' COMMENT '父级ID',
    `sort`           int                  DEFAULT '0' COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu`
    DISABLE KEYS */;
INSERT INTO `sys_menu`
VALUES (1, 0, _binary '\0', '2022-03-28 07:02:05', '2022-03-29 01:49:09', '根目录', '/', 'Layout', NULL, NULL,
        _binary '\0', NULL, _binary '\0', -1, 0),
       (2, 0, _binary '\0', '2022-03-28 07:08:24', '2022-04-03 12:39:09', '系统工具', '/system', 'Layout', 'system',
        'el-icon-s-tools', _binary '\0', '', _binary '', 1, 1),
       (3, 1, _binary '\0', '2022-03-29 03:16:41', '2022-04-08 03:31:22', '系统菜单', 'menu', '/system/menu', 'Menu',
        'tree-table', _binary '\0', 'get:/rui/admin/menu/list', _binary '\0', 2, 1),
       (4, 0, _binary '\0', '2022-04-01 09:27:26', '2022-04-03 12:39:09', '权限管理', 'permisson', '/system/permisson',
        'Permisson', 'el-icon-s-operation', _binary '\0', '', _binary '\0', 2, 2),
       (5, 1, _binary '\0', '2022-04-03 13:51:04', '2022-04-08 04:03:52', '角色管理', 'role', '/system/role', 'Role',
        'el-icon-s-operation', _binary '\0', 'get:/rui/admin/role/pageList', _binary '\0', 2, 3);
/*!40000 ALTER TABLE `sys_menu`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permissions`
--

DROP TABLE IF EXISTS `sys_permissions`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permissions`
(
    `id`          varchar(255) NOT NULL COMMENT 'ID',
    `version`     int          NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`     bit(1)       NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `module_name` varchar(50)  NOT NULL COMMENT '模块名',
    `func_name`   varchar(50)  NOT NULL COMMENT '功能名称',
    `authority`   varchar(255) NOT NULL COMMENT '权限标识',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permissions`
--

LOCK TABLES `sys_permissions` WRITE;
/*!40000 ALTER TABLE `sys_permissions`
    DISABLE KEYS */;
INSERT INTO `sys_permissions`
VALUES ('0dacf680-d5c3-4dc7-92bd-42c32b50253c', 0, _binary '\0', '2022-05-17 09:16:24', NULL, '菜单管理', '修改菜单',
        'put:/rui/admin/menu/edit'),
       ('1512372432965619713', 0, _binary '', '2022-04-08 10:11:01', '2022-04-08 10:17:01', '菜单管理', '添加菜单',
        'post:/rui/admin/menu/add'),
       ('1512372433393438721', 0, _binary '', '2022-04-08 10:11:01', '2022-04-08 10:17:01', '菜单管理', '修改菜单',
        'put:/rui/admin/menu/edit'),
       ('1512372433397633026', 0, _binary '', '2022-04-08 10:11:01', '2022-04-08 10:17:01', '菜单管理', '菜单列表',
        'get:/rui/admin/menu/menuList'),
       ('1512372433397633027', 0, _binary '', '2022-04-08 10:11:01', '2022-04-08 10:17:01', '权限管理', '获取权限列表',
        'get:/rui/admin/permissions/getPermissions'),
       ('1512372433401827330', 0, _binary '', '2022-04-08 10:11:01', '2022-04-08 10:17:01', '权限管理', '同步权限',
        'post:/rui/admin/permissions/syncPermission'),
       ('1aebab6f-23be-4bbd-9666-8cdbdeea71ef', 0, _binary '\0', '2022-05-17 09:16:24', NULL, '菜单管理', '添加菜单',
        'post:/rui/admin/menu/add'),
       ('5610136f-b7d9-4e6c-adf3-0e4c7f22d35d', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '菜单管理',
        '菜单列表', 'get:/rui/admin/menu/menuList'),
       ('5a8011ee-210e-4abb-9730-efec1226ebfc', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '权限管理',
        '同步权限', 'post:/rui/admin/permissions/syncPermission'),
       ('5c742ca6-08c7-41e7-855a-bbb6f223af3b', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '权限管理',
        '获取权限列表', 'get:/rui/admin/permissions/getPermissions'),
       ('61767700-c97c-4827-83c2-c9c57b88088f', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '菜单管理',
        '菜单列表', 'get:/rui/admin/menu/menuList'),
       ('656f317e-2b60-4981-80b6-2a293f87f6fa', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '菜单管理',
        '添加菜单', 'post:/rui/admin/menu/add'),
       ('69b0151b-354e-47f5-b484-1efd30c75142', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '菜单管理',
        '修改菜单', 'put:/rui/admin/menu/edit'),
       ('72bab514-f429-469b-8f49-8c84eb54504c', 0, _binary '\0', '2022-05-17 09:16:24', NULL, '菜单管理', '菜单列表',
        'get:/rui/admin/menu/menuList'),
       ('7a45a832-469e-40e6-8e4f-f5abf0c87c6c', 0, _binary '', '2022-05-13 08:30:46', '2022-05-17 09:16:23', '菜单管理',
        '菜单列表', 'get:/rui/admin/menu/menuList'),
       ('80327aa7-513b-46cc-adfa-9d6ae8771cbc', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '菜单管理',
        '添加菜单', 'post:/rui/admin/menu/add'),
       ('a0be0505-da08-4234-a19b-c87f40b81736', 0, _binary '', '2022-05-13 08:30:46', '2022-05-17 09:16:23', '菜单管理',
        '修改菜单', 'put:/rui/admin/menu/edit'),
       ('b3d44b5c-9afb-4fdc-a4de-53ae08253269', 0, _binary '\0', '2022-05-17 09:16:24', NULL, '权限管理', '同步权限',
        'post:/rui/admin/permissions/syncPermission'),
       ('b79b6bce-5401-4bb8-a57d-d4aaa299ff86', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '菜单管理',
        '修改菜单', 'put:/rui/admin/menu/edit'),
       ('c0d6886f-646a-4819-b28b-c435357e5c05', 0, _binary '', '2022-05-13 08:30:46', '2022-05-17 09:16:23', '权限管理',
        '同步权限', 'post:/rui/admin/permissions/syncPermission'),
       ('d123f097-7c5c-457c-82f4-3753ccf4bed1', 0, _binary '', '2022-05-13 08:30:46', '2022-05-17 09:16:23', '菜单管理',
        '添加菜单', 'post:/rui/admin/menu/add'),
       ('da0d8027-f5a4-461f-b2dc-5e5c6fe82cbb', 0, _binary '\0', '2022-05-17 09:16:24', NULL, '权限管理', '获取权限列表',
        'get:/rui/admin/permissions/getPermissions'),
       ('e000f03e-74c7-4a7b-9efe-16288d271fdb', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '权限管理',
        '获取权限列表', 'get:/rui/admin/permissions/getPermissions'),
       ('e6ec2d6c-f384-46fc-a116-e2a30b9593b5', 0, _binary '', '2022-04-08 10:17:02', '2022-05-13 08:30:46', '权限管理',
        '同步权限', 'post:/rui/admin/permissions/syncPermission'),
       ('f7d16729-aeae-4888-ad52-4b2922d640d3', 0, _binary '', '2022-05-13 08:30:46', '2022-05-17 09:16:23', '权限管理',
        '获取权限列表', 'get:/rui/admin/permissions/getPermissions');
/*!40000 ALTER TABLE `sys_permissions`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role`
(
    `id`          int         NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`     int         NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`     bit(1)      NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp   NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `name`        varchar(50) NOT NULL COMMENT '角色名称',
    `name_zh`     varchar(50)          DEFAULT NULL COMMENT '角色中文名',
    `enable`      bit(1)      NOT NULL DEFAULT b'1' COMMENT '是否被禁用',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role`
    DISABLE KEYS */;
INSERT INTO `sys_role`
VALUES (1, 0, _binary '\0', '2022-03-23 04:06:26', '2022-03-23 04:17:35', 'admin', '系统管理员', _binary '');
/*!40000 ALTER TABLE `sys_role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu`
(
    `id`          int       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`     int       NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`     bit(1)    NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `role_id`     int       NOT NULL COMMENT '角色ID',
    `menu_id`     int       NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu`
    DISABLE KEYS */;
INSERT INTO `sys_role_menu`
VALUES (1, 0, _binary '\0', '2022-03-23 04:11:53', NULL, 1, 1),
       (2, 0, _binary '\0', '2022-03-28 07:09:34', NULL, 1, 2),
       (3, 0, _binary '\0', '2022-03-29 03:19:01', NULL, 1, 3),
       (4, 0, _binary '\0', '2022-04-03 13:07:03', NULL, 1, 4),
       (5, 0, _binary '\0', '2022-04-08 04:01:27', NULL, 1, 5);
/*!40000 ALTER TABLE `sys_role_menu`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permissions`
--

DROP TABLE IF EXISTS `sys_role_permissions`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_permissions`
(
    `id`          int          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`     int          NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`     bit(1)       NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `role_id`     int          NOT NULL COMMENT '角色ID',
    `authority`   varchar(255) NOT NULL COMMENT '权限标识',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permissions`
--

LOCK TABLES `sys_role_permissions` WRITE;
/*!40000 ALTER TABLE `sys_role_permissions`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_permissions`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_user`
--

DROP TABLE IF EXISTS `sys_role_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_user`
(
    `id`          int       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`     int       NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`     bit(1)    NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `role_id`     int       NOT NULL COMMENT '角色ID',
    `user_id`     int       NOT NULL COMMENT '用户ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色用户关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user`
--

LOCK TABLES `sys_role_user` WRITE;
/*!40000 ALTER TABLE `sys_role_user`
    DISABLE KEYS */;
INSERT INTO `sys_role_user`
VALUES (1, 0, _binary '\0', '2022-03-23 04:11:53', NULL, 1, 1);
/*!40000 ALTER TABLE `sys_role_user`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user`
(
    `id`          int          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `version`     int          NOT NULL DEFAULT '0' COMMENT '版本',
    `deleted`     bit(1)       NOT NULL DEFAULT b'0' COMMENT '删除标识',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `username`    varchar(50)  NOT NULL COMMENT '用户名',
    `password`    varchar(255) NOT NULL COMMENT '密码',
    `name`        varchar(50)           DEFAULT NULL COMMENT '姓名',
    `gender`      int                   DEFAULT NULL COMMENT '性别 0-男 1-女',
    `birthday`    timestamp    NULL     DEFAULT NULL COMMENT '出身日期',
    `phone`       varchar(20)           DEFAULT NULL COMMENT '电话',
    `address`     varchar(200)          DEFAULT NULL COMMENT '住址',
    `email`       varchar(200)          DEFAULT NULL COMMENT '邮箱',
    `enable`      bit(1)       NOT NULL DEFAULT b'1' COMMENT '是否被禁用',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user`
    DISABLE KEYS */;
INSERT INTO `sys_user`
VALUES (1, 3, _binary '\0', '2022-03-16 14:24:58', '2022-03-23 04:17:48', 'admin',
        '$2a$10$rONggf7OrXZEUYZWWatCtOtGxf/fgXRcFznXjMUwCE8nfWcArUQTq', '张三', 0, '1987-05-05 07:22:00', '17685178016',
        '湖南省长沙市岳麓区', 'xxx@qq.com', _binary '');
/*!40000 ALTER TABLE `sys_user`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-07-01 17:10:11
