package com.ah_service.dps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

//
//    @RequestMapping("/login")
//    public String toLogin() {
//        return "login";
//    }

    @RequestMapping("/content/{path}.html")
    public String toRouter(@PathVariable String path) {
        return "/content/" + path;
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
