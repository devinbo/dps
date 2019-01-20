package com.ah_service.dps.controller;

import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * 获取当前未读留言信息
     * @return
     */
    @RequestMapping("/getFordocMsg")
    public @ResponseBody ResultPage<WjwFordocMsg> getFordocMsg(Page page, WjwFordocMsg wjwFordocMsg) {
        System.out.println(page);
        return patientService.getFordocMsg(page, wjwFordocMsg);
    }

    @RequestMapping("/getLastProblem")
    public @ResponseBody Result getLastProblem(String msgId) {
        return patientService.getLastProblem(msgId);
    }

    /**
     * 医生回复
     */
    @RequestMapping("/addReply")
    public @ResponseBody Result addReply(WjwRepFordocMsg wjwRepFordocMsg) {
        return patientService.addReply(wjwRepFordocMsg);
    }
}
