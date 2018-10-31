
USE `suyan_order`;

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `order_no` varchar(32) DEFAULT NULL COMMENT '订单号',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `actual_amount` decimal(12,2) DEFAULT NULL COMMENT '实际支付金额',
  `promotion_amount` decimal(12,2) DEFAULT NULL COMMENT '促销金额',
  `province_id` int(11) DEFAULT NULL COMMENT '省',
  `city_id` int(11) DEFAULT NULL COMMENT '市',
  `area_id` int(11) DEFAULT NULL COMMENT '区',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `is_postage` bit(1) DEFAULT NULL COMMENT '是否有邮费',
  `postage` decimal(12,2) DEFAULT NULL COMMENT '邮费',
  `common_status` tinyint(4) unsigned DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS `tb_order_detail`;

CREATE TABLE `tb_order_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` bigint(20) unsigned DEFAULT NULL COMMENT '订单id',
  `sku_id` bigint(20) unsigned DEFAULT NULL COMMENT '商品id',
  `sku_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `sku_number` decimal(12,2) DEFAULT NULL COMMENT '商品数量',
  `sku_price` decimal(12,2) DEFAULT NULL COMMENT '商品价格',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `actual_amount` decimal(12,2) DEFAULT NULL COMMENT '实际支付金额',
  `promotion_amount` decimal(12,2) DEFAULT NULL COMMENT '促销金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详细表';

DROP TABLE IF EXISTS `tb_order_promotion`;

CREATE TABLE `tb_order_promotion` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` bigint(20) unsigned DEFAULT NULL COMMENT '订单id',
  `promotion_type` tinyint(4) unsigned DEFAULT NULL COMMENT '促销类型',
  `promotion_id` bigint(20) unsigned DEFAULT NULL COMMENT '促销id',
  `promotion_amount` decimal(12,2) DEFAULT NULL COMMENT '促销金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单促销表';

