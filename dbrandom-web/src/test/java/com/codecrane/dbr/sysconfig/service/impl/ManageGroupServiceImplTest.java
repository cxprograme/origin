package com.codecrane.dbr.sysconfig.service.impl;

import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
* ManageGroupServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 4, 2016</pre> 
* @version 1.0 
*/

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class ManageGroupServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: save(ManageGroup manageGroup) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here...

}

/**
*
* Method: saveBatch(List<ManageGroup> manageGroups)
*
*/
@Test
public void testSaveBatch() throws Exception {
//TODO: Test goes here...

}

/** 
* 
* Method: modify(ManageGroup manageGroup) 
* 
*/ 
@Test
public void testModify() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(Integer manageGroupId) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteByIds(Integer[] manageGroupIds) 
* 
*/ 
@Test
public void testDeleteByIds() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findById(Integer manageGroupId) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAllManageGroup() 
* 
*/ 
@Test
public void testFindAllManageGroup() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByCnd(ManageGroup manageGroup) 
* 
*/ 
@Test
public void testFindByCnd() throws Exception { 
//TODO: Test goes here... 
} 


} 
