package com.ah_service.dps;

import com.ah_service.dps.utils.PublicUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = simpleDateFormat.format(calendar.getTime());
        System.out.println(date1);
        System.out.println("当前星期：" + (calendar.get(Calendar.DAY_OF_WEEK) - 1));
        for (int i=0;i<7;i++) {
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH) - 1;
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            System.out.println("当前星期：" + (calendar.get(Calendar.DAY_OF_WEEK) - 1));
            String dateStr = simpleDateFormat.format(calendar.getTime());
            System.out.println(dateStr);
        }
    }

}
