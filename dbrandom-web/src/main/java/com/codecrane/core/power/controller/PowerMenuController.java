package com.codecrane.core.power.controller;

import com.codecrane.core.power.entity.PowerMenu;
import com.codecrane.core.web.AjaxTableReturn;
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

import java.util.List;

/**
 * 菜单信息表 控制器
 * 
 * @author Crane(hehebaiy@gmail.com) 
 *  <br/>
 *  <br/>
 */
@Controller
@RequestMapping("/power/menu")
public class PowerMenuController {
	
	@Autowired
	private PowerMenuService powerMenuService;
	
	/**
	 * 菜单信息表管理主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String powerMenuListPage(Model model) {


		model.addAttribute("menus",powerMenuService.findAllPowerMenu());

		return "/power/menu/main";
	}


	/**
	 * 菜单图标选择页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/selecticon")
	public String powerMenuIconpage(Model model) {
		return "/power/menu/select_menu_icon";
	}

	/**
	 * 新增菜单信息表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addPowerMenuPage(Model model,@RequestParam(value = "pid",defaultValue = "0")long menuPid) {

		model.addAttribute("parentMenu",powerMenuService.findById(menuPid));

		return "/power/menu/add";
	}

	/**
	 * 修改菜单信息表页面
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping("/editpage")
	public String editPowerMenuPage(@RequestParam("id") long id, Model model) {

		// 根据ID查询菜单信息表
		PowerMenu powerMenu = powerMenuService.findById(id);

		// 将菜单信息表返回到页面中
		model.addAttribute("powermenu", powerMenu);

		return "/power/menu/edit";
	}

	/**
	 * 分页查询菜单信息表
	 * @param pagesize
	 * @param start
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findall")
	public AjaxTableReturn findAllPowerMenu(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
											@RequestParam(value = "offset", defaultValue = "0") int start) {
		start = start > 0 ? start / pagesize + 1 : 1;
		PageHelper.startPage(start, pagesize);
		List<PowerMenu> powerMenus = powerMenuService.findAllPowerMenu();
		PageInfo<PowerMenu> page = new PageInfo<PowerMenu>(powerMenus);

		return Ajax.tableDataOk(page.getTotal(), page.getList());
	}

	/**
	 * 分页查询菜单信息表
	 * @param pagesize
	 * @param start
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findbypid")
	public AjaxTableReturn findMenuByParentId(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
			@RequestParam(value = "offset", defaultValue = "0") int start,@RequestParam(value = "pid")long menuPid) {
		start = start > 0 ? start / pagesize + 1 : 1;
		PageHelper.startPage(start, pagesize);
		List<PowerMenu> powerMenus = powerMenuService.findByMenuPid(menuPid);
		PageInfo<PowerMenu> page = new PageInfo<PowerMenu>(powerMenus);

		return Ajax.tableDataOk(page.getTotal(), page.getList());
	}

	/**
	 * 保存菜单信息表
	 * 
	 * @param powerMenu
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AjaxReturn save(PowerMenu powerMenu) {
		AjaxReturn result = Ajax.fail().setMsg("保存失败！");

		if (null != powerMenu && powerMenuService.saveWithPermission(powerMenu) > 0) {
			result.setOk(true).setMsg("保存成功！").setData(powerMenu);
		}
		return result;
	}
	
	/**
	 * 保存修改后的菜单信息表
	 * 
	 * @param powerMenu
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/usave", method = RequestMethod.POST)
	public AjaxReturn updateSave(PowerMenu powerMenu) {
		AjaxReturn result = Ajax.fail().setMsg("修改失败！");
		//TODO 修改菜单一并修改关联的权限信息
		if (null != powerMenu && powerMenuService.modifyWithPermission(powerMenu) > 0) {
			result.setOk(true).setMsg("修改成功！");
		}
		return result;
	}
	

	/**
	 * 删除菜单信息表
	 * 
	 * @param ids
	 *            菜单信息表编号
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public AjaxReturn deleteByIds(@RequestParam("ids") long[] ids) {
		AjaxReturn result = Ajax.fail().setMsg("操作失败！");
		if (ids.length > 0 && powerMenuService.deleteByIds(ids) >0 ) {
			result.setOk(true).setMsg("删除成功");
		}
		return result;
	}
}
