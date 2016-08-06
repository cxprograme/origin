package com.codecrane.core.power.controller;

import com.codecrane.core.power.entity.PowerRole;
import com.codecrane.core.power.entity.RelUserRole;
import com.codecrane.core.power.service.PowerRoleService;
import com.codecrane.core.web.AjaxTableReturn;
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
 * 角色信息表 控制器
 * 
 * @author Crane(hehebaiy@gmail.com) 
 *  <br/>
 *  <br/>
 */
@Controller
@RequestMapping("/power/role")
public class PowerRoleController {
	
	@Autowired
	private PowerRoleService powerRoleService;
	
	/**
	 * 角色信息表管理主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String powerRoleListPage(Model model) {
		return "/power/role/main";
	}

	/**
	 * 新增角色信息表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addPowerRolePage(Model model) {

		return "/power/role/add";
	}

	/**
	 * 角色信息选择列表页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectrole")
	public String selectPowerRolePage(Model model,@RequestParam(value = "uid",required = false)long userId) {

		//询用户已绑定的角色
		List<PowerRole> bindedRols = powerRoleService.findByUserId(userId);
		model.addAttribute("bindroles",bindedRols);

		model.addAttribute("userid",userId);

		return "/power/role/select_role";
	}

	/**
	 * 修改角色信息表页面
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping("/editpage")
	public String editPowerRolePage(@RequestParam("id") long id, Model model) {

		// 根据ID查询角色信息表
		PowerRole powerRole = powerRoleService.findById(id);

		// 将角色信息表返回到页面中
		model.addAttribute("powerrole", powerRole);

		return "/power/role/edit";
	}
	
	/**
	 * 分页查询角色信息表
	 * @param pagesize
	 * @param start
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findall")
	public AjaxTableReturn findAllPowerRole(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
											@RequestParam(value = "offset", defaultValue = "0") int start) {
		start = start > 0 ? start / pagesize + 1 : 1;
		PageHelper.startPage(start, pagesize);
		List<PowerRole> powerRoles = powerRoleService.findAllPowerRole();
		PageInfo<PowerRole> page = new PageInfo<PowerRole>(powerRoles);

		return Ajax.tableDataOk(page.getTotal(), page.getList());
	}

	/**
	 * 保存角色信息表
	 * 
	 * @param powerRole
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AjaxReturn save(PowerRole powerRole) {
		AjaxReturn result = Ajax.fail().setMsg("保存失败！");
		if (null != powerRole && powerRoleService.save(powerRole) > 0) {
			result.setOk(true).setMsg("保存成功！");
		}
		return result;
	}
	
	/**
	 * 保存修改后的角色信息表
	 * 
	 * @param powerRole
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/usave", method = RequestMethod.POST)
	public AjaxReturn updateSave(PowerRole powerRole) {
		AjaxReturn result = Ajax.fail().setMsg("修改失败！");
		if (null != powerRole && powerRoleService.modify(powerRole) > 0) {
			result.setOk(true).setMsg("修改成功！");
		}
		return result;
	}
	

	/**
	 * 删除角色信息表
	 * 
	 * @param ids
	 *            角色信息表编号
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public AjaxReturn deleteByIds(@RequestParam("ids") long[] ids) {
		AjaxReturn result = Ajax.fail().setMsg("操作失败！");
		if (ids.length > 0 && powerRoleService.deleteByIds(ids) >0 ) {
			result.setOk(true).setMsg("删除成功");
		}
		return result;
	}


	/**
	 * 保存用户与角色关联
	 * @param roleIds
	 * @param userId
     * @return
     */
	@ResponseBody
	@RequestMapping("/savereluserrole")
	public AjaxReturn saveRelUserRole(@RequestParam("rids")long[] roleIds,@RequestParam("uid")long userId){
		AjaxReturn result = Ajax.fail().setMsg("操作失败！");
		if (roleIds.length >0){
			List<RelUserRole> relUserRoles = new ArrayList<RelUserRole>();
			for (long roleId:roleIds){
				relUserRoles.add(new RelUserRole(userId,roleId));
			}
			if( powerRoleService.batchSaveRelUserRoleWithDel(relUserRoles,-1,userId) > 0 ){
				result.setOk(true).setMsg("保存成功");
			}
		}

		return  result;
	}
}
