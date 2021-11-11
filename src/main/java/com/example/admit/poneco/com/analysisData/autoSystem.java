package com.example.admit.poneco.com.analysisData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class autoSystem implements autoSystemInterface{
    /**
     * 自动加载随机参数
     * @param Length
     * @return
     */
    public String getRan(int Length){
        String alex = "";
        Random ran = new Random();
        for(int i=0;i<Length;i++){
            alex = alex + ran.nextInt(10);
        }
        return alex;
    }

    /**
     * 获取系统时间
     * @param TimeType
     * @return
     */
    public String getSystemTime(String TimeType){
        String alex = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeType);//设置时间格式
        alex = simpleDateFormat.format(new Date());
        return alex;
    }

    /**
     * 获取自动会话值
     * @param request
     * @param sessionName
     * @return
     */
    public String getSession(HttpServletRequest request,String sessionName){
        String alex = null;
        HttpSession session = request.getSession();
        alex = (String)session.getAttribute(sessionName);
        System.out.println(alex);
        return alex;
    }

    /**
     * 获取自动命令
     * @param str
     * @return
     */
    public String getRemark(String str){
        String alex=null;
        alex = str.substring(str.indexOf("$")+1,str.length()-1);
        return alex;
    }
}
