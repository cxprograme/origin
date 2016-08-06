package com.codecrane.dbr.manageobj.controller;

import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.service.PowerGroupService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * LawExecutorController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 9, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class LawExecutorControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private PowerGroupService powerGroupService;

    private MockMvc mockMvc;

    private List<String> names = new ArrayList<>();

    private List<String> mobiles = new ArrayList<>();

    private List<PowerGroup> groups = new ArrayList<>();

    private List<PowerGroup> childGroups = new ArrayList<>();

    private Integer[] wordloadArr = {0, 50, 100};

    private String[] dutyCode = {"10001", "10002", "10003"};

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();

        List<PowerGroup> powerGroups = powerGroupService.findAllPowerGroup();
        for (PowerGroup group : powerGroups) {
            if (group.getGroupType() < 3) {
                groups.add(group);

                //获取直接下级
                List<PowerGroup> tempGroup = powerGroupService.findByPid(group.getId());
                if (null != tempGroup) {
                    childGroups.add(tempGroup.get(RandomUtils.nextInt(0, tempGroup.size())));
                }
            }
        }

        String[] nameTag = {"张三", "李四", "王五", "马六", "张莫某", "李某某", "王陌陌", "马某某"};
        for (int i = 1; i < 1000; i++) {
            names.add(nameTag[RandomUtils.nextInt(0, 7)] + i);
        }

        for (int i = 1000; i < 9999; i++) {
            mobiles.add("1388888" + i);
        }

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: lawExecutorListPage(Model model)
     */
    @Test
    public void testLawExecutorListPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addLawExecutorPage(@RequestParam(value = "gid", defaultValue = "0") Long groupId, Model model)
     */
    @Test
    public void testAddLawExecutorPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: editLawExecutorPage(@RequestParam("id") Integer id, @RequestParam(value = "gid", defaultValue = "0") Long groupId, Model model)
     */
    @Test
    public void testEditLawExecutorPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllLawExecutor(@RequestParam(value = "limit", defaultValue = "10") int pagesize, @RequestParam(value = "offset", defaultValue = "0") int start, LawExecutor executor)
     */
    @Test
    public void testFindAllLawExecutor() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: save(LawExecutor lawExecutor)
     */
    @Test
    public void testSave() throws Exception {
        for (int i = 0; i < 300; i++) {

            String name = names.get(RandomUtils.nextInt(0, names.size()));
            String mobile = mobiles.get(RandomUtils.nextInt(0, mobiles.size()));
            int randomIdx = RandomUtils.nextInt(0, groups.size());
            PowerGroup group = groups.get(randomIdx);
            PowerGroup department = childGroups.get(randomIdx);

            mockMvc.perform((post("/lawexecutor/info/save.do")
                    .param("name", name)
                    .param("mobile", mobile)
                    .param("aptitudes", String.valueOf(RandomUtils.nextInt(1, 3)))
                    .param("workload", String.valueOf(wordloadArr[RandomUtils.nextInt(0, 3)]))
                    .param("groupId", String.valueOf(group.getId()))
                    .param("departmentId", String.valueOf(department.getId()))
                    .param("dutyId", String.valueOf(dutyCode[RandomUtils.nextInt(0, 3)]))
            )).andExpect(status().isOk()).andDo(print());


        }
    }

    /**
     * Method: updateSave(LawExecutor lawExecutor)
     */
    @Test
    public void testUpdateSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByIds(@RequestParam("ids") Integer ids[])
     */
    @Test
    public void testDeleteByIds() throws Exception {
//TODO: Test goes here... 
    }


} 
