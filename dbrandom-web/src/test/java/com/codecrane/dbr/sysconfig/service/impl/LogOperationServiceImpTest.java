package com.codecrane.dbr.sysconfig.service.impl;

import com.codecrane.dbr.sysconfig.entity.LogOperation;
import com.codecrane.dbr.sysconfig.mapper.LogOperationMapper;
import com.codecrane.dbr.sysconfig.service.LogOperationService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;

/** 
* LogOperationServiceImp Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 15, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class LogOperationServiceImpTest {

    @Autowired
    private LogOperationMapper logOperationMapper;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findAll()
*
*/
@Test
public void testFindAll() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: queryCnd(LogOperation logOperation)
* 
*/
@Test
public void testQueryCnd() throws Exception {
    LogOperation logOperation=new LogOperation();
    logOperation.setOpName("增");
    List<LogOperation> logOperations=logOperationMapper.queryByCnd(logOperation);
    System.err.println("logOperation:"+logOperations);
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(LogOperation logOperation) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here...

    LogOperation logOperation=new LogOperation();
   // logOperation.setOpType("增加");
    logOperation.setOpType(LogOperation.LogName.UPDATE.getKey());
    logOperation.setOpName("删除枚举测试");
    logOperation.setOpObjId(12);
    logOperation.setOpDesc("测试枚举枚举");
    logOperation.setCreateDate(new Date());
    logOperation.setCreateMan("陈旭");
    logOperationMapper.insert(logOperation);

} 


} 
