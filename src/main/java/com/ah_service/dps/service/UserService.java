package com.ah_service.dps.service;

import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;

public interface UserService {

    Result<Doctor> login(Doctor employee);

    ResultPage<Doctor> doctorList(Doctor doctor, Page page);
}
