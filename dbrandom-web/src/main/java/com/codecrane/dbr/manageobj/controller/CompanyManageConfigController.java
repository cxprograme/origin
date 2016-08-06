package com.codecrane.dbr.manageobj.controller;

import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.manageobj.entity.CompanyManageConfig;
import com.codecrane.dbr.manageobj.service.CompanyManageConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 企业管理模式信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/company/manageconfig/info")
public class CompanyManageConfigController {

    @Autowired
    private CompanyManageConfigService companyManageConfigService;


    /**
     * 新增企业管理模式信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addCompanyManageConfigPage(Model model) {

        return "/companymanageconfig/info/add";
    }

    /**
     * 修改企业管理模式信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editCompanyManageConfigPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询企业管理模式信息
        CompanyManageConfig companyManageConfig = companyManageConfigService.findById(id);

        // 将企业管理模式信息返回到页面中
        model.addAttribute("companyManageConfig", companyManageConfig);

        return "/dbr/manageobj/company/manage_config_edit";
    }

    /**
     * 修改企业管理模式信息页面
     *
     * @param cid   企业编号
     * @param gid   管理机构编号
     * @param model
     * @return
     */
    @RequestMapping("/editpagebycompanyandgroup")
    public String editPageByCompanyAndGroup(@RequestParam("cid") Integer cid, @RequestParam("gid") Integer gid, Model model) {

        // 根据ID查询企业管理模式信息
        CompanyManageConfig companyManageConfig = companyManageConfigService.findByCompanyAndGroupId(cid, gid);

        // 将企业管理模式信息返回到页面中
        model.addAttribute("companyManageConfig", companyManageConfig);

        return "/dbr/manageobj/company/manage_config_edit";
    }

    /**
     * 分页查询企业管理模式信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllCompanyManageConfig(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                                      @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<CompanyManageConfig> companyManageConfigs = companyManageConfigService.findAllCompanyManageConfig();
        PageInfo<CompanyManageConfig> page = new PageInfo<CompanyManageConfig>(companyManageConfigs);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 查询指定管理机构下指定类型企业数量
     *
     * @param groupId
     * @param companyType
     * @return
     */
    @ResponseBody
    @RequestMapping("/countbygroupidandtype")
    public AjaxReturn findByGroupIdAndType(@RequestParam(value = "gid", defaultValue = "-1") int groupId,
                                           @RequestParam(value = "type", defaultValue = "0") int companyType) {

        CompanyManageConfig config = new CompanyManageConfig();
        config.setGroupId(groupId);
        config.setCompanyType(companyType);

        PageHelper.startPage(0, 0);
        List<CompanyManageConfig> companyManageConfigs = companyManageConfigService.findByCnd(config);
        PageInfo<CompanyManageConfig> page = new PageInfo<CompanyManageConfig>(companyManageConfigs);

        return new AjaxReturn().setOk(null != companyManageConfigs).setData(page.getTotal());
    }

    /**
     * 保存企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(CompanyManageConfig companyManageConfig) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != companyManageConfig && companyManageConfigService.save(companyManageConfig) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的企业管理模式信息
     *
     * @param companyManageConfig
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(CompanyManageConfig companyManageConfig) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        log.debug("companyManageConfig:{}", companyManageConfig);
        if (null != companyManageConfig && companyManageConfigService.modify(companyManageConfig) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }

}
