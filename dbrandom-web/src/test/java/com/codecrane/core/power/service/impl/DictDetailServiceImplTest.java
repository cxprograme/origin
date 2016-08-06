package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.DictDetail;
import com.codecrane.core.power.service.DictDetailService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * DictDetailServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 27, 2016</pre>
 */

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class DictDetailServiceImplTest {

    @Autowired
    private DictDetailService dictDetailService;

    private DictDetail dictDetail;

    @Before
    public void before() throws Exception {

        dictDetail = new DictDetail();
        dictDetail.setDictType(2);
        dictDetail.setDetailContent("字典项内容");
        dictDetail.setDetailName("字典项名称");
        dictDetail.setDetailSort("1");
        dictDetail.setDetailCode("字典项编码");
        dictDetail.setDetailRemark("字典项备注");
        dictDetail.setDetailState("字典项状态");
        dictDetail.setDetailType("字典项类型名称");

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(DictDetail dictDetail)
     */
    @Test
    public void testSave() throws Exception {
        int insertRows = dictDetailService.save(dictDetail);
        Assert.assertTrue(insertRows == 1);
    }

    /**
     * Method: saveBatch(List<DictDetail> dictDetails)
     */
    @Test
    public void testSaveBatch() throws Exception {

        List<DictDetail> dictDetails = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DictDetail tempDictDetail = new DictDetail();
            tempDictDetail.setDictType(2);
            tempDictDetail.setDetailContent("字典项内容" + i);
            tempDictDetail.setDetailName("字典项名称" + i);
            tempDictDetail.setDetailSort(String.valueOf(i));
            tempDictDetail.setDetailCode("字典项编码" + i);
            tempDictDetail.setDetailRemark("字典项备注" + i);
            tempDictDetail.setDetailState("字典项状态" + i);
            tempDictDetail.setDetailType("字典项类型名称" + i);

            dictDetails.add(tempDictDetail);
        }

        int insertRows = dictDetailService.saveBatch(dictDetails);
        Assert.assertTrue(insertRows == dictDetails.size());
    }

    /**
     * Method: modify(DictDetail dictDetail)
     */
    @Test
    public void testModify() throws Exception {

        dictDetailService.save(dictDetail);

        dictDetail.setDetailContent("字典项内容[modify]");
        dictDetail.setDetailName("字典项名称[modify]");
        dictDetail.setDetailSort("0");
        dictDetail.setDetailCode("字典项编码[modify]");
        dictDetail.setDetailRemark("字典项备注[modify]");
        dictDetail.setDetailState("字典项状态[modify]");
        dictDetail.setDetailType("字典项类型名称[modify]");

        int updateRows = dictDetailService.modify(dictDetail);
        Assert.assertTrue(updateRows == 1);
    }

    /**
     * Method: delete(Integer dictDetailId)
     */
    @Test
    public void testDelete() throws Exception {
        dictDetailService.save(dictDetail);
        int deleteRows = dictDetailService.delete(dictDetail.getId());
        Assert.assertTrue(deleteRows == 1);
    }

    /**
     * Method: deleteByIds(Integer[] dictDetailIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
        int detailid1 = 0, detailid2 = 0, detailid3 = 0;

        dictDetailService.save(dictDetail);
        detailid1 = dictDetail.getId();

        dictDetailService.save(dictDetail);
        detailid2 = dictDetail.getId();

        dictDetailService.save(dictDetail);
        detailid3 = dictDetail.getId();

        Integer[] delids = {detailid1, detailid2, detailid3};

        int deleteDetailRows = dictDetailService.deleteByIds(delids);
        Assert.assertTrue(deleteDetailRows == 3);
    }

    /**
     * Method: findById(Integer dictDetailId)
     */
    @Test
    public void testFindById() throws Exception {
        dictDetailService.save(dictDetail);

        DictDetail queryDictDetail = dictDetailService.findById(dictDetail.getId());
        Assert.assertNotNull(queryDictDetail);
    }

    /**
     * Method: findAllDictDetail()
     */
    @Test
    public void testFindAllDictDetail() throws Exception {
        dictDetailService.save(dictDetail);
        dictDetailService.save(dictDetail);
        dictDetailService.save(dictDetail);

        List<DictDetail> dictList = dictDetailService.findAllDictDetail();
        Assert.assertNotNull(dictList);
        Assert.assertTrue(dictList.size() == 3);

    }

    /**
     * Method: findByCnd(DictDetail dictDetail)
     */
    @Test
    public void testFindByCnd() throws Exception {

        dictDetailService.save(dictDetail);

        DictDetail queryDetail = new DictDetail();
        queryDetail.setDetailCode("字典项编码");

        List<DictDetail> dictList = dictDetailService.findByCnd(queryDetail);
        Assert.assertNotNull(dictList);
        Assert.assertTrue(dictList.size() == 1);
    }


} 
