package com.example.admit.poneco;

import com.example.admit.poneco.com.MySQL.MySQLAPI;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class tes1 {
    public static void main(String[] args){
        MySQLAPI mySQLAPI = new MySQLAPI();
        mySQLAPI.setSQL("select count(*) from information where state='1' and '78269'");
        ResultSet resultSet = mySQLAPI.getRst();
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
