package com.codecrane.dbr.plan.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.plan.entity.YearPlan;
import com.codecrane.dbr.plan.service.YearPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 年度执法计划 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/yearplan/info")
public class YearPlanController {

    @Autowired
    private YearPlanService yearPlanService;

    @Autowired
    private PowerGroupService powerGroupService;

    /**
     * 年度执法计划管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String yearPlanListPage(Model model) {

        //获取当前用户的管理机构编号
        Subject subject = SecurityUtils.getSubject();
        PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user){
            model.addAttribute("groupId",user.getGroupId());
        }

        return "/dbr/plan/main";
    }

    /**
     * 新增年度执法计划页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addYearPlanPage(Model model) {

        Subject subject = SecurityUtils.getSubject();
        PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user){
            model.addAttribute("groupId",user.getGroupId());
            model.addAttribute("groupType",powerGroupService.findById(user.getGroupId()).getGroupType());
        }

        return "/dbr/plan/add";
    }

    /**
     * 修改年度执法计划页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editYearPlanPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询年度执法计划
        YearPlan yearPlan = yearPlanService.findById(id);

        // 将年度执法计划返回到页面中
        model.addAttribute("yearPlan", yearPlan);

        return "/dbr/plan/edit";
    }

    /**
     * 分页查询年度执法计划
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllYearPlan(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                           @RequestParam(value = "offset", defaultValue = "0") int start,YearPlan plan) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<YearPlan> yearPlans = yearPlanService.findByCnd(plan);
        PageInfo<YearPlan> page = new PageInfo<YearPlan>(yearPlans);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存年度执法计划
     *
     * @param yearPlan
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(YearPlan yearPlan) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != yearPlan && yearPlanService.save(yearPlan) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的年度执法计划
     *
     * @param yearPlan
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(YearPlan yearPlan) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != yearPlan && yearPlanService.modify(yearPlan) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除年度执法计划
     *
     * @param ids 年度执法计划编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && yearPlanService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
