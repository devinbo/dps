package com.ah_service.dps.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 医生
 */
@Data
public class Doctor {

  private Long docId;
  private String docName;
  private String docLoginno;
  private String docPassword; //密码
  private String docCfmPassword; //确认密码
  private String docPasswordMd5;
  private String docSex;
  private String docAge;
  private String docSpeciality;
  private String docDesc;
  private Long docMedicineId; //所属医科
  private String docMedicineName; //所属医科名称
  private Long docHospital; //所属医院
  private String docHospitalName; //所属医院名称
  private Boolean ishosadmin; //医院管理员
  private Boolean isadmin; //超级管理员
  private String docHeadimg; //个人头像地址
  private String crtuser;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String crtdate;
  private String upduser;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String update;
  private String recsts;

  private String docSchool; //毕业院校
  private String docPosition;//职位
  private String docScore; //评分
  private String rawDocId; //原始ID;
  private String docPhone; //医生电话号码
  private String rawHosId; //所属医院ID；

  private Double inquirprice;

  private Hospital hospital; //所属医院信息


}
