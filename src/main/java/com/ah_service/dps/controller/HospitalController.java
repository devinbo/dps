package com.ah_service.dps.controller;

import com.ah_service.dps.model.Hospital;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.HospitalService;
import com.ah_service.dps.utils.PropertyLoad;
import com.ah_service.dps.utils.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/hospitalList")
    public @ResponseBody
    ResultPage<Hospital> hospitalList(Hospital hospital, Page page) {
        System.out.println(page);
        return hospitalService.hospitalList(hospital, page);
    }

    @RequestMapping("/toHospitalDetail")
    public @ResponseBody
    ModelAndView getHospitalDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Hospital hospital = hospitalService.getHospitalDetail(id);
        modelAndView.addObject("hospital", hospital);
        modelAndView.setViewName("content/hospital/hospitalDetail");
        return modelAndView;
    }

    /**
     * 添加修改医院信息
     * @param hospital
     * @return
     */
    @RequestMapping("/saveHospital")
    public @ResponseBody
    Result saveHospital(MultipartFile logoFile, Hospital hospital) throws IOException {
        System.out.println(logoFile);
        if(logoFile != null) {
            //重新上传文件
            hospital.setHosLogo(dealFile(logoFile));
        }
        return hospitalService.saveHospital(hospital);
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
        String dir = PropertyLoad.getProperty("logoServicePath");
        System.out.println(dir);
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String nginxImgPath = PropertyLoad.getProperty("nginxImgPath");
        File bookFile = new File(dir + File.separator + filename);
        file.transferTo(bookFile);
        return nginxImgPath + filename;
    }

    /**
     * 删除医院
     * @return
     */
    @RequestMapping("/delHospital")
    public @ResponseBody Result delHospital(String ids) {
        return hospitalService.delHospital(ids);
    }

    /**
     * 获取当前医院的所有医科
     */
    @RequestMapping("/getAllDivision")
    public @ResponseBody Result getAllDivision() {
        return hospitalService.getAllDivision();
    }

}
