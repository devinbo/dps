package com.ah_service.dps.service;

import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Result;

public interface UserService {

    Result<Doctor> login(Doctor employee);
}
