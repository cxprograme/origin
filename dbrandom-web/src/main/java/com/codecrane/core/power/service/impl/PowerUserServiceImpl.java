package com.codecrane.core.power.service.impl;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.entity.RelGroupUser;
import com.codecrane.core.power.mapper.PowerUserMapper;
import com.codecrane.core.power.service.PowerUserService;
import com.codecrane.core.util.CommonUtils;
import com.codecrane.core.util.EndecryptUtils;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户信息表 服务
 *
 * @author Crane(hehebaiy@gmail.com)
 * @version 0.1 <br/>
 *          <br/>
 */
@Service
public class PowerUserServiceImpl implements PowerUserService {

    @Autowired
    private PowerUserMapper powerUserMapper;

    @Override
    @Transactional
    public int save(PowerUser powerUser) {
        int result = 0;
        if (null != powerUser) {
            Map<String, String> entryMap = EndecryptUtils.md5Password(powerUser.getUserAccount(), powerUser.getUserPassword(), 2);
            // 设置密码盐
            powerUser.setUserSalt(entryMap.get("salt"));
            // 密码加密
            powerUser.setUserPassword(entryMap.get("password"));
            result = powerUserMapper.insert(powerUser);
            if (result > 0) {
                powerUserMapper.insertRelGroupUser(new RelGroupUser(powerUser.getGroupId(), powerUser.getId()));
            }
        }
        return result;
    }

    @Override
    public int saveBatch(List<PowerUser> powerUsers) {
        int result = 0;
        if (null != powerUsers && powerUsers.size() > 0) {
            for (PowerUser powerUser : powerUsers) {
                // 设置密码盐
                powerUser.setUserSalt(CommonUtils.randomStr(10));
                // 密码加密
                powerUser.setUserPassword(new Sha256Hash(powerUser.getUserPassword(), powerUser.getUserSalt(), 1024).toBase64());
            }
            result = powerUserMapper.insertBatch(powerUsers);
        }
        return result;
    }

    @Override
    public int modify(PowerUser powerUser) {
        int result = 0;
        if (null != powerUser) {
            if (StringUtils.isNotEmpty(powerUser.getUserPassword())) {
                Map<String, String> entryMap = EndecryptUtils.md5Password(powerUser.getUserAccount(), powerUser.getUserPassword(), 2);
                // 设置密码盐
                powerUser.setUserSalt(entryMap.get("salt"));
                // 密码加密
                powerUser.setUserPassword(entryMap.get("password"));
            }

            result = powerUserMapper.update(powerUser);
        }
        return result;
    }

    @Override
    public int delete(long powerUserId) {
        int result = 0;
        if (powerUserId > 0) {
            result = powerUserMapper.delete(powerUserId);
        }
        return result;
    }

    @Override
    public int deleteByIds(long[] powerUserIds) {
        int result = 0;
        if (powerUserIds.length > 0) {
            result = powerUserMapper.deleteByIds(powerUserIds);
        }
        return result;
    }

    @Override
    public PowerUser findById(long powerUserId) {
        return powerUserMapper.queryByPowerUserId(powerUserId);
    }

    @Override
    public List<PowerUser> findAllPowerUser() {
        return powerUserMapper.queryAllPowerUser();
    }

    @Override
    public int doLoginAuth(String userAccount, String userPassword, String vcode) {
        int authResult = 0;//账号、密码为空
        if (StringUtils.isNotBlank(userAccount) && StringUtils.isNotBlank(userPassword)) {

            //查询账号对应用户
            PowerUser user = findByUserAccount(userAccount);
            if (null != user) {
                //密码校验
                String etpwd = new Sha256Hash(userPassword, user.getUserSalt(), 1024).toBase64();
                if (StringUtils.equals(etpwd, user.getUserPassword())) {
                    authResult = 1;//登录成功
                } else {
                    authResult = -2;//密码错误
                }
            } else {
                authResult = -1;//账号不存在
            }
        }

        return authResult;
    }

    @Override
    public PowerUser findByUserAccount(String userAccount) {
        if (!Strings.isNullOrEmpty(userAccount)) {
            return powerUserMapper.queryByPowerUserAccount(userAccount);
        }
        return null;
    }


    @Override
    public List<PowerUser> findUsersByGroupId(long groupId) {
        return powerUserMapper.queryByGroupId(groupId);
    }

    @Override
    public List<PowerUser> finUsersByRoleId(long roleId) {
        return null;
    }

    @Override
    public List<PowerUser> findUsersByPermissionId(long permissionId) {
        return null;
    }

    @Override
    public List<PowerUser> findUsersByMenuId(long menuId) {
        return null;
    }

    @Override
    public void doLogout(long userId) {

    }

    @Override
    public int changePassword(String account, String oldPassword, String newPassword) {
        int result = 0;
        if (Strings.isNullOrEmpty(account) || Strings.isNullOrEmpty(oldPassword) || Strings.isNullOrEmpty(newPassword)) {
            result = -1;
        } else {
            PowerUser user = findByUserAccount(account);
            //验证旧密码
            if (EndecryptUtils.checkMd5Password(account, oldPassword, user.getUserSalt(), user.getUserPassword())) {
                PowerUser toChangePwdUser = new PowerUser();
                toChangePwdUser.setId(user.getId());
                toChangePwdUser.setUserAccount(account);
                toChangePwdUser.setUserPassword(newPassword);
                //修改密码
                result = modify(toChangePwdUser) > 0 ? 1 : 0;
            }
        }

        return result;
    }

    @Override
    public PowerUser getCurrentUserFromShiro() {
        return (PowerUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.CURRENT_USER_SESSION);
    }
}