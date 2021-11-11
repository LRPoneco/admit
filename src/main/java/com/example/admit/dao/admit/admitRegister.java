package com.example.admit.dao.admit;

import com.example.admit.dao.face;
import com.example.admit.poneco.com.MySQL.MySQLAPI;
import com.example.admit.poneco.com.analysisData.Analysis;
import com.example.admit.poneco.com.requestData.dataRead;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admitRegister implements face {

    @Override
    public boolean main(HttpServletRequest request, HttpServletResponse response) {
        return dao(request,response);
    }

    @Override
    public boolean dao(HttpServletRequest request,HttpServletResponse response) {
        MySQLAPI mySQLAPI = new MySQLAPI();
        Analysis analysis = new Analysis();
        dataRead dataRead = new dataRead();
        JSONArray json = dataRead.getData(request);
        analysis.setRequest(request);
        analysis.setJOSN(json);
        String str = analysis.getSQL("Register");
        System.out.print(str);
        mySQLAPI.setSQL(str);
        request.getSession().setAttribute("admitJson",json);//注册信息返回
        boolean alex = mySQLAPI.Operation();
        try{
            if(alex){
                response.sendRedirect("/webapp/suess.html");
            }else {
                response.sendRedirect("/webapp/fail.html");
            }
        }catch (Exception e){
        }
        return alex;
    }
}
