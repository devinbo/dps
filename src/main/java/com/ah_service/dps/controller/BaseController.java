package com.ah_service.dps.controller;


import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 获取所有的基础信息
 */
@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("getAllGrade")
    public Result<List> getAllGrade() {
        return baseService.getAllGrade();
    }

    @RequestMapping("getAllCity")
    public Result<List> getAllCity() {
        return baseService.getAllCity();
    }

    @RequestMapping("getArea")
    public Result<List> getArea(String city_id) {
        return baseService.getArea(city_id);
    }
}
