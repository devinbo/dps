package com.ah_service.dps.dao;

import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;

import java.util.List;

public interface PatientDao {

    List<WjwFordocMsg> getFordocMsg(WjwFordocMsg wjwFordocMsg);

    void sendMsg(WjwRepFordocMsg wjwRepFordocMsg);
}
