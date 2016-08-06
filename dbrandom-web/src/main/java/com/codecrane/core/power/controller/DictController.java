package com.codecrane.core.power.controller;

import com.codecrane.core.power.entity.Dict;
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
 * 数据字典分类信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Controller
@RequestMapping("/dict/info")
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 数据字典分类信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String dictListPage(Model model) {
        return "/power/dictionary/dict/main";
    }

    /**
     * 新增数据字典分类信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addDictPage(Model model) {

        return "/power/dictionary/dict/add";
    }

    /**
     * 修改数据字典分类信息页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editDictPage(@RequestParam("id") Integer id, Model model) {

        // 根据ID查询数据字典分类信息
        Dict dict = dictService.findById(id);

        // 将数据字典分类信息返回到页面中
        model.addAttribute("dict", dict);

        return "/power/dictionary/dict/edit";
    }

    /**
     * 分页查询数据字典分类信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllDict(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                       @RequestParam(value = "offset", defaultValue = "0") int start) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<Dict> dicts = dictService.findAllDict();
        PageInfo<Dict> page = new PageInfo<Dict>(dicts);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存数据字典分类信息
     *
     * @param dict
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(Dict dict) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");
        if (null != dict && dictService.save(dict) > 0) {
            result.setOk(true).setMsg("保存成功！");
        }
        return result;
    }

    /**
     * 保存修改后的数据字典分类信息
     *
     * @param dict
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(Dict dict) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");
        if (null != dict && dictService.modify(dict) > 0) {
            result.setOk(true).setMsg("修改成功！");
        }
        return result;
    }


    /**
     * 删除数据字典分类信息
     *
     * @param ids 数据字典分类信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && dictService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }
}
