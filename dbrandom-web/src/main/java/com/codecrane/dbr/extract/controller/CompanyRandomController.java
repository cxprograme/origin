package com.codecrane.dbr.extract.controller;

import com.alibaba.fastjson.JSONObject;
import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.util.DateRangeUtils;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.extract.entity.CompanyRandom;
import com.codecrane.dbr.extract.entity.MonthRandom;
import com.codecrane.dbr.extract.service.CompanyRandomService;
import com.codecrane.dbr.manageobj.entity.Company;
import com.codecrane.dbr.manageobj.service.CompanyService;
import com.codecrane.dbr.plan.entity.YearPlan;
import com.codecrane.dbr.plan.service.YearPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
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

import java.text.ParseException;
import java.util.*;

/**
 * 企业随机抽取纪录信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/extract/company")
public class CompanyRandomController {

    @Autowired
    private CompanyRandomService companyRandomService;

    @Autowired
    private PowerGroupService powerGroupService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private YearPlanService yearPlanService;

    /**
     * 企业随机抽取纪录信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String companyRandomListPage(Model model) {

        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {

            Long groupId = user.getGroupId();

            model.addAttribute("groupId", groupId);
            //当前机构以及子机构信息
            PowerGroup group = new PowerGroup();
            group.setId(groupId);
            model.addAttribute("groups", powerGroupService.findAllChildGroup(group));
            //当前机构下的抽取历史纪录
            model.addAttribute("records", companyRandomService.findByGrouped(groupId.intValue()));
            //当前管理机构年度执法计划
            YearPlan yearPlan = new YearPlan();
            yearPlan.setGroupId(groupId.intValue());
            yearPlan.setYear(DateFormatUtils.format(new Date(),"yyyy"));
            model.addAttribute("yearPlan", yearPlanService.findByCnd(yearPlan).get(0));
        }

        return "/dbr/extract/company/config";
    }


    /**
     * 修改企业随机抽取纪录信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editCompanyRandomPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询企业随机抽取纪录信息
        CompanyRandom companyRandom = companyRandomService.findById(id);

        // 将企业随机抽取纪录信息返回到页面中
        model.addAttribute("companyRandom", companyRandom);

        return "/companyrandom/info/edit";
    }

    /**
     * 分页查询企业随机抽取纪录信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllCompanyRandom(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                @RequestParam(value = "offset", defaultValue = "0") int start, CompanyRandom companyRandom) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<CompanyRandom> companyRandoms = companyRandomService.findByCnd(companyRandom);
        PageInfo<CompanyRandom> page = new PageInfo<CompanyRandom>(companyRandoms);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存企业随机抽取纪录信息
     *
     * @param companyRandom
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(CompanyRandom companyRandom) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != companyRandom && companyRandomService.save(companyRandom) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 随机抽取企业纪录
     *
     * @param companyRandom
     * @param reExtract        重新抽取标志 默认n 不是重新抽取
     * @param reExtractBatchNo 重新抽取前要删除的批次
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/doextract", method = RequestMethod.POST)
    public AjaxReturn extractCompany(CompanyRandom companyRandom, @RequestParam(value = "re", defaultValue = "n") String reExtract, @RequestParam(value = "bno", defaultValue = "") String reExtractBatchNo) {

        AjaxReturn result = Ajax.fail().setMsg("抽取失败！");

        List<MonthRandom> monthRandoms = companyRandom.getMonthRandoms();
        //TODO 企业随机抽取
        //1. 查询出指定管理机构下的企业
        //2. 查询指定管理机构的抽取规则配置(分类属性比重)
        //3. 解析当前抽取的月份以及月份中的重点和一般的数量
        //4. 随机抽取待抽取的企业

        Company company = new Company();
        company.setGroupId(companyRandom.getManageGroupId());
        List<Company> companies = companyService.findByCndWithGroupNoPoints(company);

        List<Company> importantComanies = new ArrayList<>();
        List<Company> normalComanies = new ArrayList<>();
        //划分重点企业和一般企业
        for (Company tempCompany : companies) {
            if (tempCompany.getType() == 1) {
                importantComanies.add(tempCompany);
            } else {
                normalComanies.add(tempCompany);
            }
        }

        //分解每个月抽取的企业
        String batchNo = UUID.randomUUID().toString();
        List<CompanyRandom> companyRandoms = new ArrayList<>();
        for (MonthRandom monthRandom : monthRandoms) {

            Set<Integer> impIndexs = new HashSet<>();
            while (impIndexs.size() < monthRandom.getImportant()) {
                //随机取一个重点企业索引
                impIndexs.add(RandomUtils.nextInt(0, importantComanies.size()));
            }

            Set<Integer> norIndexs = new HashSet<>();
            while (norIndexs.size() < monthRandom.getNormal()) {
                //随机取一个普通企业索引
                norIndexs.add(RandomUtils.nextInt(0, normalComanies.size()));
            }

            //重点随机企业
            for (Integer importantIndex : impIndexs) {
                Company currentRdmCompany = importantComanies.get(importantIndex);

                CompanyRandom tempCompanyRandom = new CompanyRandom();
                tempCompanyRandom.setCompanyId(currentRdmCompany.getId());
                tempCompanyRandom.setCompanyType(currentRdmCompany.getType());
                tempCompanyRandom.setManageGroupId(companyRandom.getManageGroupId());
                tempCompanyRandom.setMonth(monthRandom.getMonth());
                tempCompanyRandom.setYear(companyRandom.getYear());
                tempCompanyRandom.setBatchNo(batchNo);

                companyRandoms.add(tempCompanyRandom);
            }

            //普通随机企业
            for (Integer normalIndex : norIndexs) {
                Company currentRdmCompany = normalComanies.get(normalIndex);

                CompanyRandom tempCompanyRandom = new CompanyRandom();
                tempCompanyRandom.setCompanyId(currentRdmCompany.getId());
                tempCompanyRandom.setCompanyType(currentRdmCompany.getType());
                tempCompanyRandom.setManageGroupId(companyRandom.getManageGroupId());
                tempCompanyRandom.setMonth(monthRandom.getMonth());
                tempCompanyRandom.setYear(companyRandom.getYear());
                tempCompanyRandom.setBatchNo(batchNo);

                companyRandoms.add(tempCompanyRandom);
            }
        }

        if (null != companyRandom && companyRandomService.saveBatch(companyRandoms) > 0) {
            if (StringUtils.endsWithIgnoreCase(reExtract, "y")) {
                companyRandomService.deleteByBatchNo(reExtractBatchNo);
            }
            result.setOk(true).setMsg("抽取成功！").setData(batchNo);
        }

        return result;
    }


    /**
     * 保存修改后的企业随机抽取纪录信息
     *
     * @param companyRandom
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(CompanyRandom companyRandom) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != companyRandom && companyRandomService.modify(companyRandom) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除企业随机抽取纪录信息
     *
     * @param ids 企业随机抽取纪录信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && companyRandomService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

    /**
     * 删除 指定批次企业随机抽取记录
     *
     * @param batchNo
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletebybno")
    public AjaxReturn deleteByIds(@RequestParam("bno") String batchNo) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (StringUtils.isNoneBlank(batchNo) && companyRandomService.deleteByBatchNo(batchNo) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

    /**
     * 根据管理机构年份统计抽取企业数量
     *
     * @param groupId
     * @param year
     * @return
     */
    @ResponseBody
    @RequestMapping("/findcountbygroupandyear")
    public AjaxReturn findByGroupIdAndYear(@RequestParam(value = "gid", defaultValue = "0") Integer groupId, @RequestParam(value = "y", defaultValue = "0") Integer year) throws ParseException {
        AjaxReturn result = Ajax.fail().setMsg("没有您要查询的数据");
        if (groupId != 0 && year != 0) {
            List<CompanyRandom> countRandoms = companyRandomService.findCountByCompanyType(groupId, year);

            JSONObject countResult = new JSONObject();
            if (null != countRandoms && countRandoms.size() > 0 && null != countRandoms.get(0)) {
                Date startMonth = DateRangeUtils.getInstance(DateUtils.parseDate(year + "-" + countRandoms.get(0).getStartMonth(), "yyyy-M")).getFirstDayOfMonth(0);
                countResult.put("startMonth", DateFormatUtils.format(startMonth, year.toString() + "-MM-dd"));

                Date endMonth = DateRangeUtils.getInstance(DateUtils.parseDate(year + "-" + countRandoms.get(0).getEndMonth(), "yyyy-M")).getLastDayOfMonth(0);
                countResult.put("endMonth", DateFormatUtils.format(endMonth, year.toString() + "-MM-dd"));
            }

            countResult.put("countResult", countRandoms);

            result.setOk(true).setData(countResult).setMsg("查询成功");
        }
        return result;
    }

}
