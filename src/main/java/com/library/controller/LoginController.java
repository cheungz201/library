package com.library.controller;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;
import com.library.service.LoginService;
import com.library.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


/**
 * @author Zhang Zhe
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = {"/", "/login.html"})
    public String toLogin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/logout.html")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.html";
    }


    /**
     * 负责处理loginCheck.html请求
     * 请求参数会根据参数名称默认契约自动绑定到相应方法的入参中
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/loginCheck", method = RequestMethod.POST)
    public @ResponseBody
    Object loginCheck(HttpServletRequest request,Long id,String passwd) {
        Admin admin = loginService.getAdmin(id, passwd);
        boolean isReader = loginService.hasMatchReader(id, passwd);
        HashMap<String, String> res = new HashMap<String, String>();
        if (admin != null) {
            request.getSession().setAttribute(Constant.admin, admin);
            res.put("stateCode", "1");
            res.put("msg", "管理员登陆成功！");
            return res;
        } else if (isReader) {
            ReaderCard readerCard = loginService.findReaderCardByReaderId(id);
            request.getSession().setAttribute(Constant.readr, readerCard);
            res.put("stateCode", "2");
            res.put("msg", "读者登陆成功！");
            return res;
        } else {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
        }
        return res;
    }

    @RequestMapping("/admin_main.html")
    public ModelAndView toAdminMain() {
        return new ModelAndView("admin_main");
    }

    @RequestMapping("/reader_main.html")
    public ModelAndView toReaderMain() {
        return new ModelAndView("reader_main");
    }

    @RequestMapping("/admin_repasswd.html")
    public ModelAndView reAdminPasswd() {
        return new ModelAndView("admin_repasswd");
    }

    @RequestMapping("/admin_repasswd_do")
    public String reAdminPasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, RedirectAttributes redirectAttributes) {
        Admin admin = (Admin) request.getSession().getAttribute(Constant.admin);
        long id = admin.getAdminId();
        String password = loginService.getAdminPassword(id);
        if (password.equals(oldPasswd)) {
            if (loginService.adminRePassword(id, newPasswd)) {
                redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
            } else {
                redirectAttributes.addFlashAttribute("error", "密码修改失败！");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "旧密码错误！");
        }
        return "redirect:/admin_repasswd.html";

    }

    @RequestMapping("/reader_repasswd.html")
    public ModelAndView reReaderPasswd() {
        return new ModelAndView("reader_repasswd");
    }

    @RequestMapping("/reader_repasswd_do")
    public String reReaderPasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, RedirectAttributes redirectAttributes) {
        ReaderCard reader = (ReaderCard) request.getSession().getAttribute(Constant.readr);
        long id = reader.getReaderId();
        String password = loginService.getReaderPassword(id);
        if (password.equals(oldPasswd)) {
            if (loginService.readerRePassword(id, newPasswd)) {
                redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
            } else {
                redirectAttributes.addFlashAttribute("error", "密码修改失败！");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "旧密码错误！");
        }
        return "redirect:/reader_repasswd.html";
    }

    //配置404页面
    @RequestMapping("*")
    public String notFind() {
        return "404";
    }

}