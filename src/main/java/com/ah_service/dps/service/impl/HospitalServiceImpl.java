package com.ah_service.dps.service.impl;

import com.ah_service.dps.dao.HospitalDao;
import com.ah_service.dps.model.Hospital;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.HospitalService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalDao hospitalDao;

    @Override
    public ResultPage<Hospital> hospitalList(Hospital hospital, Page page) {
        PageHelper.startPage(page);
        List<Hospital> hospitalList =  hospitalDao.hospitalList(hospital);
        return new ResultPage<>(hospitalList);
    }

    @Override
    public Hospital getHospitalDetail(String id) {
        return hospitalDao.getHospitalDetail(id);
    }


}
