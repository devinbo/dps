package com.ah_service.dps.service.impl;

import com.ah_service.dps.dao.PatientDao;
import com.ah_service.dps.model.Doctor;
import com.ah_service.dps.model.WjwFordocMsg;
import com.ah_service.dps.model.WjwRepFordocMsg;
import com.ah_service.dps.pojo.Page;
import com.ah_service.dps.pojo.Result;
import com.ah_service.dps.pojo.ResultPage;
import com.ah_service.dps.service.PatientService;
import com.ah_service.dps.utils.PublicUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private HttpSession session;


    @Override
    public ResultPage<WjwFordocMsg> getFordocMsg(Page page, WjwFordocMsg wjwFordocMsg) {
//        PageHelper.startPage(page);
        Doctor doctor = (Doctor) session.getAttribute("user");
        wjwFordocMsg.setMsgDocId(doctor.getDocId());
        if(!StringUtils.isEmpty(wjwFordocMsg.getMsgCrttime())) {
            if(Objects.equals(wjwFordocMsg.getMsgCrttime(), "全部")) {
                wjwFordocMsg.setMsgCrttime(null);
            }else{
                wjwFordocMsg.setMsgCrttime(PublicUtil.getDate("yyyy") + "-" + wjwFordocMsg.getMsgCrttime());
            }
        }
        List<WjwFordocMsg> list = patientDao.getFordocMsg(wjwFordocMsg);
        return new ResultPage<>(list);
    }

    @Override
    public Result getLastProblem(String msgId) {
        WjwFordocMsg wjwFordocMsg = patientDao.getLastProblem(msgId);
        WjwRepFordocMsg wjwRepFordocMsg = patientDao.getLastRepProblem(msgId);
        List<WjwRepFordocMsg> list = new ArrayList<>();
        if(wjwRepFordocMsg != null) {
            list.add(wjwRepFordocMsg);
        }
        wjwFordocMsg.setWjwRepFordocMsgList(list);
        return new Result<WjwFordocMsg>(1, "查询成功！", wjwFordocMsg);
    }

    @Override
    public Result addReply(WjwRepFordocMsg wjwRepFordocMsg) {
        Doctor doctor = (Doctor) session.getAttribute("user");
        wjwRepFordocMsg.setMsgDocuserId(doctor.getDocId());
        patientDao.updateWjwMsg(doctor.getDocId(), wjwRepFordocMsg.getMsgId());
        patientDao.insertWjwRepMsg(wjwRepFordocMsg);
        return new Result();
    }

    /**
     * 总阅
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getReplyAllView() {
        Doctor doctor = (Doctor) session.getAttribute("user");
        //获取当前日期的前7天的所有日期及其星期
        List<Map<String, String>> date = getWeekDate();
        List<Map<String, Object>> list = patientDao.getReplyAllView(date, doctor.getDocId());
        System.out.println(list);
        return list;
    }

    @Override
    public Map<String, Object> getAskCount(Long docId) {
        Map<String, Object> map = patientDao.getAskCount(docId);
        return map;
    }

    @Override
    public List<Map<String, Object>> getLatestLeave() {
        Doctor doctor = (Doctor) session.getAttribute("user");
        return patientDao.getLatestLeave(doctor.getDocId());
    }

    @Override
    public Map<String, Object> getAdminSample() {
        Map<String, Object> map = new HashMap<>();
        //获取医院总数量，
        int hosCount = patientDao.getAllHosCount();
        map.put("hosCount", hosCount);
        int docCount = patientDao.getAllDocCount();
        map.put("hosDoc", docCount);
        return map;
    }

    private List<Map<String,String>> getWeekDate() {
        List<Map<String, String>> list = new ArrayList<>();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM-dd");
        String currDate = simpleDateFormat.format(calendar.getTime());
        Map<String, String> currDay = new HashMap<>();
        currDay.put("date", currDate);
        currDay.put("week", dealWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1));
        currDay.put("day", simpleDateFormat2.format(calendar.getTime()));
        list.add(currDay);
        for (int i=0;i<6;i++) {
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH) - 1;
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            System.out.println("当前星期：" + (calendar.get(Calendar.DAY_OF_WEEK) - 1));
            String dateStr = simpleDateFormat.format(calendar.getTime());
            Map<String, String> map = new HashMap<>();
            map.put("date", dateStr);
            map.put("day", simpleDateFormat2.format(calendar.getTime()));
            map.put("week", dealWeek(dayOfWeek));
            list.add(map);
        }
        return list;
    }

    private String dealWeek(int dayNum) {
        String week = "";
        switch (dayNum) {
            case 0:
                week = "星期日";
                break;
            case 1:
                week = "星期一";
                break;
            case 2:
                week = "星期二";
                break;
            case 3:
                week = "星期三";
                break;
            case 4:
                week = "星期四";
                break;
            case 5:
                week = "星期五";
                break;
            case 6:
                week = "星期六";
                break;
        }
        return week;
    }
}
