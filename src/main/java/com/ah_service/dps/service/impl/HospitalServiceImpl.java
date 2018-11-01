package com.ah_service.dps.service.impl;

import com.ah_service.dps.dao.HospitalDao;
import com.ah_service.dps.model.Division;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.model.Hospital;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.HospitalService;
import com.ah_service.dps.utils.PublicUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalDao hospitalDao;

    @Autowired
    private HttpSession session;

    @Override
    public ResultPage<Hospital> hospitalList(Hospital hospital, Page page) {
        PageHelper.startPage(page);
        List<Hospital> hospitalList =  hospitalDao.hospitalList(hospital);
        return new ResultPage<>(hospitalList);
    }

    @Override
    public Hospital getHospitalDetail(String id) {
        return hospitalDao.getHospitalDetail(id);
    }

    @Override
    public Result saveHospital(Hospital hospital) {
        //校验是否重名
        int count = hospitalDao.getSameHospital(hospital);
        if(count > 0) {
            return new Result(0, "医院名称重复，请重新输入");
        }
        Doctor loginDoctor = getLoginDoctor();
        hospital.setCrtuser(loginDoctor.getDocLoginno());
        hospital.setUpduser(loginDoctor.getDocLoginno());
        if(hospital.getHosId() == null) {
            hospitalDao.addHospital(hospital);
            //生成管理员信息

        }else{
            hospitalDao.updHospital(hospital);
            //修改管理员信息

        }
        return new Result();
    }

    @Override
    public Result delHospital(String ids) {
        hospitalDao.delHospital(PublicUtil.toListByIds(ids));
        return new Result();
    }

    @Override
    public Result getAllDivision() {
        Doctor loginDoctor = getLoginDoctor();
        List<Division> list = hospitalDao.getAllDivision(loginDoctor);
        return new Result<List>(1, "查询成功！", list);
    }

    public Doctor getLoginDoctor() {
        return (Doctor) session.getAttribute("user");
    }

}
