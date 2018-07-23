DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `jobid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `jobname` varchar(40) DEFAULT NULL COMMENT '任务名称',
  `jobgroup` varchar(40) DEFAULT NULL COMMENT '任务分组',
  `jobstatus` char(1) NOT NULL DEFAULT '1' COMMENT '任务状态 0禁用 1启用',
  `auditstatus` char(1) NOT NULL DEFAULT '0' COMMENT '审核状态 0 已创建 1 审核通过 2 审核驳回',
  `cronexpression` varchar(40) NOT NULL COMMENT '任务运行时间表达式',
  `quartzclass` varchar(255) DEFAULT NULL COMMENT '定时任务处理类',
  `description` varchar(500) DEFAULT NULL COMMENT '描述信息',
  `receiver` text,
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'test', 'notice', '0', '1', '0 5/11 * * * ?', 'com.example.demo.task.Task1', '', null);
