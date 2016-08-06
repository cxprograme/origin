package com.codecrane.core.power.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.power.service.PowerUserService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
 * 用户信息表 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/power/user")
public class PowerUserController {

    @Autowired
    private PowerGroupService powerGroupService;

    @Autowired
    private PowerUserService powerUserService;

    /**
     * 用户信息表管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String powerUserListPage(Model model) {

        model.addAttribute("groups", powerGroupService.findAllPowerGroup());
        return "/power/user/main";
    }

    /**
     * 新增用户信息表页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addPowerUserPage(Model model, @RequestParam(value = "gid", defaultValue = "-1", required = false) long groupId) {

        model.addAttribute("groupid", groupId);

        return "/power/user/add";
    }

    /**
     * 修改用户信息表页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editPowerUserPage(@RequestParam("id") long id, Model model) {

        // 根据ID查询用户信息表
        PowerUser powerUser = powerUserService.findById(id);

        // 将用户信息表返回到页面中
        model.addAttribute("poweruser", powerUser);

        return "/power/user/edit";
    }

    /**
     * 修改密码页面
     *
     * @return
     */
    @RequestMapping(value = "/changepwdpage", method = RequestMethod.GET)
    public String changePasswordPage() {
        return "/power/user/changepassword";
    }

    /**
     * 修改个人资料页面
     *
     * @return
     */
    @RequestMapping(value = "/changeprofilepage", method = RequestMethod.GET)
    public String changeProfilePage(Model model) {
        PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user ) {
            PowerUser profile = powerUserService.findByUserAccount(user.getUserAccount());
            model.addAttribute("profile", profile);
        }
        return "/power/user/changeprofile";
    }

    /**
     * 分页查询用户信息表
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllPowerUser(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                            @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<PowerUser> powerUsers = powerUserService.findAllPowerUser();
        PageInfo<PowerUser> page = new PageInfo<PowerUser>(powerUsers);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 查询指定组织机构下的用户
     *
     * @param pagesize
     * @param start
     * @param groupId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbygid")
    AjaxTableReturn findByGroupId(@RequestParam(value = "limit", defaultValue = "10") int pagesize, @RequestParam(value = "offset", defaultValue = "0") int start, @RequestParam(value = "gid", defaultValue = "-1") long groupId) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<PowerUser> powerUsers = powerUserService.findUsersByGroupId(groupId);
        PageInfo<PowerUser> page = new PageInfo<PowerUser>(powerUsers);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存用户信息表
     *
     * @param powerUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(PowerUser powerUser) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != powerUser && powerUserService.save(powerUser) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的用户信息表
     *
     * @param powerUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(PowerUser powerUser) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != powerUser && powerUserService.modify(powerUser) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }

    /**
     * 保存修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changepwdsave", method = RequestMethod.POST)
    public AjaxReturn changePasswordSave(@RequestParam(value = "oldpwd", defaultValue = "") String oldPassword,
                                         @RequestParam(value = "newpwd", defaultValue = "") String newPassword) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(newPassword)) {

            PowerUser user = (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
            if (null != user ) {
                if( powerUserService.changePassword(user.getUserAccount(), oldPassword, newPassword) == 1 ){
                    result.setOk(true).setMsg("修改成功！");

                }else {
                    result.setMsg("旧密码错误");
                }
            }else {
                result.setMsg("用户不存在");
            }

        }else {
            result.setMsg("旧密码或新密码不能为空");
        }
        return result;
    }


    /**
     * 删除用户信息表
     *
     * @param ids 用户信息表编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") long[] ids) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && powerUserService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

}
