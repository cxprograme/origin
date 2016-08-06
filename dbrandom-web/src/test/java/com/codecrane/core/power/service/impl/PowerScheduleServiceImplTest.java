package com.codecrane.core.power.service.impl;

import com.codecrane.core.power.entity.PowerSchedule;
import com.codecrane.core.power.service.PowerScheduleService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * PowerScheduleServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 9, 2016</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class PowerScheduleServiceImplTest {

    private PowerSchedule powerSchedule;

    private List<PowerSchedule> powerSchedules;

    @Autowired
    private PowerScheduleService powerScheduleService;

    @Before
    public void before() throws Exception {

        powerSchedule = new PowerSchedule();
        powerSchedule.setJobStatus("stop");
        powerSchedule.setJobName("test job name");
        powerSchedule.setJobCron("0 0/1 * * * ? ");
        powerSchedule.setJobGroup("test job group name");
        powerSchedule.setJobClassPath("com.codecrane.core.schedule.QuartzJobFactory");
        powerSchedule.setJobDescription("job description detail");

        powerSchedules = new ArrayList<>();
        powerSchedules.add(powerSchedule);

        powerSchedules.add(powerSchedule);

    }

    @After
    public void after() throws Exception {


    }

    /**
     * Method: save(PowerSchedule powerSchedule)
     */
    @Test
    public void testSave() throws Exception {
        int result = powerScheduleService.save(powerSchedule);
        Assert.assertTrue(result > 0);
    }

    /**
     * Method: saveBatch(List<PowerSchedule> powerSchedules)
     */
    @Test
    public void testSaveBatch() throws Exception {
        int result = powerScheduleService.saveBatch(powerSchedules);
        Assert.assertTrue(result > 0);
    }

    /**
     * Method: modify(PowerSchedule powerSchedule)
     */
    @Test
    public void testModify() throws Exception {
        PowerSchedule mpowerSchedule = new PowerSchedule();
        mpowerSchedule.setId(6l);
        mpowerSchedule.setJobStatus("stop");
        mpowerSchedule.setJobName("m test job name");
        mpowerSchedule.setJobCron("0 0/5 * * * ? ");
        mpowerSchedule.setJobGroup("m test job group name");
        mpowerSchedule.setJobClassPath("com.codecrane.core.schedule.QuartzJobFactory");
        mpowerSchedule.setJobDescription("m job description detail");

        int result = powerScheduleService.modify(mpowerSchedule);
        Assert.assertTrue(result > 0);
    }

    /**
     * Method: delete(Long powerScheduleId)
     */
    @Test
    public void testDelete() throws Exception {
        int result = powerScheduleService.delete(7l);
        Assert.assertTrue(result > 0);
    }

    /**
     * Method: deleteByIds(Long[] powerScheduleIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {

        Long[] ids = new Long[]{1l, 2l, 3l};
        int result = powerScheduleService.deleteByIds(ids);
        Assert.assertTrue(result > 0);
    }

    /**
     * Method: findById(Integer powerScheduleId)
     */
    @Test
    public void testFindById() throws Exception {

        PowerSchedule schedule = powerScheduleService.findById(6l);
        Assert.assertNotNull(schedule);
    }

    /**
     * Method: findAllPowerSchedule()
     */
    @Test
    public void testFindAllPowerSchedule() throws Exception {
        List<PowerSchedule> schedule = powerScheduleService.findAllPowerSchedule();
        Assert.assertNotNull(schedule);
        Assert.assertTrue(schedule.size() > 0);

    }


} 
