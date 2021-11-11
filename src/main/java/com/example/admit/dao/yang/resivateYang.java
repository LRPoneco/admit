package com.example.admit.dao.yang;

import com.example.admit.dao.face;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import com.example.admit.poneco.com.MySQL.MySQLAPI;
import com.example.admit.poneco.com.analysisData.Analysis;
import com.example.admit.poneco.com.requestData.dataRead;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class resivateYang implements face {
    public String str;//修改的SQL语句的name
    public resivateYang(String str){
        this.str = str;
    }
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
        String str = analysis.getSQL(this.str);
        mySQLAPI.setSQL(str);
        mySQLAPI.Close();
        request.getSession().setAttribute("comSession",json);//添加信息返回
        return mySQLAPI.Operation();
    }
}
