DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '种类id',
  `category_name` varchar(128) DEFAULT NULL COMMENT '种类名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '种类描述',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别表';

 
 DROP TABLE IF EXISTS `user_addr`;
CREATE TABLE `user_addr` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `street` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detail` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';



DROP TABLE IF EXISTS `logistics_info`;
CREATE TABLE `logistics_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '物流订单id',
  `recipients_id` int NOT NULL COMMENT '收件人id',
  `sender_id` int NOT NULL COMMENT '寄件人id',
  `status` int NOT NULL COMMENT '物流状态：0：开始 1：结束',
  `create_time` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流订单表';


DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `alias` varchar(64) DEFAULT NULL COMMENT '昵称',
  `photo` varchar(255) DEFAULT NULL COMMENT '头像url',
  `gender` smallint DEFAULT NULL COMMENT '性别：1：男 0：女',
  `default_addr` int DEFAULT NULL COMMENT '默认地址id',
  `register_time` bigint DEFAULT NULL COMMENT '注册时间',
  `update_time` bigint DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `FK_ADDR_ID` (`default_addr`),
  CONSTRAINT `FK_ADDR_ID` FOREIGN KEY (`default_addr`) REFERENCES `user_addr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';


DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `goods_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品描述',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品图片',
  `price` decimal(10,0) NOT NULL COMMENT '商品价格',
  `status` smallint NOT NULL COMMENT '商品状态',
  `category_id` int NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`id`),
  KEY `FK_CATEGORY_ID` (`category_id`),
  CONSTRAINT `FK_CATEGORY_ID` FOREIGN KEY (`category_id`) REFERENCES `goods_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';


DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int NOT NULL COMMENT '用户id',
  `goods_id` int NOT NULL COMMENT '商品id',
  `amount` int NOT NULL COMMENT '商品数量',
  `status` int NOT NULL COMMENT '订单状态：0：未支付  1：待发货 2：已发货 3：待评价 4：已完成',
  `logistics_id` int NOT NULL COMMENT '物流id',
  PRIMARY KEY (`id`),
  KEY `FK_LOGISTICS` (`logistics_id`),
  KEY `FK_USER_id` (`user_id`),
  KEY `FK_GOODs_id` (`goods_id`),
  CONSTRAINT `FK_GOODs_id` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`id`),
  CONSTRAINT `FK_LOGISTICS` FOREIGN KEY (`logistics_id`) REFERENCES `logistics_info` (`id`),
  CONSTRAINT `FK_USER_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';




DROP TABLE IF EXISTS `logistics_detail`;
CREATE TABLE `logistics_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '物流明细id',
  `distributor_id` int DEFAULT NULL COMMENT '配送员信息',
  `addr_info` varchar(255) DEFAULT NULL COMMENT '物流经过地点',
  `logistics_id` int DEFAULT NULL COMMENT '物流单id',
  `create_time` bigint DEFAULT NULL COMMENT '插入时间',
  PRIMARY KEY (`id`),
  KEY `FK_LOGISTICS_ID` (`logistics_id`),
  CONSTRAINT `FK_LOGISTICS_ID` FOREIGN KEY (`logistics_id`) REFERENCES `logistics_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流流转明细';


DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `sku_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku名称',
  `price` decimal(9,2) NOT NULL COMMENT '售价',
  `stock` int NOT NULL COMMENT '库存',
  `good_id` int NOT NULL COMMENT '商品id',
  `sku_create` bigint NOT NULL COMMENT '商品库存信息登记时间',
  `sku_update` bigint NOT NULL COMMENT '商品库存信息更新时间',
  PRIMARY KEY (`id`),
  KEY `FK_GOODS` (`good_id`),
  CONSTRAINT `FK_GOODS` FOREIGN KEY (`good_id`) REFERENCES `goods_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品库存表';



