package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.Dict;
import com.codecrane.core.power.service.DictService;
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
 * DictServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 27, 2016</pre>
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class DictServiceImplTest {

    @Autowired
    private DictService dictService;

    private Dict dict;

    @Before
    public void before() throws Exception {

        dict = new Dict();
        dict.setName("测试字典分类");
        dict.setRemark("测试字典分类描述");
        dict.setTypeCode("100001");

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(Dict dict)
     */
    @Test
    public void testSave() throws Exception {
        int insertRows = dictService.save(dict);
        Assert.assertTrue(insertRows > 0);
    }

    /**
     * Method: saveBatch(List<Dict> dicts)
     */
    @Test
    public void testSaveBatch() throws Exception {

        List<Dict> dicts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Dict singleDict = new Dict();
            singleDict.setName(dict.getName() + i);
            singleDict.setRemark("测试字典分类描述");
            singleDict.setTypeCode("测试字典分类分组");
            dicts.add(singleDict);
        }

        int insertRows = dictService.saveBatch(dicts);
        Assert.assertTrue(insertRows > 0);
        Assert.assertTrue(insertRows == dicts.size());
    }

    /**
     * Method: modify(Dict dict)
     */
    @Test
    public void testModify() throws Exception {

        dictService.save(dict);

        dict.setName(dict.getName() + "[modify]");
        int updateRows = dictService.modify(dict);
        Assert.assertTrue(updateRows == 1);
    }

    /**
     * Method: delete(Integer dictId)
     */
    @Test
    public void testDelete() throws Exception {
        dictService.save(dict);

        int deleteRows = dictService.delete(dict.getId());
        Assert.assertTrue(deleteRows == 1);
    }

    /**
     * Method: deleteByIds(Integer[] dictIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
        int id1 = 0, id2 = 0, id3 = 0;
        dictService.save(dict);
        id1 = dict.getId();
        dictService.save(dict);
        id2 = dict.getId();
        dictService.save(dict);
        id3 = dict.getId();
        Integer[] ids = {id1, id2, id3};
        int deleteRows = dictService.deleteByIds(ids);
        Assert.assertTrue(deleteRows == 3);
    }

    /**
     * Method: findById(Integer dictId)
     */
    @Test
    public void testFindById() throws Exception {
        dictService.save(dict);
        Dict resultDict = dictService.findById(dict.getId());
        Assert.assertNotNull(resultDict);
    }

    /**
     * Method: findAllDict()
     */
    @Test
    public void testFindAllDict() throws Exception {

        dictService.save(dict);
        dictService.save(dict);
        dictService.save(dict);

        List<Dict> dicts = dictService.findAllDict();
        Assert.assertNotNull(dicts);
        Assert.assertTrue(dicts.size() > 0);
    }

    /**
     * Method: findByCnd(Dict dict)
     */
    @Test
    public void testFindByCnd() throws Exception {
        dictService.save(dict);

        Dict queryDict = new Dict();
        queryDict.setName(dict.getName());
        queryDict.setTypeCode(dict.getTypeCode());

        List<Dict> dicts = dictService.findByCnd(queryDict);
        Assert.assertNotNull(dicts);
        Assert.assertTrue(dicts.size() > 0);

    }


} 
