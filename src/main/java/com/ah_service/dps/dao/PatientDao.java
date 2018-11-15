package com.ah_service.dps.dao;

import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PatientDao {

    List<WjwFordocMsg> getFordocMsg(WjwFordocMsg wjwFordocMsg);

    WjwFordocMsg getLastProblem(@Param("msgId") String msgId);

    void updateWjwMsg(@Param("docId") Long docId, @Param("msgId") Long msgId);

    void insertWjwRepMsg(WjwRepFordocMsg wjwRepFordocMsg);

    WjwRepFordocMsg getLastRepProblem(@Param("msgId") String msgId);

    List<Map<String,Object>> getReplyAllView(@Param("weekList") List<Map<String, String>> weekList, @Param("docId") Long docId);

    Map<String,Object> getAskCount(@Param("docId") Long docId);

    List<Map<String, Object>> getLatestLeave(@Param("docId") Long docId);
}
