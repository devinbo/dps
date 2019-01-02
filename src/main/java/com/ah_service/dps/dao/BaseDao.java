package com.ah_service.dps.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseDao {

    List<Map> getAllGrade();

    List<Map> getAllCityByAnHui();

    List<Map> getArea(@Param("city_id") String city_id);

    List<Map<String,Object>> getAllMedicine(@Param("rawHosId") String rawHosId);

    List<Map<String, Object>> getHosByKey(@Param("key") String key);
}
