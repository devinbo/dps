package com.ah_service.dps.service;


import com.ah_service.dps.pojo.Result;

import java.util.List;
import java.util.Map;

public interface BaseService {

    Result<List> getAllGrade();

    Result<List> getAllCity();

    Result<List> getArea(String city_id);

    Result getAllMedicine();
}
