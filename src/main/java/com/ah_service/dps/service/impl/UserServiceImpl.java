package com.ah_service.dps.service.impl;

import com.ah_service.dps.constant.DoctorConstant;
import com.ah_service.dps.dao.UserDao;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.UserService;
import com.ah_service.dps.utils.PublicUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;

    @Override
    public Result<Doctor> login(Doctor doctor) {
        //监测用户名及其密码
        doctor.setDocPasswordMd5(DigestUtils.md5DigestAsHex(doctor.getDocPassword().getBytes()));
        Doctor doctorDb = userDao.checkNoAndPass(doctor);
        System.out.println(doctorDb);
        if (doctorDb == null) {
            return new Result<>(0, "用户名或密码错误！");
        }
        //设置医生和科室数量
        int docNums = userDao.getDoctorNums(doctorDb.getRawHosId());
        System.out.println(doctorDb.getIsadmin());
        if(doctorDb.getIsadmin() != null && doctorDb.getIsadmin()) {
            //说明是超级管理员
            session.setAttribute("user", doctorDb);
            return new Result<>(1, "操作成功！", doctor);
        }
        if(doctorDb.getHospital() != null) {
            doctorDb.getHospital().setDoctorNums(docNums);
            int divisionNums = userDao.getDivisionNums(doctorDb.getRawHosId());
            doctorDb.getHospital().setDivisionNums(divisionNums);
        }
        session.setAttribute("user", doctorDb);
        System.out.println(doctorDb);
        return new Result<>(1, "操作成功！", doctor);
    }

    @Override
    public ResultPage<Doctor> doctorList(Doctor doctor, Page page) {
        Doctor loginDoctor = (Doctor) session.getAttribute("user");
        doctor.setRawHosId(loginDoctor.getRawHosId());
        doctor.setIsadmin(loginDoctor.getIsadmin());
        PageHelper.startPage(page);
        List<Doctor> list = userDao.doctorList(doctor);
        return new ResultPage<>(list);
    }

    /**
     * 查询医院详细
     * @param id
     * @return
     */
    @Override
    public Doctor toDoctorDetail(String id) {
        Doctor doctor = userDao.getDoctorDetail(id);
        return doctor;
    }

    /**
     * 保存医生信息
     * @param doctor
     * @return
     */
    @Override
    public Result saveDoctor(Doctor doctor) {
        //判断登录号是否，
        int count = userDao.hasSameDoctor(doctor);
        if(count > 0) {
            return new Result(0, "登录账号重复，请重新输入");
        }
        Doctor loginDoctor = (Doctor) session.getAttribute("user");
        doctor.setCrtuser(loginDoctor.getCrtuser());
        doctor.setUpduser(loginDoctor.getCrtuser());
        if(!loginDoctor.getIsadmin()) {
            //如果是超级管理员添加，那么不重置医院信息
            doctor.setRawHosId(loginDoctor.getRawHosId());
            doctor.setDocHospital(loginDoctor.getDocHospital());
        }
        System.out.println(doctor);
        return new Result();
//        if(doctor.getDocId() == null) {
//            if(!StringUtils.isEmpty(doctor.getDocPassword())) {
//                if(!doctor.getDocPassword().equals(doctor.getDocCfmPassword())) {
//                    return new Result(0, "两次输入密码不一致");
//                }
//                doctor.setDocPasswordMd5(DigestUtils.md5DigestAsHex(doctor.getDocPassword().getBytes()));
//            }else{
//                doctor.setDocPasswordMd5(DigestUtils.md5DigestAsHex(DoctorConstant.PASSWORD.getBytes()));
//            }
//            //新增
//            doctor.setRawHosId(loginDoctor.getRawHosId());
//            userDao.addDoctor(doctor);
//        }else {
//            if(!StringUtils.isEmpty(doctor.getDocPassword())) {
//                if(!doctor.getDocPassword().equals(doctor.getDocCfmPassword())) {
//                    return new Result(0, "两次输入密码不一致");
//                }
//                doctor.setDocPasswordMd5(DigestUtils.md5DigestAsHex(doctor.getDocPassword().getBytes()));
//            }
//            userDao.updDoctor(doctor);
//        }
//        return new Result();
    }

    @Override
    public Result setFee(String fee) {
        Doctor loginDoctor = (Doctor) session.getAttribute("user");
        loginDoctor.setInquirprice(Double.valueOf(fee));
        userDao.updInquirprice(loginDoctor);
        session.setAttribute("user", loginDoctor);
        return new Result();
    }

    @Override
    public Result updPass(Map<String, Object> param) {
        String password = (String) param.get("password");
        //校验密码是否正确
        Doctor doctor = (Doctor) session.getAttribute("user");
        if(Objects.equals(DigestUtils.md5DigestAsHex(password.getBytes()), doctor.getDocPasswordMd5())) {
            String newpass = (String) param.get("newpassword");
            String confpass = (String) param.get("cfmpassword");
            if(newpass.length() < 4 || newpass.length() > 20 || !Objects.equals(newpass, confpass)) {
                return new Result(0, "密码长度在4-20位之间！");
            }
            String md5Pass = DigestUtils.md5DigestAsHex(newpass.getBytes());
            userDao.updPass(doctor.getDocId(), md5Pass);
            //修改session中用户密码
            doctor.setDocPasswordMd5(md5Pass);
            session.setAttribute("user", doctor);
            return new Result();
        }else{
            return new Result(0, "密码错误，操作失败！");
        }
    }
}
