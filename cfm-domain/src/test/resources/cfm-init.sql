
CREATE TABLE IF NOT EXISTS `base_config` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) NOT NULL COMMENT '类型',
  `param_code` varchar(64) NOT NULL COMMENT '参数编码',
  `param_value` varchar(255) NOT NULL COMMENT '参数值',
  `system_code` varchar(32) NOT NULL COMMENT '系统编码',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `operator_code` varchar(32) DEFAULT NULL COMMENT '操作人',
  `time_insert` datetime DEFAULT NULL,
  `time_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
