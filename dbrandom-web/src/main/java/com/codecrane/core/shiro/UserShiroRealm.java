package com.codecrane.core.shiro;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerPermission;
import com.codecrane.core.power.entity.PowerRole;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerPermissionService;
import com.codecrane.core.power.service.PowerRoleService;
import com.codecrane.core.power.service.PowerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Shiro的Realm实现
 * Created by crane on 16/3/9.
 */
@Slf4j
public class UserShiroRealm extends AuthorizingRealm {

    @Autowired
    private PowerPermissionService powerPermissionService;

    @Autowired
    private PowerRoleService powerRoleService;

    @Autowired
    private PowerUserService powerUserService;

    /**
     * 授权验证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = (String) principals.getPrimaryPrincipal();
        log.debug("查询用户授权信息");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (null != account) {
            PowerUser user = powerUserService.findByUserAccount(account);

            //角色集合
            List<PowerRole> roles = powerRoleService.findByUserId(user.getId());
            Set<String> roleSets = new HashSet<>();
            if (null != roles) {
                for (PowerRole role : roles) {
                    roleSets.add(String.valueOf(role.getId()));
                }
            }

            //权限集合
            List<PowerPermission> powerPermissions = powerPermissionService.findByUserId(user.getId(), -1);
            Set<String> permissionSets = new HashSet<>();
            if (null != powerPermissions) {
                for (PowerPermission permission : powerPermissions) {
                    permissionSets.add(permission.getPermissionCode());
                }
            }

            authorizationInfo.setRoles(roleSets);
            authorizationInfo.setStringPermissions(permissionSets);
        }

        return authorizationInfo;
    }

    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken credentials = (UsernamePasswordToken) authenticationToken;
        String account = credentials.getUsername();
        SimpleAuthenticationInfo authenticationInfo = null;
        PowerUser user = null;

        if (StringUtils.isNotBlank(account)) {
            user = powerUserService.findByUserAccount(account);
        }

        if (StringUtils.isNotBlank(account) && null != user) {

            if (1 == user.getLocked()) {//账号被锁定
                throw new LockedAccountException();
            }

            authenticationInfo = new SimpleAuthenticationInfo(account, user.getUserPassword(), ByteSource.Util.bytes(account + user.getUserSalt()), getName());

            // 当验证都通过后，把用户信息放在session里
            Session session = SecurityUtils.getSubject().getSession();

            // 用户对象
            session.setAttribute(Constants.CURRENT_USER_SESSION, user);
            // 用户ID
            session.setAttribute(Constants.CURRENT_USER_SESSIONID, user.getId());

            return authenticationInfo;
        } else {
            throw new UnknownAccountException("account not provided!");
        }
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
