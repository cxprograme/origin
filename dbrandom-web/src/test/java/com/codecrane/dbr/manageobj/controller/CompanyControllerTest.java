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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * CompanyController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>六月 5, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class CompanyControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private PowerGroupService powerGroupService;

    private List<PowerGroup> groups = new ArrayList<>();

    private List<String> names = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();
    private List<String> managers = new ArrayList<>();
    private List<String> trades = new ArrayList<>();
    private List<String> phones = new ArrayList<>();


    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();

        List<PowerGroup> powerGroups = powerGroupService.findAllPowerGroup();
        for (PowerGroup group : powerGroups) {
            if (group.getGroupType() < 3) {
                groups.add(group);
            }
        }

        for (int i = 1; i < 1000; i++) {
            names.add("测试企业NO." + i);
            addresses.add("测试企业地址 Road NO." + i);
            managers.add("李四-" + i);
        }

        for (int i = 1000; i < 9999; i++) {
            phones.add("1388888" + i);
        }

        trades.add("10001");
        trades.add("10002");
        trades.add("10003");
        trades.add("10004");
        trades.add("10005");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: companyListPage(Model model)
     */
    @Test
    public void testCompanyListPage() throws Exception {
        this.mockMvc.perform(get("/company/info/addpage")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * Method: addCompanyPage(Model model)
     */
    @Test
    public void testAddCompanyPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: editCompanyPage(@RequestParam("id") Integer companyId, @RequestParam("gid") Integer groupId, Model model)
     */
    @Test
    public void testEditCompanyPage() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllCompany(@RequestParam(value = "limit", defaultValue = "10") int pagesize, @RequestParam(value = "offset", defaultValue = "0") int start, @RequestParam("gid") Integer gid)
     */
    @Test
    public void testFindAllCompany() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllByGroupId(@RequestParam(value = "limit", defaultValue = "10") int pagesize, @RequestParam(value = "offset", defaultValue = "0") int start, @RequestParam(value = "gid", defaultValue = "0") long groupId)
     */
    @Test
    public void testFindAllByGroupId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: save(Company company)
     */
    @Test
    public void testSave() throws Exception {

        for (int i = 0; i < 1000; i++) {

            String name = names.get(RandomUtils.nextInt(0, names.size()));
            String address = addresses.get(RandomUtils.nextInt(0, addresses.size()));
            String manager = managers.get(RandomUtils.nextInt(0, managers.size()));
            String phone = phones.get(RandomUtils.nextInt(0, phones.size()));
            String trade = trades.get(RandomUtils.nextInt(0, trades.size()));
            PowerGroup group = groups.get(RandomUtils.nextInt(0, groups.size()));

            mockMvc.perform((post("/company/info/save.do")
                    .param("name", name + group.getGroupName())
                    .param("address", address)
                    .param("evManager", manager)
                    .param("mobile", phone)
                    .param("type", String.valueOf(RandomUtils.nextInt(0, 2)))
                    .param("trade", trade)
                    .param("groupId", String.valueOf(group.getId()))
                    .param("phone", phone)
                    .param("companyPoints[0].orderId", "1")
                    .param("companyPoints[0].pointName", "节点1名称")
                    .param("companyPoints[0].pointDesc", "节点1说明")
                    .param("companyPoints[1].orderId", "2")
                    .param("companyPoints[1].pointName", "节点2名称")
                    .param("companyPoints[1].pointDesc", "节点2说明")
                    .param("companyPoints[2].orderId", "3")
                    .param("companyPoints[2].pointName", "节点3名称")
                    .param("companyPoints[2].pointDesc", "节点3说明")
            )).andExpect(status().isOk()).andDo(print());


        }


    }

    /**
     * Method: updateSave(Company company)
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
