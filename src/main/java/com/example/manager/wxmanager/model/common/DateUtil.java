package com.example.manager.wxmanager.model.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getDate(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.parse(str);
    }
    public static String getDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
    public static String getNowDate(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    public static Date getNowDate(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(str);
    }
    public static String timeStampToDate(Long timeStamp) throws ParseException {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(timeStamp);
    }

    /**
     * 向后推一天
     */
    public static String getTomorrowDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return getNowDate(calendar.getTime());
    }
    /**
     * 向前推？天
     */
    public static String getTomorrowDate(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) -day);
        return getNowDate(calendar.getTime());
    }

    /**
     * 向前推？分钟
     * @param date,min
     */
    public static String getNowBeforeMin(Date date,Long min){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c=Calendar.getInstance();
        c.add(Calendar.MINUTE, -min.intValue());//1分钟前
        return sdf.format(c.getTime());
    }

    public static String getCode(){
        return String.valueOf(new Date().getTime());
    }

}
