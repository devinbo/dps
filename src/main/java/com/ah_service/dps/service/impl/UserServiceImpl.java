package com.ah_service.dps.service.impl;

import com.ah_service.dps.dao.UserDao;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;

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
        System.out.println("....");
        session.setAttribute("user", doctorDb);
        return new Result<>(1, "操作成功！", doctor);
    }
}
