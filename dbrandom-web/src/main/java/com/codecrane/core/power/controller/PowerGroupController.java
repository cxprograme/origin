package com.codecrane.core.power.controller;

import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.core.power.service.PowerUserService;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.core.web.Ajax;
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
 * 组织机构信息 控制器
 * 
 * @author Crane(hehebaiy@gmail.com) 
 *  <br/>
 *  <br/>
 */
@Controller
@RequestMapping("/power/group")
public class PowerGroupController {
	
	@Autowired
	private PowerGroupService powerGroupService;

	@Autowired
	private PowerUserService powerUserService;
	
	/**
	 * 组织机构信息管理主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String powerGroupListPage(Model model) {
		
		model.addAttribute("groups", powerGroupService.findAllPowerGroup());
		return "/power/group/main";
	}

	/**
	 * 组织机构树选择框
	 * @param gid 选中机构编号
	 * @param isInLayer 是否在layer弹出框中弹出,默认是
	 * @param groupIdInputId 确定后回写的机构编号input对应id
	 * @param groupNameInputId 确定后回写的机构名称input对应id
	 * @param limitRange 限制可选范围 默认不限制
	 * @param model
     * @return
     */
	@RequestMapping("/selecttree")
	public String powerSelectGroupTreePage(@RequestParam(value="gid",defaultValue="0")Long gid,
										   @RequestParam(value = "mt",defaultValue = "y") String isInLayer,
										   @RequestParam(value = "groupIdInput",defaultValue = "groupPid") String groupIdInputId,
										   @RequestParam(value = "groupNameInput",defaultValue = "groupPname") String groupNameInputId,
										   @RequestParam(value = "blimit",defaultValue = "n")String limitRange,
										   Model model){

		List<PowerGroup> groups = null;

		if("n".equalsIgnoreCase(limitRange)){
			groups = powerGroupService.findAllPowerGroup();
		}else{
			PowerUser user = powerUserService.getCurrentUserFromShiro();
			if( null != user ){
				PowerGroup powerGroup = new PowerGroup();
				powerGroup.setId(user.getGroupId());
				groups = powerGroupService.findAllChildGroup(powerGroup);
			}
		}

		model.addAttribute("groups", groups);
		//当前已选机构编号
		model.addAttribute("gid",gid);
		//返回的机构编号input对应ID
		model.addAttribute("groupIdInputId",groupIdInputId);
		//返回的机构名称input对应ID
		model.addAttribute("groupNameInputId",groupNameInputId);
		model.addAttribute("inlayer",isInLayer);

		return "/power/group/select_grouptree";
	}

	/**
	 * 新增组织机构信息页面
	 * @param pid 当前选择的组织机构编号
	 * @param model
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addPowerGroupPage(@RequestParam(value="pid",defaultValue="0")long pid,Model model) {

		model.addAttribute("pid", pid);
		model.addAttribute("parentGroup",powerGroupService.findById(pid));
		
		return "/power/group/add";
	}

	/**
	 * 修改组织机构信息页面
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping("/editpage")
	public String editPowerGroupPage(@RequestParam("id") long id, Model model) {

		// 根据ID查询组织机构信息
		PowerGroup powerGroup = powerGroupService.findById(id);

		// 将组织机构信息返回到页面中
		model.addAttribute("powergroup", powerGroup);

		return "/power/group/edit";
	}
	
	/**
	 * 分页查询组织机构信息
	 * @param pagesize
	 * @param start
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findall")
	public AjaxTableReturn findAllPowerGroup(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
											 @RequestParam(value = "offset", defaultValue = "0") int start) {
		start = start > 0 ? start / pagesize + 1 : 1;
		PageHelper.startPage(start, pagesize);
		List<PowerGroup> powerGroups = powerGroupService.findAllPowerGroup();
		PageInfo<PowerGroup> page = new PageInfo<PowerGroup>(powerGroups);

		return Ajax.tableDataOk(page.getTotal(), page.getList());
	}
	
	/**
	 * 分页查询指定组织机构下级机构信息
	 * @param pid 上级机构编号
	 * @param pagesize
	 * @param start
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findbypid")
	public AjaxTableReturn findByPid(@RequestParam("pid")long pid,@RequestParam(value = "limit", defaultValue = "10") int pagesize,
			@RequestParam(value = "offset", defaultValue = "0") int start) {
		start = start > 0 ? start / pagesize + 1 : 1;
		PageHelper.startPage(start, pagesize);
		List<PowerGroup> powerGroups = powerGroupService.findByPid(pid);
		PageInfo<PowerGroup> page = new PageInfo<PowerGroup>(powerGroups);
		
		return Ajax.tableDataOk(page.getTotal(), page.getList());
	}

	/**
	 * 保存组织机构信息
	 * 
	 * @param powerGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AjaxReturn save(PowerGroup powerGroup) {
		AjaxReturn result = Ajax.fail().setMsg("保存失败！");
		if (null != powerGroup && powerGroupService.save(powerGroup) > 0) {
			result.setOk(true).setMsg("保存成功！").setData(powerGroup);
		}
		return result;
	}
	
	/**
	 * 保存修改后的组织机构信息
	 * 
	 * @param powerGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/usave", method = RequestMethod.POST)
	public AjaxReturn updateSave(PowerGroup powerGroup) {
		AjaxReturn result = Ajax.fail().setMsg("修改失败！");
		if (null != powerGroup && powerGroupService.modify(powerGroup) > 0) {
			result.setOk(true).setMsg("修改成功！");
		}
		return result;
	}
	

	/**
	 * 删除组织机构信息
	 * 
	 * @param ids
	 *            组织机构信息编号
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public AjaxReturn deleteByIds(@RequestParam("ids") long[] ids) {
		AjaxReturn result = Ajax.fail().setMsg("操作失败！");
		if (ids.length > 0 && powerGroupService.deleteByIds(ids) >0 ) {
			result.setOk(true).setMsg("删除成功");
		}
		return result;
	}
}
