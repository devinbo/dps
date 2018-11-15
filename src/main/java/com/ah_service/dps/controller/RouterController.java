package com.ah_service.dps.controller;

import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 路由控制器
 */
@RequestMapping("/")
@Controller
public class RouterController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private HttpSession session;

    @RequestMapping("index.html")
    public String index() {
        return "index";
    }

    /**
     * 工作台首页
     * @return
     */
    @RequestMapping("/content/index")
    public ModelAndView toIndex() {
        ModelAndView modelAndView = new ModelAndView();
        Doctor doctor = (Doctor) session.getAttribute("user");
        if(doctor.getIsadmin() != null) {
            //如果是超级管理员，那么加载超级管理员对应的统计信息
        }else if(doctor.getIshosadmin() != null) {
            //如果是医院管理员，那么加载医院管理员对应的统计信息
        }else{
            //普通医生，加载对应的问诊总数
            Map<String, Object> askState = patientService.getAskCount(doctor.getDocId());
            modelAndView.addObject("askState", askState);
            //加载最近5条留言信息
            List<Map<String, Object>> msgList = patientService.getLatestLeave();
            System.out.println(msgList);
            modelAndView.addObject("fordocMsgList", msgList);
        }
        modelAndView.setViewName("content/index");
        return modelAndView;
    }


    @RequestMapping("/content/{path}")
    public String toRouter(@PathVariable String path) {
        return "content/" + path;
    }
    /**
     * 加载二级页面
     * @return
     */
    @RequestMapping(value = "/content/{path1}/{path2}", method = RequestMethod.GET)
    public String toRouter(@PathVariable("path1") String path1, @PathVariable("path2") String path2) {
        System.out.println("........生成相应路径........");
        return "/content/" + path1 + "/" + path2;
    }

    /**
     * 进入到待回复页面，
     */
    @RequestMapping(value = "/content/reply/reply", method = RequestMethod.GET)
    public @ResponseBody ModelAndView toReply() {
        ModelAndView modelAndView = new ModelAndView();
        //查询回复总阅
        List<Map<String, Object>> list = patientService.getReplyAllView();
        Collections.reverse(list);
        modelAndView.addObject("view", list);
        return modelAndView;
    }

    /**
     * 退出系统
     */
    @RequestMapping("/loginOut")
    public void loginOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        session.removeAttribute("user");
        response.sendRedirect("login.html");
    }
}
