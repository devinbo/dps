package com.ah_service.dps.service.impl;


import com.ah_service.dps.dao.BaseDao;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private HttpSession session;

    @Override
    public Result<List> getAllGrade() {
        List<Map> list = baseDao.getAllGrade();
        return new Result<List>(1, "查询成功！", list);
    }

    @Override
    public Result<List> getAllCity() {
        List<Map> list = baseDao.getAllCityByAnHui();
        return new Result<>(1, "查询成功！", list);
    }

    @Override
    public Result<List> getArea(String city_id) {
        List<Map> list = baseDao.getArea(city_id);
        return new Result<>(1, "查询成功！", list);
    }

    @Override
    public Result getAllMedicine(String rawHosId){
        List<Map<String, Object>> list = baseDao.getAllMedicine(rawHosId);
        return new Result(1, "查询成功！", list);
    }

    @Override
    public Result getHosByKey(String key) {
        return new Result(1, "查询成功！", baseDao.getHosByKey(key));
    }
}
