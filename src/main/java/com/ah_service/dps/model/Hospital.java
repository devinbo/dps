package com.ah_service.dps.model;

/**
 * 医院
 */
public class Hospital {

  private Long hosId;
  private String hosName;
  private String hosGrade;
  private String hosLogo;
  private String hosCity;
  private String hosArea;
  private String hosLinkphone;
  private String hosMedicine;
  private String hosAwards;
  private String hosDesc;
  private String crtuser;
  private String crtdate;
  private String recsts;


  public Long getHosId() {
    return hosId;
  }

  public void setHosId(Long hosId) {
    this.hosId = hosId;
  }


  public String getHosName() {
    return hosName;
  }

  public void setHosName(String hosName) {
    this.hosName = hosName;
  }


  public String getHosGrade() {
    return hosGrade;
  }

  public void setHosGrade(String hosGrade) {
    this.hosGrade = hosGrade;
  }


  public String getHosLogo() {
    return hosLogo;
  }

  public void setHosLogo(String hosLogo) {
    this.hosLogo = hosLogo;
  }


  public String getHosCity() {
    return hosCity;
  }

  public void setHosCity(String hosCity) {
    this.hosCity = hosCity;
  }

  public String getHosArea() {
    return hosArea;
  }

  public void setHosArea(String hosArea) {
    this.hosArea = hosArea;
  }


  public String getHosLinkphone() {
    return hosLinkphone;
  }

  public void setHosLinkphone(String hosLinkphone) {
    this.hosLinkphone = hosLinkphone;
  }


  public String getHosMedicine() {
    return hosMedicine;
  }

  public void setHosMedicine(String hosMedicine) {
    this.hosMedicine = hosMedicine;
  }


  public String getHosAwards() {
    return hosAwards;
  }

  public void setHosAwards(String hosAwards) {
    this.hosAwards = hosAwards;
  }


  public String getHosDesc() {
    return hosDesc;
  }

  public void setHosDesc(String hosDesc) {
    this.hosDesc = hosDesc;
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
