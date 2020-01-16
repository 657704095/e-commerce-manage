-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.62 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 e-commerce 的数据库结构
CREATE DATABASE IF NOT EXISTS `e-commerce` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `e-commerce`;

-- 导出  表 e-commerce.commodity_sku 结构
CREATE TABLE IF NOT EXISTS `commodity_sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_no` int(11) NOT NULL COMMENT 'sku编号,唯一,商品编号',
  `sku_name` varchar(50) NOT NULL DEFAULT '0' COMMENT 'sku名称(冗余spu_name)',
  `price` double NOT NULL COMMENT '成本价',
  `stock` double NOT NULL COMMENT '库存(请自带单位)',
  `stock_unit` varchar(50) NOT NULL,
  `spu_id` int(11) DEFAULT NULL COMMENT '商品id',
  `merchant_id` int(11) DEFAULT NULL COMMENT '商家id',
  `state` int(11) NOT NULL COMMENT '1上架，2下架',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人挂admin',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sku_no` (`sku_no`),
  KEY `merchant_id` (`merchant_id`),
  KEY `spu_id` (`spu_id`),
  CONSTRAINT `FK_commodity_sku_commodity_spu` FOREIGN KEY (`spu_id`) REFERENCES `commodity_spu` (`id`),
  CONSTRAINT `FK_commodity_sku_t_merchant` FOREIGN KEY (`merchant_id`) REFERENCES `t_merchant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='接下来是SKU相关的表：\r\nSKU表：\r\n最小库存单元key\r\n因为有商品唯一编号，这个表示为厂库中某一个唯一的产品，自然有其对应的商家(某一类，不是某一个)';

-- 正在导出表  e-commerce.commodity_sku 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `commodity_sku` DISABLE KEYS */;
INSERT IGNORE INTO `commodity_sku` (`id`, `sku_no`, `sku_name`, `price`, `stock`, `stock_unit`, `spu_id`, `merchant_id`, `state`, `del`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`) VALUES
	(1, 15615, '1561651', 151, 1561, '1516', NULL, NULL, 1515, 515, '5151', '1515', '15115', 515),
	(3, 151516, '161515', 545, 156, '15164', NULL, NULL, 1364, 1, '1561', '1551', '1215', 121);
/*!40000 ALTER TABLE `commodity_sku` ENABLE KEYS */;

-- 导出  表 e-commerce.commodity_sku_map_spec_value 结构
CREATE TABLE IF NOT EXISTS `commodity_sku_map_spec_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) NOT NULL COMMENT '直接指向最小库存单元表sku',
  `spec_value_id` int(11) NOT NULL COMMENT '规格值id，用这个外键去查spec表，即可获得，sku的属性和sku值',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人挂admin',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  PRIMARY KEY (`id`),
  KEY `sku_id` (`sku_id`),
  KEY `spec_value_id` (`spec_value_id`),
  CONSTRAINT `FK_commodity_sku_spec_value_commodity_sku` FOREIGN KEY (`sku_id`) REFERENCES `commodity_sku` (`id`),
  CONSTRAINT `FK_commodity_sku_spec_value_commodity_spec_value` FOREIGN KEY (`spec_value_id`) REFERENCES `commodity_spec_value` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='SKU规格值表';

-- 正在导出表  e-commerce.commodity_sku_map_spec_value 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `commodity_sku_map_spec_value` DISABLE KEYS */;
INSERT IGNORE INTO `commodity_sku_map_spec_value` (`id`, `sku_id`, `spec_value_id`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`) VALUES
	(1, 1, 1, '2020-1-11 10:37', NULL, '1', 1),
	(2, 3, 1, '2020-1-11 10:37', '2020-1-11 10:44', '2', 1);
/*!40000 ALTER TABLE `commodity_sku_map_spec_value` ENABLE KEYS */;

-- 导出  表 e-commerce.commodity_spec 结构
CREATE TABLE IF NOT EXISTS `commodity_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_no` varchar(50) NOT NULL COMMENT '规格编号',
  `spec_name` varchar(50) NOT NULL COMMENT '规格名称',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人挂admin',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `spec_no` (`spec_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='然后是SPU,sku规格相关的表\r\n规格表：';

-- 正在导出表  e-commerce.commodity_spec 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `commodity_spec` DISABLE KEYS */;
INSERT IGNORE INTO `commodity_spec` (`id`, `spec_no`, `spec_name`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`, `del`) VALUES
	(1, '1', '属性值', '2020-1-11 10:35', NULL, '1', 1, 0),
	(3, '2', '属性值1', '2020-1-11 10:35', '2020-1-11 11:20', '2', 2, 1);
/*!40000 ALTER TABLE `commodity_spec` ENABLE KEYS */;

-- 导出  表 e-commerce.commodity_spec_value 结构
CREATE TABLE IF NOT EXISTS `commodity_spec_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_id` int(11) NOT NULL COMMENT '规格id',
  `spec_value` varchar(50) NOT NULL,
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人挂admin',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  KEY `spec_id` (`spec_id`),
  CONSTRAINT `FK_commodity_spec_value_commodity_spec` FOREIGN KEY (`spec_id`) REFERENCES `commodity_spec` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='然后是SPU规格相关的表：\r\n规格值表：\r\n\r\n一个规格，可以有多个规格值，\r\n但一个规格值，只能有一个规格';

-- 正在导出表  e-commerce.commodity_spec_value 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `commodity_spec_value` DISABLE KEYS */;
INSERT IGNORE INTO `commodity_spec_value` (`id`, `spec_id`, `spec_value`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`, `del`) VALUES
	(1, 1, '45', '2020-1-11', NULL, '1', 1, 0),
	(2, 3, '65', '2020-1-11', '2020-1-11 13:38', '2', 0, 0);
/*!40000 ALTER TABLE `commodity_spec_value` ENABLE KEYS */;

-- 导出  表 e-commerce.commodity_spu 结构
CREATE TABLE IF NOT EXISTS `commodity_spu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_commodity_type_id` int(11) NOT NULL COMMENT '商品类型id',
  `t_commodity_brand_id` int(11) NOT NULL COMMENT '商品品牌id',
  `spu_no` varchar(50) NOT NULL COMMENT '商品编号',
  `spu_name` varchar(50) NOT NULL COMMENT '商品名',
  `low_price` double NOT NULL COMMENT '最低售价',
  `img` varchar(50) NOT NULL COMMENT '商品图片路径',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人挂admin',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `spu_no` (`spu_no`),
  KEY `t_commodity_type_id` (`t_commodity_type_id`),
  KEY `t_commodity_brand_id` (`t_commodity_brand_id`),
  CONSTRAINT `FK_commodity_spu_t_commodity_brand` FOREIGN KEY (`t_commodity_brand_id`) REFERENCES `t_commodity_brand` (`id`),
  CONSTRAINT `FK_commodity_spu_t_commodity_type` FOREIGN KEY (`t_commodity_type_id`) REFERENCES `t_commodity_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品表\r\nimg默认为一张图片，其他类型的图片，用spu来添加，中的spec来添加';

-- 正在导出表  e-commerce.commodity_spu 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `commodity_spu` DISABLE KEYS */;
INSERT IGNORE INTO `commodity_spu` (`id`, `t_commodity_type_id`, `t_commodity_brand_id`, `spu_no`, `spu_name`, `low_price`, `img`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`, `del`) VALUES
	(1, 1, 1, '1', '年后', 11, '11', '2020-1-11 14:58', '2020-1-11 15:02', '12', 12, 0);
/*!40000 ALTER TABLE `commodity_spu` ENABLE KEYS */;

-- 导出  表 e-commerce.commodity_spu_map_spec 结构
CREATE TABLE IF NOT EXISTS `commodity_spu_map_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spu_id` int(11) NOT NULL,
  `spec_value_id` int(11) NOT NULL,
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人挂admin',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  KEY `spu_id` (`spu_id`),
  KEY `spec_id` (`spec_value_id`),
  CONSTRAINT `FK_commodity_spu_spec_commodity_spec` FOREIGN KEY (`spec_value_id`) REFERENCES `commodity_spec_value` (`id`),
  CONSTRAINT `FK_commodity_spu_spec_commodity_spu` FOREIGN KEY (`spu_id`) REFERENCES `commodity_spu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='spu和spec的映射表，一个商品基本信息可以对应多个spec基本属性(描述一个商品，但不影响商品库存和价格)';

-- 正在导出表  e-commerce.commodity_spu_map_spec 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `commodity_spu_map_spec` DISABLE KEYS */;
INSERT IGNORE INTO `commodity_spu_map_spec` (`id`, `spu_id`, `spec_value_id`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`, `del`) VALUES
	(1, 1, 2, '2020-1-14 9:21', NULL, '1', 1, 1),
	(2, 1, 1, '2020-1-14 9:21', '2020-1-14 9:27', '2', 2, 0);
/*!40000 ALTER TABLE `commodity_spu_map_spec` ENABLE KEYS */;

-- 导出  表 e-commerce.merchant_map_commodity 结构
CREATE TABLE IF NOT EXISTS `merchant_map_commodity` (
  `merchant_id` int(11) DEFAULT NULL COMMENT '商家',
  `commodity_sku_id` int(11) DEFAULT NULL COMMENT '商家的商品',
  KEY `merchant_id` (`merchant_id`),
  KEY `commodity_id` (`commodity_sku_id`),
  CONSTRAINT `FK_merchant_map_commodity_commodity` FOREIGN KEY (`commodity_sku_id`) REFERENCES `commodity_sku` (`id`),
  CONSTRAINT `FK_merchant_map_commodity_t_merchant` FOREIGN KEY (`merchant_id`) REFERENCES `t_merchant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商铺和商品的映射关系\r\n\r\n一个商铺可以有多个商品信息';

-- 正在导出表  e-commerce.merchant_map_commodity 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `merchant_map_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_map_commodity` ENABLE KEYS */;

-- 导出  表 e-commerce.merchant_map_order 结构
CREATE TABLE IF NOT EXISTS `merchant_map_order` (
  `merchant_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  KEY `merchant_id` (`merchant_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `FK_merchant_map_order_t_merchant` FOREIGN KEY (`merchant_id`) REFERENCES `t_merchant` (`id`),
  CONSTRAINT `FK_merchant_map_order_t_order` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家对应多个订单表';

-- 正在导出表  e-commerce.merchant_map_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `merchant_map_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_map_order` ENABLE KEYS */;

-- 导出  表 e-commerce.merchant_map_user 结构
CREATE TABLE IF NOT EXISTS `merchant_map_user` (
  `merchant_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  KEY `id` (`merchant_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `FK_merchant_map_user_t_merchant` FOREIGN KEY (`merchant_id`) REFERENCES `t_merchant` (`id`),
  CONSTRAINT `FK_merchant_map_user_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺和商家的映射关系';

-- 正在导出表  e-commerce.merchant_map_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `merchant_map_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_map_user` ENABLE KEYS */;

-- 导出  表 e-commerce.order_map_sku 结构
CREATE TABLE IF NOT EXISTS `order_map_sku` (
  `order_id` int(11) DEFAULT NULL,
  `commodity_sku_id` int(11) DEFAULT NULL,
  KEY `order_id` (`order_id`),
  KEY `commodity_sku_id` (`commodity_sku_id`),
  CONSTRAINT `FK_order_map_sku_commodity_sku` FOREIGN KEY (`commodity_sku_id`) REFERENCES `commodity_sku` (`id`),
  CONSTRAINT `FK_order_map_sku_t_order` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个订单下的多个商品';

-- 正在导出表  e-commerce.order_map_sku 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `order_map_sku` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_map_sku` ENABLE KEYS */;

-- 导出  表 e-commerce.t_address 结构
CREATE TABLE IF NOT EXISTS `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL COMMENT '唯一编码',
  `province` varchar(50) NOT NULL COMMENT '省份',
  `city` varchar(50) NOT NULL COMMENT '县',
  `district_or_town` varchar(50) NOT NULL COMMENT '镇，街道',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间，提供修改，但基本不修改',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人，挂admin的id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `province` (`province`),
  KEY `city` (`city`),
  KEY `district_or_town` (`district_or_town`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='地址表';

-- 正在导出表  e-commerce.t_address 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT IGNORE INTO `t_address` (`id`, `code`, `province`, `city`, `district_or_town`, `creation_time`, `modify_time`, `modify_id`) VALUES
	(1, '1', '四川', '成都', '高兴区', '2019-12-30 17:10', NULL, '1'),
	(5, '2', '四川', '成都', '天府新区', '2019-12-30 17:59', NULL, '1');
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;

-- 导出  表 e-commerce.t_address_minute 结构
CREATE TABLE IF NOT EXISTS `t_address_minute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` int(11) NOT NULL,
  `t_address_id` int(11) DEFAULT NULL COMMENT '地址表',
  `t_user_id` int(11) DEFAULT NULL COMMENT '用户表',
  `concreteness_address` varchar(50) NOT NULL COMMENT '具体地址',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人user，管理员不管理这个表',
  `modify_id_type` varchar(50) DEFAULT NULL COMMENT '1admin,2user',
  `del` int(1) DEFAULT '1' COMMENT '1使用，0删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `concreteness_address` (`concreteness_address`),
  UNIQUE KEY `code` (`code`),
  KEY `t_address_id` (`t_address_id`),
  KEY `t_user_id` (`t_user_id`),
  CONSTRAINT `FK_t_address_minute_t_address` FOREIGN KEY (`t_address_id`) REFERENCES `t_address` (`id`),
  CONSTRAINT `FK_t_address_minute_t_user` FOREIGN KEY (`t_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='地址详细表';

-- 正在导出表  e-commerce.t_address_minute 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_address_minute` DISABLE KEYS */;
INSERT IGNORE INTO `t_address_minute` (`id`, `code`, `t_address_id`, `t_user_id`, `concreteness_address`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`, `del`) VALUES
	(1, 0, 1, 1, '爱恨情仇长短', '2020-1-2 9:20', '2020-1-9 13:37', '1', '1', NULL),
	(5, 1, 1, 1, '爱恨情仇长短1112', '2020-1-2 9:20', '2020-1-9 13:37', '1', '1', 0);
/*!40000 ALTER TABLE `t_address_minute` ENABLE KEYS */;

-- 导出  表 e-commerce.t_admin 结构
CREATE TABLE IF NOT EXISTS `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) NOT NULL,
  `admin_pwd` varchar(50) NOT NULL,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_name` (`admin_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='设置一个默认账号有最高权限，通过后端业务层实现\r\n这个账号不能被删除，也不能被修改。';

-- 正在导出表  e-commerce.t_admin 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT IGNORE INTO `t_admin` (`id`, `admin_name`, `admin_pwd`, `creation_time`, `update_time`) VALUES
	(1, 'skylong', '159357', '2019-12-10 14:05:15', '2019-12-10 14:05:17'),
	(2, 'skylong2', '153157', '2019-12-12 10:03:10', NULL);
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;

-- 导出  表 e-commerce.t_commodity_brand 结构
CREATE TABLE IF NOT EXISTS `t_commodity_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '品牌名',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) NOT NULL COMMENT '修改人',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品品牌';

-- 正在导出表  e-commerce.t_commodity_brand 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_commodity_brand` DISABLE KEYS */;
INSERT IGNORE INTO `t_commodity_brand` (`id`, `name`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, '化为', '2020-1-11 14:52', NULL, '1', 0),
	(2, '小米', '2020-1-14 9:50', NULL, '1', 1),
	(5, '神来之笔', '2020-1-14 9:50', '2020-1-14 9:53', '0', 0);
/*!40000 ALTER TABLE `t_commodity_brand` ENABLE KEYS */;

-- 导出  表 e-commerce.t_commodity_type 结构
CREATE TABLE IF NOT EXISTS `t_commodity_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL COMMENT '分类名',
  `LV` int(11) NOT NULL COMMENT '分类等级',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) NOT NULL COMMENT '修改人',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品类型';

-- 正在导出表  e-commerce.t_commodity_type 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_commodity_type` DISABLE KEYS */;
INSERT IGNORE INTO `t_commodity_type` (`id`, `type`, `LV`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, '手机', 1, '2020-1-11 14:57', NULL, '1', 0),
	(2, '电脑', 1, '2020-1-14 10:06', NULL, '1', 1),
	(3, '墨水', 1, '2020-1-14 10:06', '2020-1-14', '1', 1);
/*!40000 ALTER TABLE `t_commodity_type` ENABLE KEYS */;

-- 导出  表 e-commerce.t_credit_key 结构
CREATE TABLE IF NOT EXISTS `t_credit_key` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) NOT NULL COMMENT '属性扩展键使用',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  `del` int(1) DEFAULT '1' COMMENT '1使用，0删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='信用表';

-- 正在导出表  e-commerce.t_credit_key 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_credit_key` DISABLE KEYS */;
INSERT IGNORE INTO `t_credit_key` (`id`, `key`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, '信用123', '2020-1-7 14:58', '2020-1-7 17:13', '1', 1),
	(3, '信用2', '2020-1-7 14:58', '2020-1-7 15:04', '0', 1),
	(4, '信用18', '2020-1-7 17:03', NULL, '1', 1);
/*!40000 ALTER TABLE `t_credit_key` ENABLE KEYS */;

-- 导出  表 e-commerce.t_credit_value 结构
CREATE TABLE IF NOT EXISTS `t_credit_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_credit_id` int(11) NOT NULL COMMENT '属性值的对应连接id',
  `t_user_id` int(11) DEFAULT NULL COMMENT '用户表',
  `value` varchar(50) NOT NULL COMMENT '信用值，同时作为扩展属性的值使用',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  `del` int(1) DEFAULT '1' COMMENT '1使用，0删除',
  PRIMARY KEY (`id`),
  KEY `t_credit_id` (`t_credit_id`),
  KEY `t_user_id` (`t_user_id`),
  CONSTRAINT `FK_t_credit_value_t_credit_key` FOREIGN KEY (`t_credit_id`) REFERENCES `t_credit_key` (`id`),
  CONSTRAINT `FK_t_credit_value_t_user` FOREIGN KEY (`t_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='信用值表，同时作为用户属性值的扩展使用';

-- 正在导出表  e-commerce.t_credit_value 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_credit_value` DISABLE KEYS */;
INSERT IGNORE INTO `t_credit_value` (`id`, `t_credit_id`, `t_user_id`, `value`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, 1, 1, '955', '2020-1-7 16:15', NULL, '1', 1),
	(2, 3, 2, '9546', '2020-1-7 16:15', '2020-1-7 16:41', '0', 1),
	(4, 1, 1, '15', '2020-1-7 17:57', '2020-1-7 18:03', '1', 1);
/*!40000 ALTER TABLE `t_credit_value` ENABLE KEYS */;

-- 导出  表 e-commerce.t_horseman 结构
CREATE TABLE IF NOT EXISTS `t_horseman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `ID_card` varchar(50) NOT NULL COMMENT '身份证',
  `safe_behavior_number` varchar(50) NOT NULL COMMENT '安全行为数，判断是不是好人',
  `creation_time` varchar(50) NOT NULL,
  `modify_time` varchar(50) DEFAULT NULL,
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人，挂上admin的id',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ID_card` (`ID_card`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='骑手表';

-- 正在导出表  e-commerce.t_horseman 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_horseman` DISABLE KEYS */;
INSERT IGNORE INTO `t_horseman` (`id`, `name`, `tel`, `ID_card`, `safe_behavior_number`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, '李某人', '18121', '510182', '1', '2020-1-16 10:28', NULL, '1', 1),
	(3, '李某人1', '1', '115151', '12', '2020-1-16 10:28', '2020-1-16', '0', 0);
/*!40000 ALTER TABLE `t_horseman` ENABLE KEYS */;

-- 导出  表 e-commerce.t_merchant 结构
CREATE TABLE IF NOT EXISTS `t_merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '商铺名称',
  `annual_fee` double NOT NULL COMMENT '年费',
  `monthly_fee` double NOT NULL COMMENT '月费',
  `t_address_minute_id` int(11) NOT NULL COMMENT '地址详情表',
  `t_credit_value_id` int(11) NOT NULL COMMENT '信用表，同时作为，属性扩展表',
  `creation_time` varchar(50) NOT NULL COMMENT '创建时间',
  `modify_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  KEY `t_address_minute_id` (`t_address_minute_id`),
  KEY `t_credit_value_id` (`t_credit_value_id`),
  KEY `name` (`name`),
  CONSTRAINT `FK_t_merchant_t_address_minute` FOREIGN KEY (`t_address_minute_id`) REFERENCES `t_address_minute` (`id`),
  CONSTRAINT `FK_t_merchant_t_credit_value` FOREIGN KEY (`t_credit_value_id`) REFERENCES `t_credit_value` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商家，以及商铺信息';

-- 正在导出表  e-commerce.t_merchant 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_merchant` DISABLE KEYS */;
INSERT IGNORE INTO `t_merchant` (`id`, `name`, `annual_fee`, `monthly_fee`, `t_address_minute_id`, `t_credit_value_id`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, '小优游戏专卖店', 100, 1551, 1, 1, '2020-1-14 11:25', NULL, '1', 0),
	(2, '小优游戏专卖店', 156, 1551, 5, 2, '2020-1-14 11:25', '2020-1-14 11:29', '0', 0);
/*!40000 ALTER TABLE `t_merchant` ENABLE KEYS */;

-- 导出  表 e-commerce.t_order 结构
CREATE TABLE IF NOT EXISTS `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(50) NOT NULL COMMENT '订单号',
  `t_merchant_id` int(11) NOT NULL COMMENT '商家id，标识被下单的商家',
  `t_user_id` int(11) NOT NULL COMMENT '买家id',
  `commodity_sku_id` int(1) DEFAULT NULL COMMENT '商品id，用来表示是什么商品被购买了//这个表废弃了，用映射表来表达一个订单所购买的商品',
  `amount` int(11) NOT NULL COMMENT '数量',
  `state` int(11) NOT NULL COMMENT '1下单，2退单',
  `creation_time` varchar(50) NOT NULL,
  `modify_time` varchar(50) DEFAULT NULL,
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人，挂上admin的id',
  `modify_id_type` int(11) DEFAULT NULL COMMENT '1admin,2user',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_number` (`order_number`),
  KEY `t_merchant_id` (`t_merchant_id`),
  KEY `t_user_id` (`t_user_id`),
  KEY `commodity_sku_id` (`commodity_sku_id`),
  CONSTRAINT `FK_t_order_commodity_sku` FOREIGN KEY (`commodity_sku_id`) REFERENCES `commodity_sku` (`id`),
  CONSTRAINT `FK_t_order_t_merchant` FOREIGN KEY (`t_merchant_id`) REFERENCES `t_merchant` (`id`),
  CONSTRAINT `FK_t_order_t_user` FOREIGN KEY (`t_user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 正在导出表  e-commerce.t_order 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT IGNORE INTO `t_order` (`id`, `order_number`, `t_merchant_id`, `t_user_id`, `commodity_sku_id`, `amount`, `state`, `creation_time`, `modify_time`, `modify_id`, `modify_id_type`, `del`) VALUES
	(1, '161515', 1, 1, NULL, 2, 0, '2020-1-14 18:16', '2020-1-14 18:25', '2', 1, 0);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;

-- 导出  表 e-commerce.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '账号',
  `user_nickname` varchar(50) DEFAULT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `user_question_encrypted` varchar(50) DEFAULT NULL COMMENT '问题密保',
  `user_question_encrypted_answer` varchar(50) DEFAULT NULL COMMENT '问题密保答案',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `ID_card` varchar(50) NOT NULL COMMENT '身份证',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `t_address_minute_id` int(1) DEFAULT NULL COMMENT '地址详情表/这个字段已经废弃',
  `t_credit_value_id` int(1) DEFAULT NULL COMMENT '信用表id，同时作为属性扩展使用',
  `creation_time` varchar(50) NOT NULL,
  `modify_time` varchar(50) DEFAULT NULL,
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人，挂上admin的id',
  `type` int(11) NOT NULL COMMENT '账号类型，1店家，2买家？',
  `del` int(1) DEFAULT '1' COMMENT '1使用，0删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `t_address_minute_id` (`t_address_minute_id`),
  KEY `t_credit_value_id` (`t_credit_value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户实体';

-- 正在导出表  e-commerce.t_user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT IGNORE INTO `t_user` (`id`, `user_name`, `user_nickname`, `user_pwd`, `user_question_encrypted`, `user_question_encrypted_answer`, `tel`, `email`, `ID_card`, `real_name`, `t_address_minute_id`, `t_credit_value_id`, `creation_time`, `modify_time`, `modify_id`, `type`, `del`) VALUES
	(1, 'skylong67', '爱恨情仇', '159357', '1561', '15656', '15615', '161515', '1561516', '516156', 1, 1, '51615', '156161', '516156', 1, NULL),
	(2, 'skylong65', '风花雪月1', '456852', '1346', '15486', '15156', '1515115', '6481684', '165184', 0, 0, '151615', '1615615', '156161', 0, NULL),
	(3, '你好', '打卡机SD卡a', '15615156', '你是谁？', '我是谁?', '18111216795', '67515151@qq.com', '1515615615156151', '离', NULL, NULL, '2020-1-9 14:39', '2020-1-9 14:40', '1', 1, 0);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 e-commerce.t_waybill 结构
CREATE TABLE IF NOT EXISTS `t_waybill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `waybill_number` varchar(50) NOT NULL COMMENT '运单号',
  `t_horseman_id` int(11) NOT NULL COMMENT '骑手的id表',
  `t_address_minute_id` int(11) NOT NULL COMMENT '当前所在地址表',
  `creation_time` varchar(50) NOT NULL,
  `modify_time` varchar(50) DEFAULT NULL,
  `modify_id` varchar(50) DEFAULT NULL COMMENT '修改人，挂上admin的id',
  `del` int(11) NOT NULL COMMENT '0删除，1存在',
  PRIMARY KEY (`id`),
  UNIQUE KEY `waybill_number` (`waybill_number`),
  KEY `t_horseman_id` (`t_horseman_id`),
  KEY `t_address_minute_id` (`t_address_minute_id`),
  CONSTRAINT `FK_t_waybill_t_address_minute` FOREIGN KEY (`t_address_minute_id`) REFERENCES `t_address_minute` (`id`),
  CONSTRAINT `FK_t_waybill_t_horseman` FOREIGN KEY (`t_horseman_id`) REFERENCES `t_horseman` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='运单表';

-- 正在导出表  e-commerce.t_waybill 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_waybill` DISABLE KEYS */;
INSERT IGNORE INTO `t_waybill` (`id`, `waybill_number`, `t_horseman_id`, `t_address_minute_id`, `creation_time`, `modify_time`, `modify_id`, `del`) VALUES
	(1, '151515', 1, 1, '2020-1-16 11:06', NULL, '1', 1),
	(4, '516151', 3, 5, '2020-1-16 11:06', '2020-1-16 11:09', '0', 0);
/*!40000 ALTER TABLE `t_waybill` ENABLE KEYS */;

-- 导出  表 e-commerce.user_map_order 结构
CREATE TABLE IF NOT EXISTS `user_map_order` (
  `user_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `order_if` (`order_id`),
  CONSTRAINT `FK_user_map_order_t_order` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `FK_user_map_order_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和订单的应关系\r\n\r\n一个用户可以有多个订单';

-- 正在导出表  e-commerce.user_map_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_map_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_map_order` ENABLE KEYS */;

-- 导出  表 e-commerce.waybill_map_order 结构
CREATE TABLE IF NOT EXISTS `waybill_map_order` (
  `waybill_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  KEY `waybill_id` (`waybill_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `FK_waybill_map_order_t_order` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `FK_waybill_map_order_t_waybill` FOREIGN KEY (`waybill_id`) REFERENCES `t_waybill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个运单对应多个订单表\r\n\r\n这里可能会出现空运单的情况';

-- 正在导出表  e-commerce.waybill_map_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `waybill_map_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `waybill_map_order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
