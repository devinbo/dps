package com.ah_service.dps.dao;

import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientDao {

    List<WjwFordocMsg> getFordocMsg(WjwFordocMsg wjwFordocMsg);

    WjwFordocMsg getLastProblem(@Param("msgId") String msgId);

    void updateWjwMsg(@Param("docId") Long docId, @Param("msgId") Long msgId);

    void insertWjwRepMsg(WjwRepFordocMsg wjwRepFordocMsg);

    WjwRepFordocMsg getLastRepProblem(@Param("msgId") String msgId);
}
