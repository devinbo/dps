package com.ah_service.dps.service;

import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;

import java.util.Map;

public interface UserService {

    Result<Doctor> login(Doctor employee);

    ResultPage<Doctor> doctorList(Doctor doctor, Page page);

    Doctor toDoctorDetail(String id);

    Result saveDoctor(Doctor doctor);

    Result setFee(String fee);

    Result updPass(Map<String, Object> param);

    Result delDoctor(String ids);
}
