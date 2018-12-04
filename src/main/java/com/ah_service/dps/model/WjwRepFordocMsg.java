package com.ah_service.dps.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
public class WjwRepFordocMsg {

  private Long repMsgId;
  private String repMsgInfo;
  private String repMsgType;
  private Long msgDocuserId;
  private Long msgId;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String repMsgTime;

  private String repMsgImg;
}
