package com.ah_service.dps.dao;


import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    Doctor checkNoAndPass(Doctor doctor);

    List<Doctor> doctorList(Doctor doctor);

    Doctor getDoctorDetail(@Param("id") String id);

    int hasSameDoctor(Doctor doctor);

    void addDoctor(Doctor doctor);

    void updDoctor(Doctor doctor);
}
