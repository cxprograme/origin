package com.codecrane.dbr.manageobj.service.impl;

import com.codecrane.dbr.manageobj.entity.CompanyPoint;
import com.codecrane.dbr.manageobj.service.CompanyPointService;
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

/**
 * CompanyPointServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 24, 2016</pre>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class CompanyPointServiceImplTest {

    @Autowired
    private CompanyPointService companyPointService;

    private CompanyPoint point;

    @Before
    public void before() throws Exception {
        point = new CompanyPoint();
        point.setGroupId(2);
        point.setCompanyId(3);
        point.setOrderId(1);
        point.setPointName("下级节点名称");
        point.setPointDesc("下级节点描述");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(CompanyPoint companyPoint)
     */
    @Test
    public void testSave() throws Exception {

        int insertRows = companyPointService.save(point);
        Assert.assertEquals(insertRows,1);
    }

    /**
     * Method: saveBatch(List<CompanyPoint> companyPoints)
     */
    @Test
    public void testSaveBatch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: modify(CompanyPoint companyPoint)
     */
    @Test
    public void testModify() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(Integer companyPointId)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByIds(Integer[] companyPointIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findById(Integer companyPointId)
     */
    @Test
    public void testFindById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllCompanyPoint()
     */
    @Test
    public void testFindAllCompanyPoint() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByCnd(CompanyPoint companyPoint)
     */
    @Test
    public void testFindByCnd() throws Exception {
//TODO: Test goes here... 
    }


} 
