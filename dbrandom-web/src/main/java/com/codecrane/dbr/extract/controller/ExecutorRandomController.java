package com.codecrane.dbr.extract.controller;

import com.alibaba.fastjson.JSON;
import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.util.CommonUtils;
import com.codecrane.core.util.DateRangeUtils;
import com.codecrane.core.util.IdWorker;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.extract.entity.CompanyRandom;
import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.service.CompanyRandomService;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import com.codecrane.dbr.manageobj.entity.LawExecutor;
import com.codecrane.dbr.manageobj.service.LawExecutorService;
import com.codecrane.dbr.rule.entity.ConfigRuleGroup;
import com.codecrane.dbr.rule.service.ConfigRuleGroupService;
import com.codecrane.dbr.sysconfig.entity.ConfigHoliday;
import com.codecrane.dbr.sysconfig.service.ConfigHolidayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * 执法者抽取纪录信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/extract/executor")
public class ExecutorRandomController {

    @Autowired
    private ExecutorRandomService executorRandomService;

    @Autowired
    private CompanyRandomService companyRandomService;

    @Autowired
    private ConfigRuleGroupService configRuleGroupService;

    @Autowired
    private PowerGroupService powerGroupService;

    @Autowired
    private ConfigHolidayService configHolidayService;

    @Autowired
    private LawExecutorService lawExecutorService;

    /**
     * 执法者抽取纪录信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String executorRandomListPage(Model model) {

        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            Long groupId = user.getGroupId();
            model.addAttribute("groupId", groupId);
            //查询当前机构以及子机构信息
            PowerGroup group = new PowerGroup();
            group.setId(groupId);
            model.addAttribute("groups", powerGroupService.findAllChildGroup(group));

            model.addAttribute("records", executorRandomService.findByGrouped(groupId.intValue()));
        }


        return "/dbr/extract/executor/config";
    }

    /**
     * 新增执法者抽取纪录信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addExecutorRandomPage(Model model) {

        return "/executorrandom/info/add";
    }

    /**
     * 修改执法者抽取纪录信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editExecutorRandomPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询执法者抽取纪录信息
        ExecutorRandom executorRandom = executorRandomService.findById(id);

        // 将执法者抽取纪录信息返回到页面中
        model.addAttribute("executorRandom", executorRandom);

        return "/executorrandom/info/edit";
    }

    /**
     * 分页查询执法者抽取纪录信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllExecutorRandom(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                 @RequestParam(value = "offset", defaultValue = "0") int start, ExecutorRandom executorRandom) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<ExecutorRandom> executorRandoms = executorRandomService.findByCndAndGroupedWithFeedback(executorRandom);
        PageInfo<ExecutorRandom> page = new PageInfo<>(executorRandoms);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 执法者抽取纪录
     *
     * @param executorRandom
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(ExecutorRandom executorRandom, @RequestParam(value = "managegroup", defaultValue = "0") Integer groupId) throws ParseException {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");

        //TODO 可选配日期(除去节假日 & 在当前抽取开始结束时间范围内),例如 2016-01-01 ~ 2016-03-11
        //TODO 可选配执法人员

        Date extStartDate = executorRandom.getStartDate();
        Date extEndDate = executorRandom.getEndDate();

        int year = executorRandom.getYear();
        int startMonth = Integer.parseInt(DateFormatUtils.format(extStartDate, "M"));
        int endMonth = Integer.parseInt(DateFormatUtils.format(extEndDate, "M"));
        String batchNo = UUID.randomUUID().toString();

        //日期与企业匹配
        Map<String, List<CompanyRandom>> randomCompanyWithDate = new HashMap<>();

        //判断抽取时间范围是否在同一个月(整月)
        if (startMonth == endMonth) {
            log.debug("月内抽取");
            //查询指定月份待抽取企业纪录
            CompanyRandom queryCompanyRandom = new CompanyRandom();
            queryCompanyRandom.setManageGroupId(groupId);
            queryCompanyRandom.setYear(year);
            queryCompanyRandom.setMonth(startMonth);
            List<CompanyRandom> companyRandoms = companyRandomService.findByCnd(queryCompanyRandom);
            log.debug("待抽取企业总数:{}", companyRandoms.size());

            //计算当前月份工作日
            ConfigHoliday queryMonthHoliday = new ConfigHoliday();
            queryMonthHoliday.setStartDate(DateRangeUtils.getInstance(DateUtils.parseDate(year + "-" + startMonth, "yyyy-M")).getFirstDayOfMonth(0));
            queryMonthHoliday.setEndDate(DateRangeUtils.getInstance(DateUtils.parseDate(year + "-" + endMonth, "yyyy-M")).getLastDayOfMonth(0));
            queryMonthHoliday.setStatus(0);
            List<ConfigHoliday> workDays = configHolidayService.findByDateRangeWithStatus(queryMonthHoliday);
            log.debug("当月工作日数量:{}", workDays.size());

            //计算企业抽查比例
            BigDecimal extRatio = BigDecimal.valueOf(companyRandoms.size()).divide(BigDecimal.valueOf(workDays.size()), 2, BigDecimal.ROUND_HALF_EVEN);
            log.debug("当月抽查企业与工作日比例:{}", extRatio);

            //计算当前抽取时间范围内工作日
            ConfigHoliday queryExtHoliday = new ConfigHoliday();
            queryExtHoliday.setStartDate(extStartDate);
            queryExtHoliday.setEndDate(extEndDate);
            queryExtHoliday.setStatus(0);
            List<ConfigHoliday> toExtWorkDays = configHolidayService.findByDateRangeWithStatus(queryExtHoliday);
            log.debug("当月抽查时间范围内工作日数量:{}", toExtWorkDays.size());
            Collections.shuffle(toExtWorkDays);

            //计算抽取时间范围内应该抽取的企业数量
            int companySize = extRatio.multiply(BigDecimal.valueOf(toExtWorkDays.size())).intValue();
            log.debug("实际需要抽取企业数量:{}", companySize);

            //随机计算出要抽取哪些企业
            Collections.shuffle(companyRandoms);//TODO 待改为使用权重的随机算法
            //计算出随机抽取的企业
            List<CompanyRandom> toMatchCompanyRandom = CommonUtils.randomList(companyRandoms, companySize);

            //比较抽取的企业数量与日期数量
            if (toMatchCompanyRandom.size() > toExtWorkDays.size()) {
                log.debug("待抽取企业数量大于工作日:{}-{}", toMatchCompanyRandom.size(), toExtWorkDays.size());

                int times = toMatchCompanyRandom.size() / toExtWorkDays.size() + 1;//日期和企业分配比例 1 : 1 ~ times个
                int beforeTimes = times - 1;//随机选择数量,直到最后一次前一次
                int afterTimes = toMatchCompanyRandom.size() % toExtWorkDays.size();//最后一次选择数量

                log.debug("第一次分配平均数量:{}", beforeTimes);
                log.debug("最后一次分配数量:{}", afterTimes);

                //每个日期先匹配企业与日期比例个数的企业
                List<CompanyRandom> extractedCompanyRandom = new ArrayList<>();
                for (ConfigHoliday workDate : toExtWorkDays) {
                    String dateStr = DateFormatUtils.format(workDate.getHolidayDate(), "yyyy-MM-dd");
                    List<CompanyRandom> checkedCompany = CommonUtils.randomList(toMatchCompanyRandom, beforeTimes);
                    toMatchCompanyRandom.removeAll(checkedCompany);

                    randomCompanyWithDate.put(dateStr, checkedCompany);
                }

                log.debug("第一次分配后剩余企业:{}", toMatchCompanyRandom.size());

                //多余的企业数量小于日期总数再随机分配
                List<ConfigHoliday> lastLoopRandomDate = CommonUtils.randomList(toExtWorkDays, afterTimes);
                for (ConfigHoliday workDate : lastLoopRandomDate) {
                    String dateStr = DateFormatUtils.format(workDate.getHolidayDate(), "yyyy-MM-dd");
                    List<CompanyRandom> checkedCompany = CommonUtils.randomList(toMatchCompanyRandom, 1);
                    toMatchCompanyRandom.removeAll(checkedCompany);

                    List<CompanyRandom> allRandomCompanys = randomCompanyWithDate.get(dateStr);
                    allRandomCompanys.addAll(checkedCompany);
                    randomCompanyWithDate.put(dateStr, allRandomCompanys);
                }

            } else {
                List<ConfigHoliday> lastLoopRandomDate = CommonUtils.randomList(toExtWorkDays, toMatchCompanyRandom.size());
                for (ConfigHoliday workDate : lastLoopRandomDate) {
                    String dateStr = DateFormatUtils.format(workDate.getHolidayDate(), "yyyy-MM-dd");
                    List<CompanyRandom> checkedCompany = CommonUtils.randomList(toMatchCompanyRandom, 1);
                    toMatchCompanyRandom.removeAll(checkedCompany);

                    randomCompanyWithDate.put(dateStr, checkedCompany);
                }
            }

            log.debug("company match date:{}", JSON.toJSONString(randomCompanyWithDate));

        } else {//跨月份
            log.debug("跨月抽取");

            //计算每个月的抽查企业数量与工作日比例
            for (int currentMonth = startMonth; currentMonth <= endMonth; currentMonth++) {
                //查询指定月份待抽取企业纪录
                CompanyRandom queryCompanyRandom = new CompanyRandom();
                queryCompanyRandom.setManageGroupId(groupId);
                queryCompanyRandom.setYear(year);
                queryCompanyRandom.setMonth(currentMonth);
                List<CompanyRandom> companyRandoms = companyRandomService.findByCnd(queryCompanyRandom);
                log.debug("待抽取企业总数:{}", companyRandoms.size());

                //计算当前月份工作日
                ConfigHoliday queryMonthHoliday = new ConfigHoliday();
                Date baseDate = DateUtils.parseDate(year + "-" + currentMonth, "yyyy-M");
                Date monthWorkStartDate = DateRangeUtils.getInstance(baseDate).getFirstDayOfMonth(0);
                Date monthWorkEndDate = DateRangeUtils.getInstance(baseDate).getLastDayOfMonth(0);

                queryMonthHoliday.setStartDate(monthWorkStartDate);
                queryMonthHoliday.setEndDate(monthWorkEndDate);
                queryMonthHoliday.setStatus(0);
                List<ConfigHoliday> workDays = configHolidayService.findByDateRangeWithStatus(queryMonthHoliday);
                log.debug("当月工作日数量:{}", workDays.size());

                //计算企业抽查比例(两位小数,四舍五入)
                BigDecimal extRatio = BigDecimal.valueOf(companyRandoms.size()).divide(BigDecimal.valueOf(workDays.size()), 2, BigDecimal.ROUND_HALF_EVEN);
                log.debug("当月抽查企业与工作日比例:{}", extRatio);

                //计算当前抽取时间范围内工作日
                ConfigHoliday queryExtHoliday = new ConfigHoliday();
                if (currentMonth == startMonth) {
                    queryExtHoliday.setStartDate(extStartDate);
                    queryExtHoliday.setEndDate(monthWorkEndDate);
                } else if (currentMonth == endMonth) {
                    queryExtHoliday.setStartDate(monthWorkStartDate);
                    queryExtHoliday.setEndDate(extEndDate);
                } else {
                    queryExtHoliday.setStartDate(monthWorkStartDate);
                    queryExtHoliday.setEndDate(monthWorkEndDate);
                }
                queryExtHoliday.setStatus(0);
                List<ConfigHoliday> toExtWorkDays = configHolidayService.findByDateRangeWithStatus(queryExtHoliday);
                log.debug("当月抽查时间范围内工作日数量:{}", toExtWorkDays.size());
                Collections.shuffle(toExtWorkDays);

                //计算抽取时间范围内应该抽取的企业数量
                int companySize = extRatio.multiply(BigDecimal.valueOf(toExtWorkDays.size())).intValue();
                log.debug("实际需要抽取企业数量:{}", companySize);

                //随机计算出要抽取哪些企业
                Collections.shuffle(companyRandoms);//TODO 待改为使用权重的随机算法
                //计算出随机抽取的企业
                List<CompanyRandom> toMatchCompanyRandom = CommonUtils.randomList(companyRandoms, companySize);

                //比较抽取的企业数量与日期数量
                if (toMatchCompanyRandom.size() > toExtWorkDays.size()) {
                    log.debug("待抽取企业数量大于工作日:{}-{}", toMatchCompanyRandom.size(), toExtWorkDays.size());

                    int times = toMatchCompanyRandom.size() / toExtWorkDays.size() + 1;//日期和企业分配比例 1 : 1 ~ times个
                    int beforeTimes = times - 1;//随机选择数量,直到最后一次前一次
                    int afterTimes = toMatchCompanyRandom.size() % toExtWorkDays.size();//最后一次选择数量

                    log.debug("第一次分配平均数量:{}", beforeTimes);
                    log.debug("最后一次分配数量:{}", afterTimes);

                    //每个日期先匹配企业与日期比例个数的企业
                    List<CompanyRandom> extractedCompanyRandom = new ArrayList<>();
                    for (ConfigHoliday workDate : toExtWorkDays) {
                        String dateStr = DateFormatUtils.format(workDate.getHolidayDate(), "yyyy-MM-dd");
                        List<CompanyRandom> checkedCompany = CommonUtils.randomList(toMatchCompanyRandom, beforeTimes);
                        toMatchCompanyRandom.removeAll(checkedCompany);

                        randomCompanyWithDate.put(dateStr, checkedCompany);
                    }

                    log.debug("第一次分配后剩余企业:{}", toMatchCompanyRandom.size());

                    //多余的企业数量小于日期总数再随机分配
                    List<ConfigHoliday> lastLoopRandomDate = CommonUtils.randomList(toExtWorkDays, afterTimes);
                    for (ConfigHoliday workDate : lastLoopRandomDate) {
                        String dateStr = DateFormatUtils.format(workDate.getHolidayDate(), "yyyy-MM-dd");
                        List<CompanyRandom> checkedCompany = CommonUtils.randomList(toMatchCompanyRandom, 1);
                        toMatchCompanyRandom.removeAll(checkedCompany);

                        List<CompanyRandom> allRandomCompanys = randomCompanyWithDate.get(dateStr);
                        allRandomCompanys.addAll(checkedCompany);
                        randomCompanyWithDate.put(dateStr, allRandomCompanys);
                    }

                } else {
                    List<ConfigHoliday> lastLoopRandomDate = CommonUtils.randomList(toExtWorkDays, toMatchCompanyRandom.size());
                    for (ConfigHoliday workDate : lastLoopRandomDate) {
                        String dateStr = DateFormatUtils.format(workDate.getHolidayDate(), "yyyy-MM-dd");
                        List<CompanyRandom> checkedCompany = CommonUtils.randomList(toMatchCompanyRandom, 1);
                        toMatchCompanyRandom.removeAll(checkedCompany);

                        randomCompanyWithDate.put(dateStr, checkedCompany);
                    }
                }

                log.debug("company match date:{}", JSON.toJSONString(randomCompanyWithDate));
            }


        }


        //读取抽取规则
        ConfigRuleGroup configRule = configRuleGroupService.findByGroupId(groupId);
        int impGroupType = configRule.getImportantGroup();//重点分组方式
        int impFix = configRule.getImportantFix();//重点固定
        int impRandom = configRule.getImportantRandom();//重点随机

        int norGroupType = configRule.getNormalGroup();//一般分组方式
        int norFix = configRule.getNormalFix();//一般固定
        int norRandom = configRule.getNormalRandom();//一般随机
        IdWorker iwid = new IdWorker();

        LawExecutor queryExecutor = new LawExecutor();
        queryExecutor.setGroupId(groupId);
        queryExecutor.setAptitudes(1);//资深
        //查询待抽取资深执法人员
        //TODO 过滤工作量为0的
        List<LawExecutor> toExtZExecutors = lawExecutorService.findByCnd(queryExecutor);
        log.debug("待抽取资深执法人员数量:{}", toExtZExecutors.size());

        queryExecutor.setAptitudes(2);//普通
        List<LawExecutor> toExtPExecutors = lawExecutorService.findByCnd(queryExecutor);
        log.debug("待抽取普通执法人员数量:{}", toExtPExecutors.size());

        List<ExecutorRandom> executorRandoms = new ArrayList<>();
        //循环日期与企业匹配,随机分配人员
        for (String dateKey : randomCompanyWithDate.keySet()) {
            List<CompanyRandom> companyRandoms = randomCompanyWithDate.get(dateKey);

            for (CompanyRandom rCompany : companyRandoms) {
                List<LawExecutor> extExecutors = new ArrayList<>();
                //判断企业类型
                if (rCompany.getCompanyType() == 1) {//重点
                    //分组模式判断
                    if (impGroupType == 1) {//分组模式
                        //执法人员抽取
                        List<LawExecutor> zsExecutor = CommonUtils.randomList(toExtZExecutors, 1);
                        List<LawExecutor> ptExecutor = CommonUtils.randomList(toExtPExecutors, impRandom);
                        extExecutors.addAll(zsExecutor);
                        extExecutors.addAll(ptExecutor);
                    } else {//非分组模式
                        List<LawExecutor> ptExecutor = CommonUtils.randomList(toExtPExecutors, impRandom);
                        extExecutors.addAll(ptExecutor);
                    }

                } else {//一般
                    //分组模式判断
                    if (norGroupType == 1) {//分组模式
                        //执法人员抽取
                        List<LawExecutor> zsExecutor = CommonUtils.randomList(toExtZExecutors, 1);
                        List<LawExecutor> ptExecutor = CommonUtils.randomList(toExtPExecutors, norRandom);
                        extExecutors.addAll(zsExecutor);
                        extExecutors.addAll(ptExecutor);
                    } else {//非分组模式
                        List<LawExecutor> ptExecutor = CommonUtils.randomList(toExtPExecutors, norRandom);
                        extExecutors.addAll(ptExecutor);
                    }

                }

                //企业 + 执法人员
                long recordNo = iwid.getId();
                for (LawExecutor executor : extExecutors) {
                    ExecutorRandom exeRandom = new ExecutorRandom();
                    exeRandom.setCheckDate(DateUtils.parseDate(dateKey, "yyyy-MM-dd"));
                    exeRandom.setCompanyId(rCompany.getCompanyId());
                    exeRandom.setCompanyType(rCompany.getCompanyType());
                    exeRandom.setExecutorId(executor.getId());
                    exeRandom.setYear(year);
                    exeRandom.setRecordDate(new Date());
                    exeRandom.setRecordNo(String.valueOf(recordNo));
                    exeRandom.setGroupId(groupId);
                    exeRandom.setBatchNo(batchNo);
                    executorRandoms.add(exeRandom);
                }
            }
        }

        log.debug("最终匹配结果:{}", JSON.toJSONString(executorRandoms));


        if (null != executorRandom && executorRandomService.saveBatch(executorRandoms) > 0) {
            result.setOk(true).setMsg("保存成功！").setData(batchNo);
        }
        return result;
    }

    /**
     * 保存修改后的执法者抽取纪录信息
     *
     * @param executorRandom
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(ExecutorRandom executorRandom) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != executorRandom && executorRandomService.modify(executorRandom) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除执法者抽取纪录信息
     *
     * @param batchNo 批次编码
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam(value = "bno", defaultValue = "") String batchNo) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (StringUtils.isNoneBlank(batchNo) && executorRandomService.deleteByBatchNo(batchNo) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

}
