package com.codecrane.dbr.rule.controller;

import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.rule.entity.ConfigRuleType;
import com.codecrane.dbr.rule.service.ConfigRuleTypeService;
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
 * 抽取规则分类比重配置 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/configruletype/info")
public class ConfigRuleTypeController {

    @Autowired
    private ConfigRuleTypeService configRuleTypeService;

    /**
     * 抽取规则分类比重配置管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String configRuleTypeListPage(Model model) {
        return "/configruletype/info/main";
    }

    /**
     * 新增抽取规则分类比重配置页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addConfigRuleTypePage(Model model) {

        return "/configruletype/info/add";
    }

    /**
     * 修改抽取规则分类比重配置页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editConfigRuleTypePage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询抽取规则分类比重配置
        ConfigRuleType configRuleType = configRuleTypeService.findById(id);

        // 将抽取规则分类比重配置返回到页面中
        model.addAttribute("configRuleType", configRuleType);

        return "/configruletype/info/edit";
    }

    /**
     * 分页查询抽取规则分类比重配置
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllConfigRuleType(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                 @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<ConfigRuleType> configRuleTypes = configRuleTypeService.findAllConfigRuleType();
        PageInfo<ConfigRuleType> page = new PageInfo<ConfigRuleType>(configRuleTypes);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存抽取规则分类比重配置
     *
     * @param configRuleType
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(ConfigRuleType configRuleType) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != configRuleType && configRuleTypeService.save(configRuleType) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的抽取规则分类比重配置
     *
     * @param configRuleType
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(ConfigRuleType configRuleType) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != configRuleType && configRuleTypeService.modify(configRuleType) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除抽取规则分类比重配置
     *
     * @param ids 抽取规则分类比重配置编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && configRuleTypeService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
