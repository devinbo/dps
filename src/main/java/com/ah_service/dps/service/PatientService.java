package com.ah_service.dps.service;

import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;

public interface PatientService {

    ResultPage<WjwFordocMsg> getFordocMsg(Page page, WjwFordocMsg wjwFordocMsg);

    Result sendMsg(WjwRepFordocMsg wjwRepFordocMsg);
}
