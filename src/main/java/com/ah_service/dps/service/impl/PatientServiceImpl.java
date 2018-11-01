package com.ah_service.dps.service.impl;

import com.ah_service.dps.dao.PatientDao;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.PatientService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private HttpSession session;

    @Override
    public ResultPage<WjwFordocMsg> getFordocMsg(Page page, WjwFordocMsg wjwFordocMsg) {
        PageHelper.startPage(page);
        List<WjwFordocMsg> list = patientDao.getFordocMsg(wjwFordocMsg);
        return new ResultPage<>(list);
    }

    @Override
    public Result sendMsg(WjwRepFordocMsg wjwRepFordocMsg) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        wjwRepFordocMsg.setMsgDocuserId(doctor.getDocId());
        patientDao.sendMsg(wjwRepFordocMsg);
        return new Result();
    }
}
