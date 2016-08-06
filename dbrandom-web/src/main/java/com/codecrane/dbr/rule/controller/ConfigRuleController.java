package com.codecrane.dbr.rule.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.dbr.rule.entity.ConfigRuleGroup;
import com.codecrane.dbr.rule.entity.ConfigRuleType;
import com.codecrane.dbr.rule.service.ConfigRuleGroupService;
import com.codecrane.dbr.rule.service.ConfigRuleService;
import com.codecrane.dbr.rule.service.ConfigRuleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 抽取规则分组模式配置 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/config/rule")
public class ConfigRuleController {

    @Autowired
    private ConfigRuleGroupService configRuleGroupService;

    @Autowired
    private ConfigRuleTypeService configRuleTypeService;

    @Autowired
    private ConfigRuleService configRuleService;

    /**
     * 抽取规则分组模式配置管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String configRuleGroupListPage(Model model) {

        //获取当前用户的管理机构编号
        Subject subject = SecurityUtils.getSubject();
        PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);

        if (null != user) {
            model.addAttribute("groupId", user.getGroupId());

            ConfigRuleGroup configRuleGroup = configRuleGroupService.findByGroupId(user.getGroupId().intValue());
            List<ConfigRuleType> configRuleTypes = configRuleTypeService.findByGroupId(user.getGroupId().intValue());

            //新增标志
            model.addAttribute("isAdd", null == configRuleGroup || null == configRuleTypes || configRuleTypes.size() == 0);

            //查询当前机构分组模式设置
            model.addAttribute("ruleGroup", configRuleGroup);
            //查询当前机构的分类属性比重设置
            model.addAttribute("ruleType", configRuleTypes);
        }

        return "/dbr/rule/config";
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

        if (null != configRuleGroup && configRuleService.saveRuleConfig(configRuleGroup, configRuleGroup.getConfigRuleTypes())) {
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
        if (null != configRuleGroup && configRuleService.modifyRuleConfig(configRuleGroup, configRuleGroup.getConfigRuleTypes())) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }

}
