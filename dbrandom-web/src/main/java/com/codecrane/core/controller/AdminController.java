package com.codecrane.core.controller;

import com.codecrane.core.Constants;
import com.codecrane.core.power.entity.PowerMenu;
import com.codecrane.core.power.entity.PowerUser;
import com.codecrane.core.power.service.PowerMenuService;
import com.codecrane.core.web.Ajax;
import com.codecrane.core.web.AjaxReturn;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台管理主控制器
 *
 * @author Crane(hehebaiy@gmail.com) <br/>
 *         <br/>
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PowerMenuService powerMenuService;

    /**
     * 用户登录页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, HttpServletRequest request) {

        //获取来源链接地址
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        if (null != savedRequest) {
            model.addAttribute("backUrl", savedRequest.getRequestUrl());
        }

        //已经登录自动跳转
        String path = "/power/login";
        if (SecurityUtils.getSubject().isAuthenticated()) {
            log.error("已经登录过了,自定跳转...");
            path = "redirect:/admin/index";
        }

        return path;
    }

    /**
     * 管理员登录
     *
     * @param account
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxReturn login(@RequestParam("ac") String account, @RequestParam("pwd") String password) {

        AjaxReturn result = Ajax.fail().setMsg("登录异常");

        UsernamePasswordToken token = null;
        try {
            // 想要得到Subject对象,访问地址必须在shiro的拦截地址内,不然会报空指针
            Subject subject = SecurityUtils.getSubject();
            token = new UsernamePasswordToken(account, password);
            subject.login(token);
            if (subject.isAuthenticated()) {
                result.setOk(true).setMsg("登录成功,即将跳转...");
            } else {
                result.setMsg("用户名或密码不正确");
            }
        } catch (LockedAccountException e) {
            result.setMsg("用户已经被锁定不能登录，请与管理员联系！");
        } catch (ExcessiveAttemptsException e) {
            result.setMsg("登录失败次数过多,锁定10分钟!");
        } catch (AuthenticationException e) {
            result.setMsg("用户名或密码不正确!");
        } catch (Exception e) {
            result.setMsg("登录异常，请联系管理员！");
        }
        return result;
    }


    /**
     * 用户登出
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();

        if (null != subject && subject.isAuthenticated()) {
            subject.logout();
        }

        return "/power/login";
    }


    /**
     * 主页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index","/"})
    public String indexPage(Model model) {

        Subject subject = SecurityUtils.getSubject();

        PowerUser user = (PowerUser) subject.getSession().getAttribute(Constants.CURRENT_USER_SESSION);

        if (null != user) {
            List<PowerMenu> menus = powerMenuService.findByUserId(user.getId());
            model.addAttribute("menus", menus);
            model.addAttribute("user", user);
        }

        return "/power/index";
    }

}
