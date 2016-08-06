package com.codecrane.dbr.manageobj.service.impl;

import com.codecrane.core.power.entity.PowerGroup;
import com.codecrane.core.power.service.PowerGroupService;
import com.codecrane.dbr.manageobj.entity.Company;
import com.codecrane.dbr.manageobj.entity.CompanyManageConfig;
import com.codecrane.dbr.manageobj.entity.CompanyPoint;
import com.codecrane.dbr.manageobj.mapper.CompanyMapper;
import com.codecrane.dbr.manageobj.service.CompanyManageConfigService;
import com.codecrane.dbr.manageobj.service.CompanyPointService;
import com.codecrane.dbr.manageobj.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 企业单位基本信息 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1
 *          <br/>
 *          <br/>
 */
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyPointService companyPointService;

    @Autowired
    private CompanyManageConfigService companyManageConfigService;

    @Autowired
    private PowerGroupService powerGroupService;

    @Override
    @Transactional
    public int save(Company company) {
        int result = 0;
        if (null != company) {
            result = companyMapper.insert(company);

            if (result == 1) {

                //查询当前机构信息
                PowerGroup groupInfo = powerGroupService.findById(company.getGroupId().longValue());

                List<PowerGroup> groups = new ArrayList<>();
                if(groupInfo.getGroupType() == 1){//总队
                    //查询直属科室和大队
                    groups = powerGroupService.findByPid(groupInfo.getId());
                }else if(groupInfo.getGroupType() == 2 || groupInfo.getGroupType() == 4 ){//大队或总队下的科室
                    PowerGroup tempGroup = new PowerGroup();
                    tempGroup.setId(groupInfo.getGroupPid());
                    //上级总队
                    groups.add(tempGroup);
                }
                groups.add(groupInfo);

                //处理下级位点数据,并保存
                if (null != company.getCompanyPoints() && company.getCompanyPoints().size() > 0) {

                    List<CompanyPoint> companyPoints = new ArrayList<>();
                    for (CompanyPoint tempPoint : company.getCompanyPoints()) {
                        for (PowerGroup tempGroup : groups) {
                            CompanyPoint point = new CompanyPoint();
                            point.setCompanyId(company.getId());
                            point.setGroupId(tempGroup.getId().intValue());
                            point.setPointDesc(tempPoint.getPointDesc());
                            point.setPointName(tempPoint.getPointName());
                            point.setOrderId(tempPoint.getOrderId());
                            companyPoints.add(point);
                        }
                    }

                    companyPointService.saveBatch(companyPoints);
                }

                //处理管理模式数据,并保存
                List<CompanyManageConfig> manageConfigs = new ArrayList<>();
                for (PowerGroup tempGroup : groups) {
                    CompanyManageConfig tempManageConfig = new CompanyManageConfig();
                    tempManageConfig.setGroupId(tempGroup.getId().intValue());
                    tempManageConfig.setCompanyType(company.getType());
                    tempManageConfig.setCompanyId(company.getId());

                    manageConfigs.add(tempManageConfig);
                }

                //保存管理模式信息
                companyManageConfigService.saveBatch(manageConfigs);
            }

        }
        return result;
    }

    @Override
    public int saveBatch(List<Company> companys) {
        int result = 0;
        if (null != companys && companys.size() > 0) {
            result = companyMapper.insertBatch(companys);
        }
        return result;
    }

    @Override
    @Transactional
    public int importBatch(List<Company> companys) {
        int result = 0;

        if( null != companys && companys.size() >0  ){
            for (Company company:companys){
                save(company);
            }
        }

        return result;
    }

    @Override
    @Transactional
    public int modify(Company company) {
        int result = 0;
        if (null != company) {
            result = companyMapper.update(company);

            if (result == 1) {
                //删除原有下级位点
                companyPointService.deleteByGroupId(company.getGroupId());
                //新增下级位点
                if (null != company.getCompanyPoints() && company.getCompanyPoints().size() > 0) {
                    for (CompanyPoint point : company.getCompanyPoints()) {
                        point.setGroupId(company.getGroupId());
                        point.setCompanyId(company.getId());
                    }
                    companyPointService.saveBatch(company.getCompanyPoints());
                }

                //TODO 更新管理模式
                //TODO 判断机构类型 总队还是大队
            }

        }
        return result;
    }

    @Override
    public int delete(Integer companyId) {
        int result = 0;
        if (companyId > 0) {
            result = companyMapper.delete(companyId);
        }
        return result;
    }

    @Override
    public int deleteByIds(Integer[] companyIds) {
        int result = 0;
        if (companyIds.length > 0) {
            result = companyMapper.deleteByIds(companyIds);
        }
        return result;
    }

    @Override
    public Company findById(Integer companyId) {
        return companyMapper.queryByCompanyId(companyId);
    }

    @Override
    public Company findByCompanyAndGroupId(Integer companyId, Integer groupId) {
        return companyMapper.queryByCompanyAndGroupId(companyId, groupId);
    }

    @Override
    public List<Company> findAllCompany() {
        return companyMapper.queryAllCompany();
    }

    @Override
    public List<Company> findByCnd(Company company) {
        if (null != company) {
            return companyMapper.queryByCnd(company);
        } else {
            return null;
        }
    }

    @Override
    public List<Company> findByCndWithGroup(Company company) {
        if (null != company) {
            return companyMapper.queryByCndWithGroup(company);
        } else {
            return null;
        }
    }

    @Override
    public List<Company> findByCndWithGroupNoPoints(Company company) {
        if (null != company) {
            return companyMapper.queryByCndWithGroupNoPoints(company);
        } else {
            return null;
        }
    }
}