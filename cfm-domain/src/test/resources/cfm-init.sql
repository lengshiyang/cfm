-- --------------------------------------------------------
-- 主机:                           10.16.30.142
-- 服务器版本:                        5.6.35 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 ibforensic.base_config 结构
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

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
