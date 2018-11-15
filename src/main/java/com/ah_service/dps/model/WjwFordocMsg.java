package com.ah_service.dps.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
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

}
