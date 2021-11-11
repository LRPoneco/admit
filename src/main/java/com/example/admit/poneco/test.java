package com.example.admit.poneco;

import com.example.admit.poneco.com.MySQL.MySQLAPI;
import com.example.admit.poneco.com.analysisData.Analysis;
import com.example.admit.poneco.com.requestData.dataRead;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args){
        MySQLAPI mySQLAPI = new MySQLAPI();
        mySQLAPI.setSQL("select * from admit");
        ResultSet resultSet = mySQLAPI.getRst();
        String str1 ="<td>工号</td>\n" +
                "        <td>电话</td>\n" +
                "        <td>邮箱</td>\n" +
                "        <td>姓名</td>\n" +
                "        <td>密码</td>\n" +
                "        <td>性别</td>\n" +
                "        <td>职位</td>\n" +
                "        <td>状态</td>\n" +
                "        <td>入职时间</td>\n";
        String[] st = str1.split("\n");

        try {
            String st1 ="update admit set ";
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                for(int i=0;i<resultSetMetaData.getColumnCount();i++){
                    System.out.print("<tr>\n"+st[i] + "\n<td><input id=\""+resultSetMetaData.getColumnName(i+1)+"\" class=\"text\">\n</td>\n</tr>\n");
                }
                System.out.print(st1);
                break;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
