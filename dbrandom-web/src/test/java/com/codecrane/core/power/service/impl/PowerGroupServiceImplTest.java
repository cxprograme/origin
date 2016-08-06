package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.service.PowerGroupService;
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
 * PowerGroupServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 27, 2016</pre>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class PowerGroupServiceImplTest {

    @Autowired
    private PowerGroupService powerGroupService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(PowerGroup powerGroup)
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: saveBatch(List<PowerGroup> powerGroups)
     */
    @Test
    public void testSaveBatch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: modify(PowerGroup powerGroup)
     */
    @Test
    public void testModify() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(long powerGroupId)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByIds(long[] powerGroupIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findById(long powerGroupId)
     */
    @Test
    public void testFindById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllPowerGroup()
     */
    @Test
    public void testFindAllPowerGroup() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByPid(long id)
     */
    @Test
    public void testFindByPid() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllChildGroup(PowerGroup powerGroup)
     */
    @Test
    public void testFindAllChildGroup() throws Exception {

        PowerGroup queryGroup = new PowerGroup();
        queryGroup.setId(20L);
        List<PowerGroup> groupList = powerGroupService.findAllChildGroup(queryGroup);
        Assert.assertNotNull(groupList);
        Assert.assertTrue(groupList.size() > 0);

    }

    /**
     * Method: findAllParentGroup(PowerGroup powerGroup)
     */
    @Test
    public void testFindAllParentGroup() throws Exception {
//TODO: Test goes here... 
    }


} 
