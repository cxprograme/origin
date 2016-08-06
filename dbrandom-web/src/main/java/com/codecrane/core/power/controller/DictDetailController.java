package com.codecrane.core.power.controller;

import com.codecrane.core.power.entity.DictDetail;
import com.codecrane.core.power.service.DictDetailService;
import com.codecrane.core.power.service.DictService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
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
 * 数据字典详情信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/dictdetail/info")
public class DictDetailController {

    @Autowired
    private DictService dictService;

    @Autowired
    private DictDetailService dictDetailService;

    /**
     * 数据字典详情信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String dictDetailListPage(Model model) {
        return "/power/dictionary/dict_detail/main";
    }

    /**
     * 新增数据字典详情信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addDictDetailPage(Model model) {

        model.addAttribute("dictTypes",dictService.findAllDict());

        return "/power/dictionary/dict_detail/add";
    }

    /**
     * 修改数据字典详情信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editDictDetailPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询数据字典详情信息
        DictDetail dictDetail = dictDetailService.findById(id);

        // 将数据字典详情信息返回到页面中
        model.addAttribute("dictDetail", dictDetail);
        model.addAttribute("dictTypes",dictService.findAllDict());

        return "/power/dictionary/dict_detail/edit";
    }

    /**
     * 分页查询数据字典详情信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllDictDetail(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                             @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<DictDetail> dictDetails = dictDetailService.findAllDictDetail();
        PageInfo<DictDetail> page = new PageInfo<DictDetail>(dictDetails);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(DictDetail dictDetail) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != dictDetail && dictDetailService.save(dictDetail) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的数据字典详情信息
     *
     * @param dictDetail
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(DictDetail dictDetail) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != dictDetail && dictDetailService.modify(dictDetail) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除数据字典详情信息
     *
     * @param ids 数据字典详情信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && dictDetailService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
