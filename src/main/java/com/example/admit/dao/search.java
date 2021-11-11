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

public class search{
    private JSONArray jsonArray = null;
    private int page;
    private int pagesize;
    public search(String str){
        JSONObject jsonObject = JSONObject.parseObject(str);
        pagesize = jsonObject.getIntValue("pagesize");
        page = jsonObject.getIntValue("page")-1;
    }
    public JSONArray getJson(HttpServletRequest request, String idName){
        MySQLAPI mySQLAPI = new MySQLAPI();
        Analysis analysis = new Analysis();
        dataRead dataRead = new dataRead();
        analysis.setRequest(request);
        analysis.setJOSN(dataRead.getData(request));
        mySQLAPI.setSQL(analysis.getSQL(idName));
        ResultSet resultSet = mySQLAPI.getRst();
        List list = new ArrayList();
        int number=1;
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                Map map = new HashMap();
                if(alexPage(number)){
                    for(int i=0;i<resultSetMetaData.getColumnCount();i++){
                        String str = resultSetMetaData.getColumnName(i+1);
                        map.put(str,resultSet.getString(str));
                    }
                    list.add(map);
                }else {
                    number++;
                }
                /*if(number==pagesize){
                    break;
                }*/
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
    public boolean alexPage(int n){
        int a = pagesize*page , b=page*pagesize+pagesize;
        if(a<n&&n<b){
            return true;
        } else {
            return false;
        }
    }
}
