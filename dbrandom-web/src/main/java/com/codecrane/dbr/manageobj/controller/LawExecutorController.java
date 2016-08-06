package com.codecrane.dbr.manageobj.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.manageobj.entity.LawExecutor;
import com.codecrane.dbr.manageobj.service.LawExecutorService;
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
 * 执法者基本信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/lawexecutor/info")
public class LawExecutorController {

    @Autowired
    private LawExecutorService lawExecutorService;

    @Autowired
    private PowerGroupService powerGroupService;

    /**
     * 执法者基本信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String lawExecutorListPage(Model model) {

        //获取当前用户的管理机构编号
        Subject subject = SecurityUtils.getSubject();
        PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            model.addAttribute("groupId", user.getGroupId());
            //查询当前机构以及子机构信息
            PowerGroup group = new PowerGroup();
            group.setId(user.getGroupId());
            model.addAttribute("groups", powerGroupService.findAllChildGroup(group));
        }

        return "/dbr/manageobj/executor/main";
    }

    /**
     * 新增执法者基本信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addLawExecutorPage(@RequestParam(value = "gid", defaultValue = "0") Long groupId, Model model) {

        //查询当前机构以及子机构信息
        PowerGroup group = new PowerGroup();
        group.setId(groupId);
        model.addAttribute("groups", powerGroupService.findAllChildGroup(group));

        return "/dbr/manageobj/executor/add";
    }

    /**
     * 修改执法者基本信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editLawExecutorPage(@RequestParam("id") Integer id,@RequestParam(value = "gid", defaultValue = "0") Long groupId, Model model) {

        // 根据ID查询执法者基本信息
        LawExecutor lawExecutor = lawExecutorService.findById(id);

        // 将执法者基本信息返回到页面中
        model.addAttribute("lawExecutor", lawExecutor);

        //查询当前机构以及子机构信息
        PowerGroup group = new PowerGroup();
        group.setId(groupId);
        model.addAttribute("groups", powerGroupService.findAllChildGroup(group));

        return "/dbr/manageobj/executor/edit";
    }

    /**
     * 分页查询执法者基本信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllLawExecutor(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                              @RequestParam(value = "offset", defaultValue = "0") int start,LawExecutor executor) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<LawExecutor> lawExecutors = lawExecutorService.findByCnd(executor);
        PageInfo<LawExecutor> page = new PageInfo<LawExecutor>(lawExecutors);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(LawExecutor lawExecutor) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != lawExecutor && lawExecutorService.save(lawExecutor) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的执法者基本信息
     *
     * @param lawExecutor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(LawExecutor lawExecutor) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != lawExecutor && lawExecutorService.modify(lawExecutor) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除执法者基本信息
     *
     * @param ids 执法者基本信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && lawExecutorService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
