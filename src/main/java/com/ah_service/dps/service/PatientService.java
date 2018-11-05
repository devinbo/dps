package com.ah_service.dps.service;

import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;

import java.util.List;
import java.util.Map;

public interface PatientService {

    ResultPage<WjwFordocMsg> getFordocMsg(Page page, WjwFordocMsg wjwFordocMsg);

    Result getLastProblem(String msgId);

    Result addReply(WjwRepFordocMsg wjwRepFordocMsg);

    List<Map<String,Object>> getReplyAllView();

    Map<String,Object> getAskCount(Long docId);
}
