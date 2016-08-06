package com.codecrane.dbr.manageobj.controller;

import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.dbr.manageobj.entity.CompanyPoint;
import com.codecrane.dbr.manageobj.service.CompanyPointService;
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
 * 企业监管点位信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/company/point/info")
public class CompanyPointController {

    @Autowired
    private CompanyPointService companyPointService;

    /**
     * 企业监管点位信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String companyPointListPage(Model model) {
        return "/companypoint/info/main";
    }

    /**
     * 新增企业监管点位信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addCompanyPointPage(Model model) {

        return "/companypoint/info/add";
    }

    /**
     * 修改企业监管点位信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editCompanyPointPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询企业监管点位信息
        CompanyPoint companyPoint = companyPointService.findById(id);

        // 将企业监管点位信息返回到页面中
        model.addAttribute("companyPoint", companyPoint);

        return "/companypoint/info/edit";
    }

    /**
     * 分页查询企业监管点位信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllCompanyPoint(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                               @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<CompanyPoint> companyPoints = companyPointService.findAllCompanyPoint();
        PageInfo<CompanyPoint> page = new PageInfo<CompanyPoint>(companyPoints);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 查询指定管理机构下指定企业的监管点位信息
     * @param companyId
     * @param groupId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbycompanyandgroup")
    public AjaxReturn findAllCompanyPoint(@RequestParam(value = "cid", defaultValue = "0") Integer companyId,
                                               @RequestParam(value = "gid", defaultValue = "0") Integer groupId) {
        AjaxReturn result = Ajax.fail().setMsg("没有查询到任何结果！");
        CompanyPoint point = new CompanyPoint();
        point.setCompanyId(companyId);
        point.setGroupId(groupId);

        List<CompanyPoint> companyPoints = companyPointService.findByCnd(point);

        if( null != companyPoints && companyPoints.size() >0 ){
            result.setOk(true).setData(companyPoints);
        }

        return result;
    }

    /**
     * 保存企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(CompanyPoint companyPoint) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != companyPoint && companyPointService.save(companyPoint) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的企业监管点位信息
     *
     * @param companyPoint
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(CompanyPoint companyPoint) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != companyPoint && companyPointService.modify(companyPoint) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除企业监管点位信息
     *
     * @param ids 企业监管点位信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && companyPointService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
