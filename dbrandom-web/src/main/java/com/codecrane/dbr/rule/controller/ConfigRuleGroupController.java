package com.codecrane.dbr.rule.controller;

import java.util.List;

import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.codecrane.dbr.rule.entity.ConfigRuleGroup;
import com.codecrane.dbr.rule.service.ConfigRuleGroupService;

/**
 * 抽取规则分组模式配置 控制器
 * 
 * @author Crane(hehebaiy@gmail.com) 
 *  <br/>
 *  <br/>
 */
@Controller
@RequestMapping("/configrulegroup/info")
public class ConfigRuleGroupController {
	
	@Autowired
	private ConfigRuleGroupService configRuleGroupService;
	
	/**
	 * 抽取规则分组模式配置管理主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String configRuleGroupListPage(Model model) {
		return "/configrulegroup/info/main";
	}

	/**
	 * 新增抽取规则分组模式配置页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addConfigRuleGroupPage(Model model) {

		return "/configrulegroup/info/add";
	}

	/**
	 * 修改抽取规则分组模式配置页面
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping("/editpage")
	public String editConfigRuleGroupPage(@RequestParam("id") Integer id, Model model) {

		// 根据ID查询抽取规则分组模式配置
		ConfigRuleGroup configRuleGroup = configRuleGroupService.findById(id);

		// 将抽取规则分组模式配置返回到页面中
		model.addAttribute("configRuleGroup", configRuleGroup);

		return "/configrulegroup/info/edit";
	}
	
	/**
	 * 分页查询抽取规则分组模式配置
	 * @param pagesize
	 * @param start
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findall")
	public AjaxTableReturn findAllConfigRuleGroup(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
												  @RequestParam(value = "offset", defaultValue = "0") int start) {
		start = start > 0 ? start / pagesize + 1 : 1;
		PageHelper.startPage(start, pagesize);
		List<ConfigRuleGroup> configRuleGroups = configRuleGroupService.findAllConfigRuleGroup();
		PageInfo<ConfigRuleGroup> page = new PageInfo<ConfigRuleGroup>(configRuleGroups);

		return Ajax.tableDataOk(page.getTotal(), page.getList());
	}

	/**
	 * 保存抽取规则分组模式配置
	 * 
	 * @param configRuleGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AjaxReturn save(ConfigRuleGroup configRuleGroup) {
		AjaxReturn result = Ajax.fail().setMsg("保存失败！");
		if (null != configRuleGroup && configRuleGroupService.save(configRuleGroup) > 0) {
			result.setOk(true).setMsg("保存成功！");
		}
		return result;
	}
	
	/**
	 * 保存修改后的抽取规则分组模式配置
	 * 
	 * @param configRuleGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/usave", method = RequestMethod.POST)
	public AjaxReturn updateSave(ConfigRuleGroup configRuleGroup) {
		AjaxReturn result = Ajax.fail().setMsg("修改失败！");
		if (null != configRuleGroup && configRuleGroupService.modify(configRuleGroup) > 0) {
			result.setOk(true).setMsg("修改成功！");
		}
		return result;
	}
	

	/**
	 * 删除抽取规则分组模式配置
	 * 
	 * @param ids
	 *            抽取规则分组模式配置编号
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
		AjaxReturn result = Ajax.fail().setMsg("操作失败！");
		if (ids.length > 0 && configRuleGroupService.deleteByIds(ids) >0 ) {
			result.setOk(true).setMsg("删除成功");
		}
		return result;
	}
}
