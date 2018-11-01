package com.ah_service.dps.model;

public class WjwFordocMsg {

  private Long msgId;
  private String msgInfo;
  private String msgKey;
  private String msgUserId;
  private Long msgDocId;
  private String msgCrttime;
  private String msgUpdtime;
  private String repFlag;

  //回复信息
  private String repMsgInfo;
  private String repMsgTime;

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

  public String getRepMsgInfo() {
    return repMsgInfo;
  }

  public void setRepMsgInfo(String repMsgInfo) {
    this.repMsgInfo = repMsgInfo;
  }

  public String getRepMsgTime() {
    return repMsgTime;
  }

  public void setRepMsgTime(String repMsgTime) {
    this.repMsgTime = repMsgTime;
  }
}
