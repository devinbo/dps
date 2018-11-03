package com.ah_service.dps.dao;

import com.ah_service.dps.model.Division;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.model.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HospitalDao {

    List<Hospital> hospitalList(Hospital hospital);

    Hospital getHospitalDetail(@Param("id") String id);

    int getSameHospital(Hospital hospital);

    void addHospital(Hospital hospital);

    void updHospital(Hospital hospital);

    void delHospital(@Param("ids") List<String> ids);

    List<Map<String, Object>> getAllDivision();
}
