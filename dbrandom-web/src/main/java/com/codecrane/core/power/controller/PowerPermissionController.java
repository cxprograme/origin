package com.codecrane.core.power.controller;

import com.codecrane.core.power.service.PowerPermissionService;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.core.power.entity.PowerPermission;
import com.codecrane.core.power.entity.RelRolePermission;
import com.codecrane.core.power.service.PowerMenuService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限信息表 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/power/permission")
public class PowerPermissionController {

    @Autowired
    private PowerPermissionService powerPermissionService;

    @Autowired
    private PowerMenuService powerMenuService;

    /**
     * 权限信息表管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String powerPermissionListPage(Model model, @RequestParam(value = "type", defaultValue = "0") int permissionType) {

        String view = "/power/permission/main";
        switch (permissionType) {
            case 1:
                view = "redirect:/power/menu/main.html";
                break;
            case 2:
                view = "redirect:/power/operation/main.html";
                break;
            default:
                break;
        }
        return view;

    }

    /**
     * 新增权限信息表页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addPowerPermissionPage(Model model) {

        return "/power/permission/add";
    }

    /**
     * 修改权限信息表页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editPowerPermissionPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询权限信息表
        PowerPermission powerPermission = powerPermissionService.findById(id);

        // 将权限信息表返回到页面中
        model.addAttribute("powerpermission", powerPermission);

        return "/power/permission/edit";
    }

    /**
     * 权限绑定选择页面
     *
     * @param model
     * @param roleId
     * @return
     */
    @RequestMapping("/selectpermission")
    public String selectPermissionPage(Model model, @RequestParam("rid") long roleId) {


        //查询角色绑定权限数据
        model.addAttribute("bindpermissions", powerPermissionService.findByRoleId(roleId));

        model.addAttribute("roleid", roleId);

        //菜单数据查询
        model.addAttribute("menus", powerMenuService.findAllPowerMenu());

        //TODO 操作数据查询

        return "/power/permission/select_permission";
    }

    /**
     * 分页查询权限信息表
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllPowerPermission(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                  @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<PowerPermission> powerPermissions = powerPermissionService.findByPermissionType(0);
        PageInfo<PowerPermission> page = new PageInfo<PowerPermission>(powerPermissions);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存权限信息表
     *
     * @param powerPermission
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(PowerPermission powerPermission) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != powerPermission && powerPermissionService.save(powerPermission) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的权限信息表
     *
     * @param powerPermission
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(PowerPermission powerPermission) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != powerPermission && powerPermissionService.modify(powerPermission) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除权限信息表
     *
     * @param ids 权限信息表编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") long[] ids) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && powerPermissionService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

    /**
     * 绑定角色与权限关系
     *
     * @param roleId
     * @param permissionIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/saverelrolepermission")
    public AjaxReturn bindRelRolePermission(@RequestParam("rid") long roleId, @RequestParam("ids") long[] permissionIds) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (permissionIds.length > 0) {
            List<RelRolePermission> relRolePermissions = new ArrayList<>();
            for (long permissionId : permissionIds) {
                relRolePermissions.add(new RelRolePermission(roleId, permissionId));
            }
            if (powerPermissionService.batchSaveRelRolePermission(relRolePermissions, roleId, -1) > 0) {
                result.setOk(true).setMsg("保存成功");
            }
        }
        return result;
    }
}
