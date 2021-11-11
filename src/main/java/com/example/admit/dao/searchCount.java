package com.example.admit.dao;

import com.alibaba.fastjson.JSONObject;
import com.example.admit.poneco.com.MySQL.MySQLAPI;
import com.example.admit.poneco.com.analysisData.Analysis;
import com.example.admit.poneco.com.requestData.dataRead;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class searchCount {
    private JSONArray jsonArray = null;
    public JSONArray getJson(HttpServletRequest request, String idName){
        MySQLAPI mySQLAPI = new MySQLAPI();
        Analysis analysis = new Analysis();
        dataRead dataRead = new dataRead();
        analysis.setRequest(request);
        analysis.setJOSN(dataRead.getData(request));
        mySQLAPI.setSQL(analysis.getSQL(idName));
        ResultSet resultSet = mySQLAPI.getRst();
        List list = new ArrayList();
        int number;
        Map map = new HashMap();
        try {
            while (resultSet.next()){
                number= Integer.parseInt(resultSet.getString(1));
                map.put("counts",number);
                list.add(map);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Gson gson = new Gson();
        try {
            jsonArray = new JSONArray(gson.toJson(list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
