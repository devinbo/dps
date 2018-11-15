package com.ah_service.dps.model;

import lombok.Data;

/**
 * 医院
 */
@Data
public class Hospital {

  private Long hosId;
  private String hosName;
  private String hosGrade;
  private String hosGradeName;
  private String hosLogo;
  private String hosCity;
  private String hosCityName;
  private String hosArea;
  private String hosAreaName;
  private String hosLinkphone;
  private String hosMedicine;
  private String hosAwards;
  private String hosDesc;
  private String crtuser;
  private String crtdate;
  private String upduser;
  private String update;
  private String recsts;

  private String hosAddress;// 医院地址
  private String hosWite; //医院网址
  private String hosLatitude;
  private String hosLongitude;
  private String rawHospitalId;
  private String hosType;

  private Doctor admin; //医院管理员账户

}
