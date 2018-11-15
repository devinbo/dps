package com.ah_service.dps.model;

import lombok.Data;

@Data
public class Division {

  private Long divId;
  private String divName;
  private String divCode;
  private Long hospitalId;
  private String crtuser;
  private String crtdate;
  private String recsts;

}
