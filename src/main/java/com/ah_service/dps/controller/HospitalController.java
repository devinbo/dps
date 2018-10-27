package com.ah_service.dps.controller;

import com.ah_service.dps.model.Hospital;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/hospitalList")
    public @ResponseBody
    ResultPage<Hospital> hospitalList(Hospital hospital, Page page) {
        return hospitalService.hospitalList(hospital, page);
    }

    @RequestMapping("/toHospitalDetail")
    public @ResponseBody
    ModelAndView getHospitalDetail(String id) {
        ModelAndView modelAndView = new ModelAndView();
        Hospital hospital = hospitalService.getHospitalDetail(id);
        modelAndView.addObject("hospital", hospital);
        modelAndView.setViewName("hospital/hospitalDetail");
        return modelAndView;
    }

    @RequestMapping("/saveHospital")
    public @ResponseBody
    Result saveHospital(Hospital hospital) {
        return null;
    }

}
