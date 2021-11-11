package com.example.admit.dao.admit;

import com.example.admit.dao.face;
import com.example.admit.poneco.com.MySQL.MySQLAPI;
import com.example.admit.poneco.com.analysisData.Analysis;
import com.example.admit.poneco.com.requestData.dataRead;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class admitLogin implements face {
    @Override
    public boolean main(HttpServletRequest request, HttpServletResponse response) {
        return dao(request,response);
    }

    @Override
    public boolean dao(HttpServletRequest request,HttpServletResponse response) {
        boolean alex = false;
        MySQLAPI mySQLAPI = new MySQLAPI();
        Analysis analysis = new Analysis();
        dataRead dataRead = new dataRead();
        analysis.setRequest(request);
        analysis.setJOSN(dataRead.getData(request));
        mySQLAPI.setSQL(analysis.getSQL("Login"));
        System.out.print(analysis.getSQL("Login"));
        ResultSet resultSet = mySQLAPI.getRst();
        try {
            while (resultSet.next()){
                Map map = new HashMap();
                map.put("admitID",resultSet.getString("admitID"));
                map.put("Mail",resultSet.getString("Mail"));
                map.put("phone",resultSet.getString("phone"));
                map.put("name",resultSet.getString("name"));
                map.put("sex",resultSet.getString("sex"));
                map.put("rank",resultSet.getString("rank"));
                map.put("state",resultSet.getString("state"));
                List list = new ArrayList();
                list.add(map);
                Gson gson = new Gson();
                try{
                    JSONArray jsonArray = new JSONArray(gson.toJson(list));
                    request.getSession().setAttribute("admit",jsonArray);
                    request.getSession().setAttribute("admitID",map.get("admitID"));
                    response.sendRedirect("/webapp/index.html");
                    alex = true;
                }catch (Exception e){
                }
            }
        } catch (SQLException e) {
            mySQLAPI.Close();
            e.printStackTrace();
        }
        mySQLAPI.Close();
        try{
            if(alex){
            }else {
                response.sendRedirect("/fail.html");
            }
        }catch (Exception e){
        }
        return alex;
    }
}