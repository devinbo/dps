package com.ah_service.dps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 路由控制器
 */
@RequestMapping("/")
@Controller
public class RouterController {

    @RequestMapping("index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/content/{path}")
    public String toRouter(@PathVariable String path) {
        return "content/" + path;
    }

    @RequestMapping(value = "/content/{path1}/{path2}", method = RequestMethod.GET)
    public String toRouter(@PathVariable("path1") String path1, @PathVariable("path2") String path2) {
        System.out.println("........生成相应路径........");
        return "/content/" + path1 + "/" + path2;
    }

    /**
     * 退出系统
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
}
