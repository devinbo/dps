package com.ah_service.dps.model;

import java.util.List;

public class WjwFordocMsg {

  private Long msgId;
  private String msgInfo;
  private String msgKey;
  private String msgUserId;
  private Long msgDocId;
  private String msgCrttime;
  private String msgUpdtime;
  private String repFlag;
  private String currDay;
  private String currWeek;

  //开始时间
  private String startDate;
  //结束时间
  private String endDate;
  private Doctor doctor;
  //回复信息
  private List<WjwRepFordocMsg> wjwRepFordocMsgList;

  public Long getMsgId() {
    return msgId;
  }

  public void setMsgId(Long msgId) {
    this.msgId = msgId;
  }

  public String getMsgInfo() {
    return msgInfo;
  }

  public void setMsgInfo(String msgInfo) {
    this.msgInfo = msgInfo;
  }

  public String getMsgKey() {
    return msgKey;
  }

  public void setMsgKey(String msgKey) {
    this.msgKey = msgKey;
  }

  public String getMsgUserId() {
    return msgUserId;
  }

  public void setMsgUserId(String msgUserId) {
    this.msgUserId = msgUserId;
  }

  public Long getMsgDocId() {
    return msgDocId;
  }

  public void setMsgDocId(Long msgDocId) {
    this.msgDocId = msgDocId;
  }

  public String getMsgCrttime() {
    return msgCrttime;
  }

  public void setMsgCrttime(String msgCrttime) {
    this.msgCrttime = msgCrttime;
  }

  public String getMsgUpdtime() {
    return msgUpdtime;
  }

  public void setMsgUpdtime(String msgUpdtime) {
    this.msgUpdtime = msgUpdtime;
  }

  public String getRepFlag() {
    return repFlag;
  }

  public void setRepFlag(String repFlag) {
    this.repFlag = repFlag;
  }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<WjwRepFordocMsg> getWjwRepFordocMsgList() {
        return wjwRepFordocMsgList;
    }

    public void setWjwRepFordocMsgList(List<WjwRepFordocMsg> wjwRepFordocMsgList) {
        this.wjwRepFordocMsgList = wjwRepFordocMsgList;
    }

  public String getCurrDay() {
    return currDay;
  }

  public void setCurrDay(String currDay) {
    this.currDay = currDay;
  }

  public String getCurrWeek() {
    return currWeek;
  }

  public void setCurrWeek(String currWeek) {
    this.currWeek = currWeek;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
}
