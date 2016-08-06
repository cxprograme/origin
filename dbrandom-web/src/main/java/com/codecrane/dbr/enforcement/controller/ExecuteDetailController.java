package com.codecrane.dbr.enforcement.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.enforcement.entity.ExecuteDetail;
import com.codecrane.dbr.enforcement.entity.ExecuteFeedback;
import com.codecrane.dbr.enforcement.service.ExecuteDetailService;
import com.codecrane.dbr.enforcement.service.ExecuteFeedbackService;
import com.codecrane.dbr.extract.entity.ExecutorRandom;
import com.codecrane.dbr.extract.service.ExecutorRandomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 执法反馈处理纪录 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/execute/detail")
public class ExecuteDetailController {

    @Autowired
    private ExecuteDetailService executeDetailService;

    @Autowired
    private ExecuteFeedbackService executeFeedbackService;

    @Autowired
    private PowerGroupService powerGroupService;

    @Autowired
    private ExecutorRandomService executorRandomService;

    /**
     * 执法反馈处理纪录管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String executeDetailListPage(Model model) {
        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            model.addAttribute("groupId", user.getGroupId());
        }
        return "/dbr/enforcement/executedetail/main";
    }

    /**
     * 执法反馈分发处理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/distribute")
    public String addExecuteDetailPage(@RequestParam(value = "id", defaultValue = "0") Integer feeedbackId,
                                       @RequestParam(value = "gid", defaultValue = "0") Integer manageGroupId,
                                       @RequestParam(value = "fdid", defaultValue = "0") Integer feedbackDetailId, Model model) {

        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {

            Long groupId = user.getGroupId();

            model.addAttribute("groupId", groupId);
            model.addAttribute("manageGroupId", manageGroupId);
            model.addAttribute("feedbackDetailId", feedbackDetailId);
            //当前机构以及子机构信息
            PowerGroup group = new PowerGroup();
            group.setId(groupId);
            model.addAttribute("groups", powerGroupService.findAllChildGroup(group));
        }

        model.addAttribute("feedback", executeFeedbackService.findById(feeedbackId));

        return "/dbr/enforcement/executedetail/distribute";
    }

    /**
     * 执法反馈分发办结页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/deal")
    public String dealFeedbackPage(@RequestParam(value = "id", defaultValue = "0") Integer feeedbackId, Model model) {

        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            model.addAttribute("groupId", user.getGroupId());
        }
        model.addAttribute("feedback", executeFeedbackService.findById(feeedbackId));

        return "/dbr/enforcement/executedetail/deal";
    }


    /**
     * 执法反馈处理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String dealDetailFeedbackPage(@RequestParam(value = "id", defaultValue = "0") Integer feeedbackId, Model model) {

        // 查询当前用户可选管理机构
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            model.addAttribute("groupId", user.getGroupId());
        }

        //处理情况纪录
        ExecuteFeedback feedback = executeFeedbackService.findById(feeedbackId);
        model.addAttribute("feedback", feedback);
        ExecutorRandom random = new ExecutorRandom();
        random.setRecordNo(feedback.getPlanId());
        List<ExecutorRandom> executorRandoms = executorRandomService.findByCndAndGroupedWithFeedback(random);
        model.addAttribute("feedbackDetail", null != executorRandoms ? executorRandoms.get(0) : null);

        ExecuteDetail executeDetail = new ExecuteDetail();
        executeDetail.setFeedbackId(feeedbackId);
        model.addAttribute("dealDetail", executeDetailService.findByCnd(executeDetail));

        return "/dbr/enforcement/executedetail/detail";
    }

    /**
     * 执法反馈处理详情页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/viewdetail")
    public String viewDetailFeedbackPage(@RequestParam(value = "id", defaultValue = "0") Integer feeedbackId, Model model) {

        //处理情况纪录
        ExecuteFeedback feedback = executeFeedbackService.findById(feeedbackId);
        ExecutorRandom random = new ExecutorRandom();
        random.setRecordNo(feedback.getPlanId());
        List<ExecutorRandom> executorRandoms = executorRandomService.findByCndAndGroupedWithFeedback(random);
        model.addAttribute("feedbackDetail", null != executorRandoms ? executorRandoms.get(0) : null);

        ExecuteDetail executeDetail = new ExecuteDetail();
        executeDetail.setFeedbackId(feeedbackId);
        model.addAttribute("dealDetail", executeDetailService.findByCnd(executeDetail));

        return "/dbr/enforcement/executedetail/viewdetail";
    }

    /**
     * 修改执法反馈处理纪录页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editExecuteDetailPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询执法反馈处理纪录
        ExecuteDetail executeDetail = executeDetailService.findById(id);

        // 将执法反馈处理纪录返回到页面中
        model.addAttribute("executeDetail", executeDetail);

        return "/executedetail/info/edit";
    }

    /**
     * 分页查询执法反馈处理纪录
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllExecuteDetail(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<ExecuteDetail> executeDetails = executeDetailService.findAllExecuteDetail();
        PageInfo<ExecuteDetail> page = new PageInfo<ExecuteDetail>(executeDetails);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存执法反馈处理纪录
     *
     * @param executeDetail
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(ExecuteDetail executeDetail,
                           @RequestParam(value = "twicedistribute", defaultValue = "0") int isTwiceDistribute,
                           @RequestParam(value = "fdid",defaultValue = "0")Integer feedbackDetailId) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != executeDetail && executeDetailService.save(executeDetail) > 0) {

            if( 1 == isTwiceDistribute && 0 != feedbackDetailId){
                ExecuteDetail parentDetail = new ExecuteDetail();
                parentDetail.setId(feedbackDetailId);
                parentDetail.setStatus(3);
                executeDetailService.modify(parentDetail);
            }

            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 自己处理执法反馈
     *
     * @param executeDetail
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/dealself", method = RequestMethod.POST)
    public AjaxReturn dealSelf(ExecuteDetail executeDetail) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != executeDetail && executeDetailService.dealSelf(executeDetail) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的执法反馈处理纪录
     *
     * @param executeDetail
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(ExecuteDetail executeDetail) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        //回复任务,同时更新执法反馈状态为1:已回复
        if (null != executeDetail && executeDetailService.dealFeedback(executeDetail) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除执法反馈处理纪录
     *
     * @param ids 执法反馈处理纪录编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && executeDetailService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
