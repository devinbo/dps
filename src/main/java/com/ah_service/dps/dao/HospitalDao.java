package com.ah_service.dps.dao;

import com.ah_service.dps.model.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HospitalDao {

    List<Hospital> hospitalList(Hospital hospital);

    Hospital getHospitalDetail(@Param("id") String id);
}
