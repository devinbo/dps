package com.ah_service.dps.service.impl;

import com.ah_service.dps.constant.DoctorConstant;
import com.ah_service.dps.dao.UserDao;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.print.Doc;
import javax.servlet.http.HttpSession;
import java.util.List;

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
            return new Result<>(0, "用户们或密码错误！");
        }
        session.setAttribute("user", doctorDb);
        return new Result<>(1, "操作成功！", doctor);
    }

    @Override
    public ResultPage<Doctor> doctorList(Doctor doctor, Page page) {
        Doctor loginDoctor = (Doctor) session.getAttribute("user");
        loginDoctor.setDocName(doctor.getDocName());
        loginDoctor.setDocMedicineId(doctor.getDocMedicineId());
        PageHelper.startPage(page);
        List<Doctor> list = userDao.doctorList(loginDoctor);
        return new ResultPage<>(list);
    }

    /**
     * 查询医院详细
     * @param id
     * @return
     */
    @Override
    public Doctor toDoctorDetail(String id) {
        return userDao.getDoctorDetail(id);
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
        if(doctor.getDocId() == null) {
            //新增
            doctor.setDocPasswordMd5(DigestUtils.md5DigestAsHex(DoctorConstant.PASSWORD.getBytes()));
            userDao.addDoctor(doctor);
        }else {
            userDao.updDoctor(doctor);
        }
        return new Result();
    }
}
