package com.ah_service.dps.controller;

import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.UserService;
import com.ah_service.dps.utils.PropertyLoad;
import com.ah_service.dps.utils.PublicUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

//import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Doctor> login(Doctor doctor, HttpServletRequest request) {
        String yzm = request.getParameter("yzm");
        if(StringUtils.isEmpty(yzm)) {
            return new Result<>(0, "验证码不能为空！");
        }else if(StringUtils.isEmpty(doctor.getDocLoginno()) || StringUtils.isEmpty(doctor.getDocPassword())) {
            return new Result<>(0, "用户名或密码不能为空!");
        }
        String captchaId = (String) request.getSession().getAttribute("vrifyCode");
        if(!yzm.equals(captchaId)) {
            return new Result<>(0, "验证码不正确！");
        }
        return userService.login(doctor);
    }

    @RequestMapping(value = "/getUserInfo")
    public Result<Doctor> getUserInfo(HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        return new Result<>(1, "查询成功", doctor);
    }

    @RequestMapping("/doctorList")
    public ResultPage<Doctor> doctorList(Doctor doctor, Page page) {
        return userService.doctorList(doctor, page);
    }

    @RequestMapping("/toDoctorDetail")
    public @ResponseBody ModelAndView toDoctorDetail(String id) {
        Doctor doctor = userService.toDoctorDetail(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/doctor/doctorDetail");
        modelAndView.addObject("doctor", doctor);
        return modelAndView;
    }

    @RequestMapping("/saveDoctor")
    public @ResponseBody Result saveDoctor(MultipartFile docHeadimgFile, Doctor doctor) throws IOException {
        if(docHeadimgFile != null) {
            String filepath = dealFile(docHeadimgFile);
            doctor.setDocHeadimg(filepath);
        }
        return userService.saveDoctor(doctor);
    }

    private String dealFile(MultipartFile file) throws IOException {
        if (file == null) {
            return null;
        }
        String file_sourcename = file.getOriginalFilename();
        String ref = file_sourcename.substring(file_sourcename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("_", "").substring(0, 8);
        //生成文件名称
        String date = PublicUtil.getDate("yyyy-MM-dd");
        String filename = date +"_" + uuid + ref;
        String dir = PropertyLoad.getProperty("headImgServicePath");
        System.out.println(dir);
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String nginxImgPath = PropertyLoad.getProperty("nginxHeadImgPath");
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return nginxImgPath + filename;
    }
}
