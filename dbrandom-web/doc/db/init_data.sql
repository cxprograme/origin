-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
-- Server version	5.7.12

INSERT INTO `power_group` VALUES (15,0,'南宁市环境监察总队','',0,'2016-05-29 13:21:37',NULL,4,1,''),
(16,15,'江南区环境监察大队','',0,'2016-05-29 13:22:41',NULL,1,2,'15_'),
(17,16,'江南区一中队','',0,'2016-05-29 13:23:05',NULL,1,3,'15_16_'),
(18,15,'西乡塘区环境监察大队','',0,'2016-05-30 19:12:18',NULL,2,2,'15_'),
(19,15,'青秀区环境监察大队','',0,'2016-05-30 21:23:20',NULL,1,2,'15_'),
(20,15,'兴宁区环境监察大队','',0,'2016-05-30 21:23:45',NULL,1,2,'15_'),
(21,16,'江南区二中队','',0,'2016-05-30 21:54:20',NULL,2,3,'15_16_'),
(22,16,'江南区三中队','',0,'2016-05-30 21:54:31',NULL,3,3,'15_16_'),
(23,16,'江南区四中队','',0,'2016-05-30 21:54:44',NULL,4,3,'15_16_'),
(24,19,'青秀区一中队','',0,'2016-05-30 21:56:49',NULL,1,3,'15_19_'),
(25,19,'青秀区二中队','',0,'2016-05-30 21:57:05',NULL,2,3,'15_19_'),
(26,19,'青秀区三中队','',0,'2016-05-30 21:57:15',NULL,0,3,'15_19_'),
(27,20,'兴宁区一中队','',0,'2016-05-30 21:57:30',NULL,1,3,'15_20_'),
(28,20,'兴宁区二中队','',0,'2016-05-30 21:57:37',NULL,2,3,'15_20_'),
(29,20,'兴宁区三中队','',0,'2016-05-30 21:57:46',NULL,3,3,'15_20_'),
(30,20,'兴宁区四中队','',0,'2016-05-30 21:57:55',NULL,4,3,'15_20_'),
(31,20,'兴宁区五中队','',0,'2016-05-30 21:58:05',NULL,5,3,'15_20_'),
(32,18,'西乡塘区一中队','',0,'2016-05-30 21:58:28',NULL,1,3,'15_18_'),
(33,18,'西乡塘区二中队','',0,'2016-05-30 21:58:38',NULL,2,3,'15_18_'),
(34,15,'总队科室一','',0,'2016-05-30 21:59:18',NULL,2,4,'15_'),
(35,15,'总队科室二','',0,'2016-05-30 21:59:27',NULL,2,4,'15_'),
(36,15,'总队科室三','',0,'2016-05-30 21:59:36',NULL,3,4,'15_'),
(37,15,'总队科室五','',0,'2016-05-30 21:59:46',NULL,5,4,'15_'),
(38,15,'总队科室四','',0,'2016-05-30 22:00:16',NULL,4,4,'15_');

INSERT INTO `power_menu` VALUES (15,0,'系统管理','admin','/admin','fa-cogs',6),
(16,15,'管理机构','group','/power/group/main.html','fa-users',1),
(17,15,'用户','user','/power/user/main.html','fa-user',2),
(18,15,'角色','role','/power/role/main.html','fa-odnoklassniki',3),
(19,15,'权限','permission','/power/permission/main.html','fa-lock',4),
(21,19,'通用','premission','/power/permission/main.html?type=0','fa-bars',1),
(22,19,'菜单','menu','/power/menu/main.html?type=1','fa-list-ul',2),
(37,15,'任务计划','powerschedule','/power/schedule/main','fa-clock-o',5),
(40,0,'执法信息库','executedb','/execute','fa-database',1),
(41,0,'抽取规则设置','configrule','/config/rule/main','fa-filter',2),
(42,0,'年度执法计划','yearplan','/yearplan/info/main','fa-bars',3),
(43,0,'执法任务管理','taskmanage','/taskmanage','fa-calendar',4),
(44,0,'系统配置','appconfig','/appconfig','fa-cog',5),
(45,40,'管理对象','compnay','/company/info/main','fa-building',1),
(46,40,'执法人员','executor','/lawexecutor/info/main','fa-users',2),
(47,43,'排班表','execute-plan','/scheduletable/main','fa-calendar-check-o',1),
(48,43,'执法反馈','feekback','/execute/feedback/main','fa-pencil-square-o',2),
(49,43,'后督察管理','execute-detail','/execute/detail/main','fa-bell-o',3),
(51,44,'工作日设置','holiday','/holiday/config','fa-calendar-plus-o',2),
(52,15,'系统监控','sysmonitor','/druid/','fa-area-chart',6),
(53,15,'数据字典','dictionary','/dictionary','fa-th-list',7),
(54,53,'字典分类','dicttype','/dict/info/main','fa-list-ol',1),
(55,53,'字典详情','dictdetail','/dictdetail/info/main','fa-list',2),
(56,0,'企业随机抽取','companyrandom','/extract/company/main','fa-random',7),
(57,0,'人员随机抽取','executorrandom','/extract/executor/main','fa-users',8);

INSERT INTO `power_permission` VALUES (13,15,'系统管理',1,'admin:manager',0,'2016-03-11 11:31:59','2016-05-23 15:30:44',6),
(14,16,'管理机构',1,'group:manager',0,'2016-03-11 11:36:00','2016-05-28 12:00:43',1),
(15,17,'用户',1,'user:manager',0,'2016-03-11 11:36:39',NULL,2),
(16,18,'角色',1,'role:manager',0,'2016-03-11 11:38:20',NULL,3),
(17,19,'权限',1,'permission:manager',0,'2016-03-11 11:40:03',NULL,4),
(19,21,'通用',1,'permission:normal',0,'2016-03-11 15:00:35',NULL,1),
(20,22,'菜单',1,'menu:manage',0,'2016-03-11 15:01:18',NULL,2),
(35,37,'任务计划',1,'powerschedule:manage',0,'2016-05-13 09:38:24',NULL,5),
(38,40,'执法信息库',1,'executedb:manage',0,'2016-05-23 15:19:21',NULL,1),
(39,41,'抽取规则设置',1,'configrule:manage',0,'2016-05-23 15:20:48','2016-06-01 11:29:08',2),
(40,42,'年度执法计划',1,'yearplan:manage',0,'2016-05-23 15:29:43','2016-05-26 11:43:14',3),
(41,43,'执法任务管理',1,'taskmanage:manage',0,'2016-05-23 15:30:28','2016-05-23 15:31:21',4),
(42,44,'系统配置',1,'appconfig:manage',0,'2016-05-23 15:32:02',NULL,5),
(43,45,'管理对象',1,'company:manage',0,'2016-05-23 15:33:56','2016-05-25 22:32:43',1),
(44,46,'执法人员',1,'executor:manage',0,'2016-05-23 15:34:45','2016-05-30 16:21:06',2),
(45,47,'排班表',1,'execute-plan:manage',0,'2016-05-23 15:36:58','2016-06-03 11:02:26',1),
(46,48,'执法反馈',1,'feekback:manage',0,'2016-05-23 15:37:36','2016-06-03 11:47:12',2),
(47,49,'后督察管理',1,'execute-detail:manage',0,'2016-05-23 15:39:04','2016-06-03 11:44:54',3),
(48,50,'管理机构',1,'manage-group:manage',0,'2016-05-23 15:39:47','2016-05-26 16:24:32',1),
(49,51,'工作日设置',1,'holiday:manage',0,'2016-05-23 15:40:40',NULL,2),
(50,52,'系统监控',1,'sysmonitor:manage',0,'2016-05-25 22:02:49',NULL,6),
(51,53,'数据字典',1,'dictionary:manage',0,'2016-05-27 17:05:28',NULL,7),
(52,54,'字典分类',1,'dicttype:manage',0,'2016-05-27 17:06:30','2016-05-27 17:08:13',1),
(53,55,'字典详情',1,'dictdetail:manage',0,'2016-05-27 17:07:22','2016-05-27 18:21:25',2),
(54,56,'企业随机抽取',1,'companyrandom:manage',0,'2016-05-30 18:43:33','2016-06-02 21:45:45',7),
(55,57,'人员随机抽取',1,'executorrandom:manage',0,'2016-05-30 18:44:32','2016-06-02 21:46:12',8),

INSERT INTO `power_role` VALUES (1,'系统管理员','系统管理员角色',0,1,'2016-03-08 12:03:32','2016-05-13 09:40:37'),
(3,'普通管理员','普通管理员',0,1,'2016-05-29 20:24:30',NULL);

INSERT INTO `power_schedule` VALUES (1,'testjob','test','0 5 1 * * ? ','com.codecrane.core.schedule.QuartzJobFactory','start','测试任务','2016-05-13 09:41:36','2016-05-23 14:58:26');

INSERT INTO `power_user` VALUES (2,'admin','6BIUKxQYFiCYVU6HX51tiA==','c2bbbe24f9b1b14384b5f1b027dbd41d','系统管理员','系统管理员',2,18,'2016-03-08','13888888888','test@mail.com',0,0,1,NULL,NULL,NULL,'2016-03-08 10:43:37','2016-05-26 17:47:16'),
(9,'test-zd','XvnaD7ewxsayYaPngrbymw==','c40d64030c49b13572e88f4b7e14b4f0','总队测试账户','总队',2,30,'1983-06-07','13888888888','admin@admin.com',0,0,1,NULL,NULL,NULL,'2016-05-29 20:22:16','2016-06-01 01:18:24'),
(10,'test－dd','oi9/4yN7xKgcmrcHeEHbcw==','8414b3eae8bbc8603f8b9ab29a09889c','大队测试用户','大队测试用户',2,30,'2016-05-18','13888888888','admin@admin.com',0,0,1,NULL,NULL,0,'2016-05-30 18:52:49',NULL),
(11,'jiangnan','3A1Q6Uwg3KMA5aJC1EdGzw==','5295f958ccd6b5312cc56b10828b565f','江南区大队','jiangnan',1,12,'2016-05-18','13888888888','admin@admin.com',0,0,1,NULL,NULL,NULL,'2016-05-30 19:00:21','2016-05-31 10:42:25'),
(12,'xixiangtang','cppvI/WhqdHJ8mDpH+qJyw==','e72fc7985dce76e211a465ef839471dc','西乡塘区大队','西乡塘区大队',1,12,'2016-05-18','13888888888','admin@admin.com',0,0,1,NULL,NULL,NULL,'2016-05-30 19:12:58','2016-05-31 10:56:36'),
(13,'adminz','tKRJLYHxmzo6bd26YBqAag==','d8f15ae84bca229084f6f0fd56b47918','系统管理员','系统管理员',1,30,'2016-05-18','13888888888','admin@admin.com',0,0,1,NULL,NULL,0,'2016-05-30 21:51:13',NULL),
(14,'qingxiu','LL3ZBHeotxliO4C0xal32A==','da9921813d1c5fa108ca95531624c140','青秀区大队','青秀区大队',1,NULL,NULL,'13888888888','admin@admin.com',0,0,1,NULL,NULL,0,'2016-05-31 10:55:17',NULL),
(15,'xingning','aPr835vbv+cEvCjJTkKqsg==','56d6ab1fc838a926d1914faef354a69d','兴宁区大队','兴宁区大队',1,NULL,NULL,'13888888888','admin@admin.com',0,0,1,NULL,NULL,0,'2016-05-31 10:55:55',NULL);

INSERT INTO `rel_group_user` VALUES (15,9),
(16,10),
(16,11),
(18,12),
(19,14),
(20,15);

INSERT INTO `rel_role_permission` VALUES (1,13),
(1,14),
(1,15),
(1,16),
(1,17),
(1,19),
(1,20),
(1,35),
(1,50),
(1,51),
(1,52),
(1,53),
(3,38),
(3,39),
(3,40),
(3,41),
(3,42),
(3,43),
(3,44),
(3,45),
(3,46),
(3,47),
(3,49),
(3,54),
(3,55);

INSERT INTO `rel_user_role` VALUES (2,1),
(8,6),
(9,3),
(11,3),
(12,3),
(13,1),
(14,3),
(15,3);

INSERT INTO `t_dict` VALUES (50,'test1','测试分类1','分类说明1','2016-05-27 17:17:40','2016-05-27 17:31:23',1),
(93,'1001','分类属性','管理对象分类属性','2016-05-27 17:31:51',NULL,0),
(95,'1002','职务','执法人员职务','2016-05-30 16:54:03',NULL,0),
(96,'group_type','组织机构分类','组织机构分类','2016-06-07 11:34:17',NULL,0);

INSERT INTO `t_dict_detail` VALUES (49,93,'批发和零售业','10001','1','trade','1','1','1','2016-05-27 18:29:02','2016-05-27 22:23:58',0),
(50,93,'制造业','10002','2','trade','1','1','1','2016-05-27 22:14:20','2016-05-27 22:23:36',0),
(51,93,'建筑业','10003','3','trade','1','1','1','2016-05-27 22:14:55',NULL,0),
(52,93,'住宿、餐饮业','10004','4','trade','1','1','1','2016-05-27 22:20:24',NULL,0),
(53,95,'科长','10001','1','keshi','1','1','1','2016-05-30 16:54:42',NULL,0),
(54,95,'副科长','10002','2','keshi','1','1','1','2016-05-30 16:55:04',NULL,0),
(55,95,'科员','10003','3','keshi','1','1','1','2016-05-30 16:55:23',NULL,0),
(57,96,'总队','1','1','1','1','1','1','2016-06-07 11:34:50',NULL,0),
(58,96,'大队','2','2','1','1','1','1','2016-06-07 11:35:06',NULL,0),
(59,96,'中队','3','3','1','1','1','1','2016-06-07 11:35:29',NULL,0),
(60,96,'科室','4','4','1','1','1','1','2016-06-07 11:35:42',NULL,0);


INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-01',1,sysdate(),NULL,'元旦');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-02',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-03',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-09',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-10',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-16',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-17',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-23',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-24',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-30',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-01-31',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-02',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-03',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-07',1,sysdate(),NULL,'除夕');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-08',1,sysdate(),NULL,'春节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-09',1,sysdate(),NULL,'春节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-10',1,sysdate(),NULL,'春节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-11',1,sysdate(),NULL,'春节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-12',1,sysdate(),NULL,'春节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-13',1,sysdate(),NULL,'春节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-20',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-21',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-27',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-28',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-02-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-02',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-03',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-05',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-06',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-10',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-12',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-13',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-19',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-20',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-26',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-27',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-03-31',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-02',1,sysdate(),NULL,'清明节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-03',1,sysdate(),NULL,'清明节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-04',1,sysdate(),NULL,'清明节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-09',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-10',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-16',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-17',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-23',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-24',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-04-30',1,sysdate(),NULL,'劳动节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-01',1,sysdate(),NULL,'劳动节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-02',1,sysdate(),NULL,'劳动节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-03',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-07',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-08',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-10',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-14',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-15',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-21',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-22',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-28',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-29',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-05-31',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-02',1,sysdate(),NULL,'休息日啊');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-03',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-04',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-05',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-09',1,sysdate(),NULL,'端午节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-10',1,sysdate(),NULL,'端午节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-11',1,sysdate(),NULL,'端午节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-18',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-19',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-25',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-26',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-06-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-02',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-03',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-09',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-10',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-16',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-17',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-23',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-24',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-30',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-07-31',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-02',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-03',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-06',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-07',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-10',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-13',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-14',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-20',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-21',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-27',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-28',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-08-31',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-02',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-03',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-04',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-10',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-11',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-15',1,sysdate(),NULL,'中秋节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-16',1,sysdate(),NULL,'中秋节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-17',1,sysdate(),NULL,'中秋节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-24',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-25',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-09-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-01',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-02',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-03',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-04',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-05',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-06',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-07',1,sysdate(),NULL,'国庆节');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-10',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-15',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-16',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-22',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-23',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-29',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-30',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-10-31',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-02',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-03',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-04',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-05',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-06',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-10',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-11',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-12',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-13',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-17',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-18',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-19',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-20',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-24',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-25',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-26',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-27',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-11-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-01',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-02',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-03',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-04',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-05',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-06',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-07',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-08',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-09',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-10',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-11',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-12',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-13',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-14',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-15',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-16',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-17',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-18',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-19',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-20',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-21',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-22',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-23',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-24',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-25',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-26',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-27',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-28',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-29',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-30',0,sysdate(),NULL,'工作日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2016-12-31',1,sysdate(),NULL,'休息日');
INSERT INTO `t_config_holiday` (`holiday_date`,`status`,`create_date`,`modify_date`,`holiday_name`) VALUES ('2017-01-01',1,sysdate(),NULL,'元旦');