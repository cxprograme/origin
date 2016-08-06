package com.codecrane.dbr.extract.service.impl;

import com.alibaba.fastjson.JSON;
import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ExecutorRandomServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 19, 2016</pre>
 */
@Slf4j
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class ExecutorRandomServiceImplTest {

    @Autowired
    private ExecutorRandomService executorRandomService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(ExecutorRandom executorRandom)
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: saveBatch(List<ExecutorRandom> executorRandoms)
     */
    @Test
    public void testSaveBatch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: modify(ExecutorRandom executorRandom)
     */
    @Test
    public void testModify() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(Integer executorRandomId)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByIds(Integer[] executorRandomIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByBatchNo(String batchNo)
     */
    @Test
    public void testDeleteByBatchNo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findById(Integer executorRandomId)
     */
    @Test
    public void testFindById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllExecutorRandom()
     */
    @Test
    public void testFindAllExecutorRandom() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByCnd(ExecutorRandom executorRandom)
     */
    @Test
    public void testFindByCnd() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByCndWithGrouped(ExecutorRandom executorRandom)
     */
    @Test
    public void testFindByCndWithGrouped() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByCndAndGroupedWithFeedback(ExecutorRandom executorRandom)
     */
    @Test
    public void testFindByCndAndGroupedWithFeedback() throws Exception {

        ExecutorRandom random = new ExecutorRandom();
        random.setGroupId(20);
        List<ExecutorRandom> executorRandoms = executorRandomService.findByCndAndGroupedWithFeedback(random);

        Assert.assertNotNull(executorRandoms);
        log.debug(JSON.toJSONString(executorRandoms));
    }

    @Test
    public void testFindByExecutor(){
        ExecutorRandom random = executorRandomService.findByExecutor("13888884706","510491217551351808");
        Assert.assertNotNull(random);
    }

    /**
     * Method: findByGrouped(Integer groupId)
     */
    @Test
    public void testFindByGrouped() throws Exception {
//TODO: Test goes here... 
    }


} 
