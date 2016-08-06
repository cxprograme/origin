package com.codecrane.core.shiro.filter;

import com.codecrane.core.Constants;
import com.codecrane.core.power.service.PowerUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 系统用户预处理
 */
public class SysUserFilter extends PathMatchingFilter {

    @Inject
    private PowerUserService powerUserService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String userAccount = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, powerUserService.findByUserAccount(userAccount));
        return true;
    }
}
