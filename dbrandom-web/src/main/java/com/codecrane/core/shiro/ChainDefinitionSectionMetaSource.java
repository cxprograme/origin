package com.codecrane.core.shiro;

import com.codecrane.core.power.entity.PowerMenu;
import com.codecrane.core.power.service.PowerMenuService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;

import javax.inject.Inject;
import java.util.List;

/**
 * 自定义加载请求地址权限关系
 * Created by crane on 16/3/9.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    @Inject
    private PowerMenuService powerMenuService;

    /*
     * 静态资源访问权限
     */
    private String filterChainDefinitions = null;

    /*
     * 默认premission字符串
     */
    public static final String PREMISSION_STRING = "perms[%s]";

    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        // 加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        List<PowerMenu> menus = powerMenuService.findAllPowerMenu();
        if (null != menus && menus.size() > 0) {
            for (PowerMenu menu : menus) {
                if (StringUtils.isNoneBlank(menu.getMenuUrl())
                        && StringUtils.isNoneBlank(menu.getMenuCode())
                        && null != menu.getPowerPermission()
                        && StringUtils.isNoneBlank(menu.getPowerPermission().getPermissionCode())) {
                    section.put(menu.getMenuUrl(), String.format(PREMISSION_STRING, menu.getPowerPermission().getPermissionCode()));
                }
            }
        }
        // 所有资源的访问权限，必须放在最后
        section.put("/**", "authc,kickout,sysUser,user");

        return section;
    }

    /**
     * 通过filterChainDefinitions 对默认的url过滤定义
     *
     * @param filterChainDefinitions 默认的url过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public Class<?> getObjectType() {
        return this.getClass();
    }

    public boolean isSingleton() {
        return false;
    }
}
