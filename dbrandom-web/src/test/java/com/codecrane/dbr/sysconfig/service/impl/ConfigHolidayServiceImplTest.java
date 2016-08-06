package com.codecrane.dbr.sysconfig.service.impl;

import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;
import com.codecrane.dbr.sysconfig.service.ConfigHolidayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
 * ConfigHolidayServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>五月 28, 2016</pre>
 */

//@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(name = "parent", locations = {"classpath*:spring/app-config.xml", "classpath*:spring/shiro-config.xml", "classpath*:spring/mvc-config.xml"})
public class ConfigHolidayServiceImplTest {

    private List<Date> workDays = new ArrayList<>();

    @Autowired
    private ConfigHolidayService configHolidayService;

    @Before
    public void before() throws Exception {

        Date startDate = DateUtils.parseDate("2016-01-01", "yyyy-MM-dd");
        Date endDate = DateUtils.parseDate("2016-12-31", "yyyy-MM-dd");

        Date currentDate = startDate;
        workDays.add(currentDate);
        while (!DateUtils.isSameDay(currentDate, endDate)) {
            currentDate = DateUtils.addDays(currentDate, 1);
            workDays.add(currentDate);
        }
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: save(ConfigHoliday configHoliday)
     */
    @Test
    public void testSave() throws Exception {

        for (Date cDate : workDays) {
            ConfigHoliday param = new ConfigHoliday();
            param.setHolidayDate(cDate);
            List<ConfigHoliday> queryHoliday = configHolidayService.findByCnd(param);
            if( null == queryHoliday || queryHoliday.size() < 1 ){
                ConfigHoliday workDay = new ConfigHoliday();
                workDay.setHolidayDate(cDate);
                workDay.setStatus(0);
                workDay.setHolidayName("工作日");
                //log.debug("current Date:{}", DateFormatUtils.format(cDate, "yyyy-MM-dd"));
                configHolidayService.save(workDay);
            }
        }
    }

    /**
     * Method: saveBatch(List<ConfigHoliday> configHolidays)
     */
    @Test
    public void testSaveBatch() throws Exception {
//TODO: Test goes here...
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date date = df.parse("2016-1-1");
        int day = date.getDay();
        int startSatOffset = 6-day;
        if(day==0){
            System.out.println("此年的第一天是星期天");
        }
        List<ConfigHoliday> configHolidays=new ArrayList<ConfigHoliday>();

        for(int i=0;i<=365/7;i++){
            ConfigHoliday configHoliday=new ConfigHoliday();
            Date satday = df.parse("2016-1-"+(1+startSatOffset+i*7));
            configHoliday.setHolidayDate(satday);
            configHoliday.setStatus(1);
            configHoliday.setHolidayName("休息日");
            configHolidays.add(configHoliday);
            Date sunday = df.parse("2016-1-"+(1+startSatOffset+(i*7+1)));
            ConfigHoliday configHoliday1=new ConfigHoliday();
            configHoliday1.setHolidayDate(sunday);
            configHoliday1.setStatus(1);
            configHoliday1.setHolidayName("休息日");
            configHolidays.add(configHoliday1);
            //System.out.println("第"+(i+1)+"个星期末是:"+df.format(satday)+"和"+df.format(sunday));
        }
        configHolidayService.saveBatch(configHolidays);
    }

    /**
     * Method: modify(ConfigHoliday configHoliday)
     */
    @Test
    public void testModify() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(Integer configHolidayId)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByIds(Integer[] configHolidayIds)
     */
    @Test
    public void testDeleteByIds() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findById(Integer configHolidayId)
     */
    @Test
    public void testFindById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findAllConfigHoliday()
     */
    @Test
    public void testFindAllConfigHoliday() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByCnd(ConfigHoliday configHoliday)
     */
    @Test
    public void testFindByCnd() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: findByDateRangeWithStatus(ConfigHoliday configHoliday)
     */
    @Test
    public void testFindByDateRangeWithStatus() throws Exception {
//TODO: Test goes here... 
    }


} 
