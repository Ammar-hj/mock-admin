-- -------------------------------------------------------------
-- TablePlus 3.11.0(352)
--
-- https://tableplus.com/
--
-- Database: mock_learn
-- Generation Time: 2023-03-15 11:16:38.3080
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `eureka_conf`;
CREATE TABLE `eureka_conf` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `server_name` varchar(32) NOT NULL DEFAULT '' COMMENT '服务名称（注册到eureka的名称）',
  `eureka_addr` varchar(100) NOT NULL COMMENT 'eureka地址',
  `is_start` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用，0未启用，1启用',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='注册中心配置表';

DROP TABLE IF EXISTS `mock_http_interface`;
CREATE TABLE `mock_http_interface` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `request_uri` varchar(255) NOT NULL COMMENT '请求uri',
  `request_method` varchar(255) NOT NULL COMMENT '请求方法',
  `description` varchar(255) NOT NULL COMMENT '描述',
  `need_async_callback` tinyint(1) NOT NULL COMMENT '是否异步回调',
  `config_mode` varchar(255) NOT NULL COMMENT '脚本类型',
  `response_body` mediumtext NOT NULL COMMENT 'mock响应内容',
  `callback_request_url` varchar(255) NOT NULL COMMENT '回调uri',
  `callback_request_method` varchar(255) NOT NULL COMMENT '回调uri对应方法',
  `callback_request_body` mediumtext NOT NULL COMMENT '回调请求内容',
  `branch_jump_script` mediumtext NOT NULL COMMENT '分支判断脚本',
  `sync_script` mediumtext NOT NULL COMMENT '同步脚本',
  `async_script` mediumtext NOT NULL COMMENT '异步脚本',
  `sync_delay` int NOT NULL COMMENT '同步等待时间',
  `async_delay` int NOT NULL COMMENT '异步超时时间',
  `is_start` tinyint(1) NOT NULL COMMENT '是否开启',
  `space_id` bigint NOT NULL COMMENT '命名空间ID',
  `last_update_user` varchar(255) NOT NULL COMMENT '最后修改人',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `access_authority` varchar(255) NOT NULL COMMENT '开放权限',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `mtime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_request_mapping` (`request_uri`,`request_method`) USING BTREE,
  KEY `idx_space_id` (`space_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPRESSED;

DROP TABLE IF EXISTS `mock_http_interface_header`;
CREATE TABLE `mock_http_interface_header` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `http_interface_id` bigint NOT NULL COMMENT '接口ID',
  `name` varchar(255) NOT NULL COMMENT 'header名称',
  `value` varchar(255) NOT NULL COMMENT 'header值',
  `type` varchar(255) NOT NULL COMMENT '类型(request或者response)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`http_interface_id`,`name`,`type`) USING BTREE,
  KEY `idx_http_interface_id` (`http_interface_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `mock_http_interface_snapshot`;
CREATE TABLE `mock_http_interface_snapshot` (
  `http_interface_id` bigint NOT NULL COMMENT '接口ID',
  `http_interface_request_uri` varchar(255) NOT NULL COMMENT '接口uri',
  `http_interface_request_method` varchar(255) NOT NULL COMMENT '接口请求方法',
  `http_interface_space_id` bigint NOT NULL COMMENT '命名空间ID',
  `http_interface` mediumtext NOT NULL COMMENT '接口信息',
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `op_type` varchar(255) NOT NULL COMMENT '操作类型',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `mtime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_id` (`http_interface_id`) USING BTREE,
  KEY `idx_request_mapping` (`http_interface_request_uri`,`http_interface_request_method`) USING BTREE,
  KEY `idx_space_id` (`http_interface_space_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=320 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `mock_interface_branch`;
CREATE TABLE `mock_interface_branch` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `http_interface_id` bigint NOT NULL COMMENT '接口ID',
  `name` varchar(255) NOT NULL COMMENT '分支名称',
  `sync_script` mediumtext NOT NULL COMMENT '同步脚本',
  `async_script` mediumtext NOT NULL COMMENT '异步脚本',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`http_interface_id`,`name`) USING BTREE,
  KEY `idx_http_interface_id` (`http_interface_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `mock_space`;
CREATE TABLE `mock_space` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `label` varchar(255) NOT NULL COMMENT '空间名称',
  `parent_id` bigint NOT NULL COMMENT '父节点ID',
  `access_authority` varchar(255) NOT NULL COMMENT '开放权限',
  `level` int NOT NULL COMMENT '目录层级',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `mtime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_label` (`label`,`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码, MD5加密',
  `role` int NOT NULL DEFAULT '1' COMMENT '角色1-普通用户，2-管理员',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表 ';


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;