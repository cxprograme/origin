-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
-- Server version	5.7.12


--
-- Table structure for table `power_group`
--
CREATE TABLE `power_group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '组织机构编号',
  `group_pid` bigint(20) NOT NULL DEFAULT '0' COMMENT '上级组织机构编号',
  `group_name` varchar(100) NOT NULL COMMENT '组织机构名称',
  `group_desc` varchar(255) DEFAULT NULL COMMENT '组织机构描述',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志\r\n            0未删除\r\n            1已删除',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '排序号',
  `group_type` tinyint(1) DEFAULT NULL COMMENT '机构类型（1总队2大队3中队4科室）',
  `group_level` varchar(255) DEFAULT '' COMMENT '组织机构层级关系',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COMMENT='组织机构信息表';

--
-- Table structure for table `power_menu`
--
CREATE TABLE `power_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `menu_pid` bigint(20) NOT NULL DEFAULT '0' COMMENT '上级菜单编号',
  `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `order_id` bigint(20) DEFAULT '0',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COMMENT='菜单信息';

--
-- Table structure for table `power_permission`
--
CREATE TABLE `power_permission` (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `privilege_id` bigint(20) DEFAULT NULL COMMENT '受控对象编号',
  `permission_name` varchar(100) NOT NULL COMMENT '权限名称',
  `permission_type` tinyint(4) DEFAULT NULL COMMENT '权限类型\r\n            0普通权限\r\n            1菜单权限\r\n            2操作权限',
  `permission_code` varchar(100) NOT NULL COMMENT '权限编码',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '排序号',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COMMENT='权限信息表';

--
-- Table structure for table `power_role`
--
CREATE TABLE `power_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '启用标志',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

--
-- Table structure for table `power_schedule`
--
CREATE TABLE `power_schedule` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '任务编号',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `job_cron` varchar(20) DEFAULT NULL COMMENT '任务执行时间表达式',
  `job_class_path` varchar(255) DEFAULT NULL COMMENT '任务执行类完整路径',
  `job_status` varchar(45) DEFAULT NULL COMMENT '任务状态 stop 停止 start 启动 pause 暂停',
  `job_description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='任务计划';

--
-- Table structure for table `power_user`
--
CREATE TABLE `power_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_account` varchar(255) NOT NULL COMMENT '用户账号',
  `user_password` varchar(255) NOT NULL COMMENT '用户登录密码',
  `user_salt` varchar(32) NOT NULL COMMENT '用户盐',
  `user_nickname` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `user_realname` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  `user_sex` tinyint(4) DEFAULT NULL COMMENT '用户性别',
  `user_age` tinyint(3) DEFAULT NULL COMMENT '用户年龄',
  `user_birthday` date DEFAULT NULL COMMENT '出生日期',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '用户手机',
  `user_email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `locked` tinyint(4) NOT NULL DEFAULT '0' COMMENT '锁定标志',
  `enabled` tinyint(4) NOT NULL DEFAULT '0' COMMENT '启用标志',
  `last_login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `failed_login_date` datetime DEFAULT NULL COMMENT '登录失败时间',
  `failed_count` tinyint(4) DEFAULT '0' COMMENT '登录失败次数',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

--
-- Table structure for table `rel_group_user`
--
CREATE TABLE `rel_group_user` (
  `group_id` bigint(20) NOT NULL COMMENT '组织机构编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`group_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织机构与用户关联信息';

--
-- Table structure for table `rel_role_permission`
--
CREATE TABLE `rel_role_permission` (
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色与权限关联信息';

--
-- Table structure for table `rel_user_role`
--
CREATE TABLE `rel_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色关联信息';

--
-- Table structure for table `t_company`
--
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业编号',
  `name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `trade` varchar(45) DEFAULT NULL COMMENT '企业所属行业',
  `ev_manager` varchar(45) DEFAULT NULL COMMENT '环保负责人',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系手机',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系固定电话',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='企业单位基本信息';

--
-- Table structure for table `t_company_manage_config`
--
CREATE TABLE `t_company_manage_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `company_id` int(11) DEFAULT NULL COMMENT '所属企业编号',
  `group_id` int(11) DEFAULT NULL COMMENT '管理机构编号',
  `company_type` tinyint(4) DEFAULT '0' COMMENT '企业类型 0:一般1:重点',
  `group_model` tinyint(1) DEFAULT '0' COMMENT '分组模式 0:非分组模式1:分组模式',
  `fix_num` int(11) DEFAULT NULL COMMENT '固定人数',
  `random_num` int(11) DEFAULT NULL COMMENT '随机人数',
  `random_type` tinyint(1) DEFAULT NULL COMMENT '随机抽取方式 0:年1:季度2:月3:周4:自定义',
  `random_days` int(11) DEFAULT NULL COMMENT '抽查天数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='企业管理模式信息';

--
-- Table structure for table `t_company_point`
--
CREATE TABLE `t_company_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点位编号',
  `company_id` int(11) DEFAULT NULL COMMENT '所属企业编号',
  `point_name` varchar(255) DEFAULT NULL COMMENT '点位名称',
  `point_desc` varchar(255) DEFAULT NULL COMMENT '点位描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  `group_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='企业监管点位信息';

--
-- Table structure for table `t_company_random`
--
CREATE TABLE `t_company_random` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业抽取结果编号',
  `month` varchar(45) DEFAULT NULL COMMENT '所属月份',
  `year` varchar(45) DEFAULT NULL COMMENT '所属年份',
  `company_id` int(11) DEFAULT NULL COMMENT '企业编号',
  `manage_group_id` int(11) DEFAULT NULL COMMENT '管理机构编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `record_date` date NOT NULL COMMENT '抽取纪录日期',
  `batch_no` varchar(40) NOT NULL COMMENT '批次号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='企业随机抽取纪录信息';

--
-- Table structure for table `t_config_holiday`
--
CREATE TABLE `t_config_holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `holiday_date` date DEFAULT NULL COMMENT '节假日日期',
  `status` tinyint(4) DEFAULT '1' COMMENT '设置状态0工作日 1休息日',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `holiday_name` varchar(45) DEFAULT '休息日',
  PRIMARY KEY (`id`),
  UNIQUE KEY `holiday_date_UNIQUE` (`holiday_date`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='节假日配置信息';

--
-- Table structure for table `t_config_rule_group`
--
CREATE TABLE `t_config_rule_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL COMMENT '所属机构编号',
  `normal_group` tinyint(1) DEFAULT NULL COMMENT '一般企业分组模式',
  `important_group` tinyint(1) DEFAULT NULL COMMENT '重点企业分组模式',
  `normal_fix` int(11) DEFAULT NULL COMMENT '一般企业固定人员数',
  `important_fix` int(11) DEFAULT NULL COMMENT '重点企业固定人员数',
  `normal_random` int(11) DEFAULT NULL COMMENT '一般企业随机人员数',
  `important_random` int(11) DEFAULT NULL COMMENT '重点企业随机人员数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='抽取规则分组模式配置';

--
-- Table structure for table `t_config_rule_type`
--
CREATE TABLE `t_config_rule_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `group_id` int(11) DEFAULT NULL COMMENT '所属机构编号',
  `type_id` varchar(45) DEFAULT NULL COMMENT '分类属性编号',
  `proportion` int(11) DEFAULT NULL COMMENT '比重值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='抽取规则分类比重配置';

--
-- Table structure for table `t_dict`
--
CREATE TABLE `t_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type_code` varchar(255) DEFAULT NULL COMMENT '类型编码',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='数据字典分类信息';

--
-- Table structure for table `t_dict_detail`
--
CREATE TABLE `t_dict_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_type` int(11) DEFAULT NULL COMMENT '所属分类',
  `detail_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `detail_code` varchar(255) DEFAULT NULL COMMENT '编码',
  `detail_sort` varchar(45) DEFAULT NULL COMMENT '排序号',
  `detail_type` varchar(255) DEFAULT NULL COMMENT '类型',
  `detail_state` varchar(255) DEFAULT NULL COMMENT '状态',
  `detail_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `detail_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='数据字典详情信息';

--
-- Table structure for table `t_execute_detail`
--
CREATE TABLE `t_execute_detail` (
  `id` int(11) NOT NULL COMMENT '纪录编号',
  `feedback_id` int(11) DEFAULT NULL COMMENT '对应反馈编号',
  `execute_group_Id` varchar(45) DEFAULT NULL COMMENT '处理机构编号',
  `execute_detail` varchar(255) DEFAULT NULL COMMENT '处理意见',
  `end_date` date DEFAULT NULL COMMENT '限办日期',
  `status` tinyint(1) DEFAULT NULL COMMENT '处理状态 0:待处理 1:已回复2:已办结',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='执法反馈处理纪录';

--
-- Table structure for table `t_execute_feedback`
--
CREATE TABLE `t_execute_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈编号',
  `plan_id` int(11) DEFAULT NULL COMMENT '反馈对应计划编号',
  `check_content` text COMMENT '检查内容',
  `process_status` int(11) DEFAULT NULL COMMENT '处理状态 0 未填报 1 未发现异常 2 责令整改 3 立案查处',
  `check_date` date DEFAULT NULL COMMENT '检查日期',
  `attach_file` json DEFAULT NULL COMMENT '反馈附件',
  `status` varchar(45) DEFAULT NULL COMMENT '反馈状态0 待处理 1 已办结 2已回复',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='执法反馈信息';

--
-- Table structure for table `t_executor_random`
--
CREATE TABLE `t_executor_random` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '执法人员抽取纪录编号',
  `year` varchar(45) DEFAULT NULL COMMENT '年份',
  `company_id` varchar(45) DEFAULT NULL COMMENT '抽查企业编号',
  `check_date` date DEFAULT NULL COMMENT '监察日期',
  `executor` int(11) DEFAULT NULL COMMENT '监察人编号',
  `create_date` varchar(45) DEFAULT NULL COMMENT '创建时间',
  `modify_date` varchar(45) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='执法者抽取纪录信息';

--
-- Table structure for table `t_law_executor`
--
CREATE TABLE `t_law_executor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '执法者编号',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `group_id` int(11) DEFAULT NULL COMMENT '所属机构',
  `department_id` varchar(45) DEFAULT NULL COMMENT '所属',
  `duty_id` varchar(45) DEFAULT NULL COMMENT '职务编号',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `aptitudes` tinyint(1) DEFAULT NULL COMMENT '资质 1:资深2:普通',
  `workload` int(11) DEFAULT NULL COMMENT '工作量',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='执法者基本信息';

--
-- Table structure for table `t_log_opeartion`
--
CREATE TABLE `t_log_opeartion` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `op_type` varchar(45) DEFAULT NULL COMMENT '操作类型',
  `op_name` varchar(255) DEFAULT NULL COMMENT '操作名称',
  `op_objid` int(11) DEFAULT NULL COMMENT '操作对象编号',
  `op_desc` varchar(45) DEFAULT NULL COMMENT '操作描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志信息';


--
-- Table structure for table `t_year_plan`
--
CREATE TABLE `t_year_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '年度计划编号',
  `year` varchar(45) DEFAULT NULL COMMENT '年份',
  `group_id` int(11) DEFAULT NULL COMMENT '管理机构编号',
  `year_total` int(11) DEFAULT NULL COMMENT '年计划总数',
  `important_total` int(11) DEFAULT NULL COMMENT '重点企业数量',
  `normal_total` int(11) DEFAULT NULL COMMENT '一般企业数量',
  `member_num` int(11) DEFAULT NULL COMMENT '人数',
  `check_percent` float DEFAULT NULL COMMENT '抽查比例',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='年度执法计划';