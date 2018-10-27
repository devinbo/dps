package com.ah_service.dps.controller;

import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Doctor> login(Doctor doctor) {
        if(StringUtils.isEmpty(doctor.getDocLoginno()) || StringUtils.isEmpty(doctor.getDocPassword())) {
            return new Result<>(0, "用户名或密码不能为空!");
        }
        return userService.login(doctor);
    }

    @RequestMapping(value = "/getUserInfo")
    public Result<Doctor> getUserInfo() {
        Doctor doctor = (Doctor) session.getAttribute("user");
        return new Result<>(1, "查询成功", doctor);
    }

}
