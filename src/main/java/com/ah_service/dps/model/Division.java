package com.ah_service.dps.model;

public class Division {

  private Long divId;
  private String divName;
  private String divCode;
  private Long hospitalId;
  private String crtuser;
  private String crtdate;
  private String recsts;

  public Long getDivId() {
    return divId;
  }

  public void setDivId(Long divId) {
    this.divId = divId;
  }

  public String getDivName() {
    return divName;
  }

  public void setDivName(String divName) {
    this.divName = divName;
  }

  public String getDivCode() {
    return divCode;
  }

  public void setDivCode(String divCode) {
    this.divCode = divCode;
  }

  public Long getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(Long hospitalId) {
    this.hospitalId = hospitalId;
  }

  public String getCrtuser() {
    return crtuser;
  }

  public void setCrtuser(String crtuser) {
    this.crtuser = crtuser;
  }

  public String getCrtdate() {
    return crtdate;
  }

  public void setCrtdate(String crtdate) {
    this.crtdate = crtdate;
  }

  public String getRecsts() {
    return recsts;
  }

  public void setRecsts(String recsts) {
    this.recsts = recsts;
  }
}
