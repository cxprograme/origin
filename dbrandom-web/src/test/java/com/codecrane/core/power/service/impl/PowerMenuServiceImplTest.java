package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerMenu;
import com.codecrane.core.power.service.PowerMenuService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * PowerMenuServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 11, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class PowerMenuServiceImplTest {

    @Autowired
    private PowerMenuService powerMenuService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: saveWithPermission(PowerMenu powerMenu)
     */
    @Test
    public void testSaveWithPermission() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: save(PowerMenu powerMenu)
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: saveBatch(List<PowerMenu> powerMenus)
     */
    @Test
    public void testSaveBatch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: modify(PowerMenu powerMenu)
     */
    @Test
    public void testModify() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: modifyWithPermission(PowerMenu powerMenu)
     */
    @Test
    public void testModifyWithPermission() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(long powerMenuId)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByIds(long[] powerMenuIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findById(long powerMenuId)
     */
    @Test
    public void testFindById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllPowerMenu()
     */
    @Test
    public void testFindAllPowerMenu() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByMenuPid(long menuPid)
     */
    @Test
    public void testFindByMenuPid() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByUserId(long userId)
     */
    @Test
    public void testFindByUserId() throws Exception {
        List<PowerMenu> menus = powerMenuService.findByUserId(2);
    }


} 
