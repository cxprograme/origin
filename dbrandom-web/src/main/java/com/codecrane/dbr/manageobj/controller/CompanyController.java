package com.codecrane.dbr.manageobj.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.DictDetail;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.DictDetailService;
import com.codecrane.core.util.ExcelReader;
import com.codecrane.core.util.ExcelWriter;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import com.codecrane.core.web.AjaxTableReturn;
import com.codecrane.core.web.RequestUtils;
import com.codecrane.dbr.manageobj.entity.Company;
import com.codecrane.dbr.manageobj.entity.CompanyPoint;
import com.codecrane.dbr.manageobj.service.CompanyPointService;
import com.codecrane.dbr.manageobj.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业单位基本信息 控制器
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/company/info")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyPointService companyPointService;

    @Autowired
    private DictDetailService dictDetailService;

    /**
     * 企业单位基本信息管理主页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String companyListPage(Model model) {

        //获取当前用户的管理机构编号
        Subject subject = SecurityUtils.getSubject();
        PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);
        if (null != user) {
            model.addAttribute("groupId", user.getGroupId());
        }

        return "/dbr/manageobj/company/main";
    }

    /**
     * 新增企业单位基本信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/addpage")
    public String addCompanyPage(Model model) {

        return "/dbr/manageobj/company/add";
    }

    /**
     * 修改企业单位基本信息页面
     *
     * @param companyId
     * @param groupId
     * @param model
     * @return
     */
    @RequestMapping("/editpage")
    public String editCompanyPage(@RequestParam("id") Integer companyId, @RequestParam("gid") Integer groupId, Model model) {

        // 根据ID查询企业单位基本信息
        Company company = companyService.findByCompanyAndGroupId(companyId, groupId);

        // 将企业单位基本信息返回到页面中
        model.addAttribute("company", company);

        //下级位点
        CompanyPoint companyPoint = new CompanyPoint();
        companyPoint.setCompanyId(companyId);
        companyPoint.setGroupId(groupId);
        model.addAttribute("points", companyPointService.findByCnd(companyPoint));

        return "/dbr/manageobj/company/edit";
    }

    /**
     * 导入企业
     *
     * @return
     */
    @RequestMapping(value = "/importpage", method = RequestMethod.GET)
    public String importCompanyPage() {
        return "/dbr/manageobj/company/import";
    }

    /**
     * 分页查询企业单位基本信息
     *
     * @param pagesize
     * @param start
     * @return
     */
    @ResponseBody
    @RequestMapping("/findall")
    public AjaxTableReturn findAllCompany(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                          @RequestParam(value = "offset", defaultValue = "0") int start, Company company) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<Company> companys = companyService.findByCndWithGroup(company);
        PageInfo<Company> page = new PageInfo<Company>(companys);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 查询当前机构及子机构下的管理对象
     *
     * @param pagesize
     * @param start
     * @param groupId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findbygid")
    public AjaxTableReturn findAllByGroupId(@RequestParam(value = "limit", defaultValue = "10") int pagesize,
                                            @RequestParam(value = "offset", defaultValue = "0") int start, @RequestParam(value = "gid", defaultValue = "0") long groupId) {
        start = start > 0 ? start / pagesize + 1 : 1;
        PageHelper.startPage(start, pagesize);
        List<Company> companys = companyService.findAllCompany();
        PageInfo<Company> page = new PageInfo<Company>(companys);

        return Ajax.tableDataOk(page.getTotal(), page.getList());
    }

    /**
     * 保存企业单位基本信息
     *
     * @param company
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public AjaxReturn save(Company company) {
        AjaxReturn result = Ajax.fail().setMsg("保存失败！");

        //下级位点数据处理
        if (null != company) {

            if (null != company.getCompanyPoints()) {
                List<CompanyPoint> points = new ArrayList<>();
                for (CompanyPoint point : company.getCompanyPoints()) {
                    if (null != point.getPointName()) {
                        points.add(point);
                    }
                }
                company.setCompanyPoints(points);
            }

            if (companyService.save(company) > 0) {
                result.setOk(true).setMsg("保存成功！");
            }
        }

        return result;
    }

    /**
     * 保存修改后的企业单位基本信息
     *
     * @param company
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/usave", method = RequestMethod.POST)
    public AjaxReturn updateSave(Company company) {
        AjaxReturn result = Ajax.fail().setMsg("修改失败！");

        if (null != company) {
            if (null != company.getCompanyPoints()) {
                List<CompanyPoint> points = new ArrayList<>();
                for (CompanyPoint point : company.getCompanyPoints()) {
                    if (null != point.getPointName()) {
                        points.add(point);
                    }
                }
                company.setCompanyPoints(points);
            }

            if (companyService.modify(company) > 0) {
                result.setOk(true).setMsg("修改成功！");
            }

        }
        return result;
    }


    /**
     * 删除企业单位基本信息
     *
     * @param ids 企业单位基本信息编号
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public AjaxReturn deleteByIds(@RequestParam("ids") Integer ids[]) {
        AjaxReturn result = Ajax.fail().setMsg("操作失败！");
        if (ids.length > 0 && companyService.deleteByIds(ids) > 0) {
            result.setOk(true).setMsg("删除成功");
        }
        return result;
    }

    /**
     * 导入企业
     *
     * @param uploadFile
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public AjaxReturn uploadAttachFile(@RequestParam("companyfile") MultipartFile uploadFile) {
        AjaxReturn result = Ajax.fail();
        if (!uploadFile.isEmpty()) {

            String fileSuffix = FilenameUtils.getExtension(uploadFile.getOriginalFilename());

            if (fileSuffix.equals("xls") || fileSuffix.equals("xlsx")) {

                boolean isImportOk = false;

                //解析文件
                try {
                    FileInputStream fis = (FileInputStream) uploadFile.getInputStream();
                    List<Map<String, String>> excelData = ExcelReader.read(fis, fileSuffix);

                    log.debug("company info list:{}", excelData);

                    List<DictDetail> companyTradeDict = dictDetailService.findByTypeCode("company_trade");

                    //当前用户信息
                    Subject subject = SecurityUtils.getSubject();
                    PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);

                    if (null != excelData && excelData.size() > 0) {

                        //解析列含义
                        Map<String, String> header = excelData.get(1);
                        Map<String, String> headerMap = new HashMap<>();
                        for (String key : header.keySet()) {
                            headerMap.put(header.get(key), key);
                        }

                        log.debug("header map:{}", headerMap);

                        //解析数据行
                        List<Company> companyList = new ArrayList<>();
                        for (int i = 2, l = excelData.size(); i < l; i++) {
                            Map<String, String> currentCompany = excelData.get(i);
                            log.debug("当前行数据:{}", currentCompany);
                            Company company = new Company();
                            company.setName(currentCompany.get(headerMap.get("name")));
                            company.setAddress(currentCompany.get(headerMap.get("address")));
                            company.setEvManager(currentCompany.get(headerMap.get("evManager")));
                            company.setMobile(currentCompany.get(headerMap.get("mobile")));
                            company.setType("重点".equals(currentCompany.get(headerMap.get("type"))) ? 1 : 0);

                            String tradeCode = "";
                            String tradeName = currentCompany.get(headerMap.get("trade"));
                            for (DictDetail dictDetail : companyTradeDict) {
                                if (dictDetail.getDetailName().equals(tradeName)) {
                                    tradeCode = dictDetail.getDetailCode();
                                }
                            }
                            company.setTrade(tradeCode);
                            company.setPhone(currentCompany.get(headerMap.get("phone")));
                            company.setGroupId(user.getGroupId().intValue());

                            companyList.add(company);
                        }
                        log.debug("company list:{}", companyList);

                        isImportOk = companyService.importBatch(companyList) > 0;

                    }

                } catch (IOException e) {
                    log.error("上传的文件异常:{}", e.toString());
                    e.printStackTrace();
                } catch (Exception e) {
                    log.error("文件解析异常:{}", e.toString());
                    e.printStackTrace();
                }

                result.setOk(isImportOk);
            } else {
                result.setMsg("文件格式错误");
            }

        } else {
            result.setMsg("文件不能为空");
        }
        return result;
    }


    /**
     * 导出企业
     *
     * @param request
     * @param response
     * @param company
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/export")
    public void downFile(HttpServletRequest request, HttpServletResponse response, Company company) throws IOException {

        String path = request.getSession().getServletContext().getRealPath("/export");


        List<Company> companys = companyService.findByCndWithGroupNoPoints(company);

        ExcelWriter excelWriter = new ExcelWriter(ExcelWriter.ExcelType.XLS);
        excelWriter.createRow();
        excelWriter.setCell(0, "企业名称");
        excelWriter.setCell(1, "地址");
        excelWriter.setCell(2, "环保负责人");
        excelWriter.setCell(3, "手机");
        excelWriter.setCell(4, "对象类型");
        excelWriter.setCell(5, "分类属性");
        excelWriter.setCell(6, "固定电话");
        excelWriter.setCell(7, "管理机构");

        List<DictDetail> companyTradeDict = dictDetailService.findByTypeCode("company_trade");
        if (null != companys && companys.size() > 0) {
            for (Company currentCompany : companys) {
                excelWriter.createRow();
                excelWriter.setCell(0, currentCompany.getName());
                excelWriter.setCell(1, currentCompany.getAddress());
                excelWriter.setCell(2, currentCompany.getEvManager());
                excelWriter.setCell(3, currentCompany.getMobile());
                excelWriter.setCell(4, currentCompany.getType() == 1 ? "重点" : "一般");

                String tradeName = "";
                for (DictDetail dictData : companyTradeDict) {
                    if (dictData.getDetailCode().equals(currentCompany.getTrade())) {
                        tradeName = dictData.getDetailName();
                    }
                }

                excelWriter.setCell(5, tradeName);
                excelWriter.setCell(6, currentCompany.getPhone());
                excelWriter.setCell(7, currentCompany.getGroupName());
            }
        }

        String tempFileName = SystemUtils.FILE_SEPARATOR + System.currentTimeMillis() + ".xls";
        excelWriter.export(path + tempFileName);

        //默认文件名称
        String downFileName = "导出企业Excel.xls";

        File file = new File(path + tempFileName);

        if (!file.exists()) {
            String errorMessage = "抱歉,文件不存在!";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
        if (RequestUtils.isIE(request)) {//IE文件名特殊处理
            downFileName = URLEncoder.encode(downFileName, "UTF8");
        } else {
            downFileName = new String(downFileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("content-disposition", "attachment;filename=" + downFileName);
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }
}
