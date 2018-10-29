package com.ah_service.dps.model;

/**
 * 医生
 */
public class Doctor {

  private Long docId;
  private String docName;
  private String docLoginno;
  private String docPassword;
  private String docPasswordMd5;
  private String docSex;
  private String docAge;
  private String docSpeciality;
  private String docDesc;
  private Long docMedicineId; //所属医科
  private Long docHospital; //所属医院
  private Boolean ishosadmin; //医院管理员
  private Boolean isadmin; //超级管理员
  private String docHeadimg; //个人头像地址
  private String crtuser;
  private String crtdate;
  private String recsts;

  private Hospital hospital; //所属医院信息


  public Long getDocId() {
    return docId;
  }

  public void setDocId(long docId) {
    this.docId = docId;
  }


  public String getDocName() {
    return docName;
  }

  public void setDocName(String docName) {
    this.docName = docName;
  }

  public String getDocLoginno() {
    return docLoginno;
  }

  public void setDocLoginno(String docLoginno) {
    this.docLoginno = docLoginno;
  }


  public String getDocPassword() {
    return docPassword;
  }

  public void setDocPassword(String docPassword) {
    this.docPassword = docPassword;
  }

  public void setDocId(Long docId) {
    this.docId = docId;
  }

  public String getDocPasswordMd5() {
    return docPasswordMd5;
  }

  public void setDocPasswordMd5(String docPasswordMd5) {
    this.docPasswordMd5 = docPasswordMd5;
  }

  public void setDocMedicineId(Long docMedicineId) {
    this.docMedicineId = docMedicineId;
  }

  public void setDocHospital(Long docHospital) {
    this.docHospital = docHospital;
  }

  public String getDocSex() {
    return docSex;
  }

  public void setDocSex(String docSex) {
    this.docSex = docSex;
  }


  public String getDocAge() {
    return docAge;
  }

  public void setDocAge(String docAge) {
    this.docAge = docAge;
  }


  public String getDocSpeciality() {
    return docSpeciality;
  }

  public void setDocSpeciality(String docSpeciality) {
    this.docSpeciality = docSpeciality;
  }

  public String getDocDesc() {
    return docDesc;
  }

  public void setDocDesc(String docDesc) {
    this.docDesc = docDesc;
  }


  public Long getDocMedicineId() {
    return docMedicineId;
  }

  public void setDocMedicineId(long docMedicineId) {
    this.docMedicineId = docMedicineId;
  }


  public Long getDocHospital() {
    return docHospital;
  }

  public void setDocHospital(long docHospital) {
    this.docHospital = docHospital;
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

  public Boolean getIshosadmin() {
    return ishosadmin;
  }

  public void setIshosadmin(Boolean ishosadmin) {
    this.ishosadmin = ishosadmin;
  }

  public Boolean getIsadmin() {
    return isadmin;
  }

  public void setIsadmin(Boolean isadmin) {
    this.isadmin = isadmin;
  }


  public Hospital getHospital() {
    return hospital;
  }

  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }

  public String getDocHeadimg() {
    return docHeadimg;
  }

  public void setDocHeadimg(String docHeadimg) {
    this.docHeadimg = docHeadimg;
  }

  @Override
  public String toString() {
    return "Doctor{" +
            "docId=" + docId +
            ", docName='" + docName + '\'' +
            ", docLoginno='" + docLoginno + '\'' +
            ", docPassword='" + docPassword + '\'' +
            ", docPasswordMd5='" + docPasswordMd5 + '\'' +
            ", docSex='" + docSex + '\'' +
            ", docAge='" + docAge + '\'' +
            ", docSpeciality='" + docSpeciality + '\'' +
            ", docDesc='" + docDesc + '\'' +
            ", docMedicineId=" + docMedicineId +
            ", docHospital=" + docHospital +
            ", ishosadmin=" + ishosadmin +
            ", isadmin=" + isadmin +
            ", docHeadimg='" + docHeadimg + '\'' +
            ", crtuser='" + crtuser + '\'' +
            ", crtdate='" + crtdate + '\'' +
            ", recsts='" + recsts + '\'' +
            ", hospital=" + hospital +
            '}';
  }
}
