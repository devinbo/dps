package com.ah_service.dps.service;

import com.ah_service.dps.model.Hospital;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.ResultPage;

public interface HospitalService {

    ResultPage<Hospital> hospitalList(Hospital hospital, Page page);

    Hospital getHospitalDetail(String id);
}
