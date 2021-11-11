package com.example.admit.poneco.com.MySQL;

import com.example.admit.poneco.com.config.ReadConfigData;

import java.sql.*;
import java.util.Random;

public class MySQLAPI{
    private ResultSet rst;
    private Connection con;
    private Statement stm;
    private String SQL;
    private ReadConfigData readConfigData ;

    public MySQLAPI(){
        readConfigData = new ReadConfigData();
    }
    /**
     * 载入SQL语句
     * @param SQL SQL语句内容
     */
    public void setSQL(String SQL){
        this.SQL = SQL;
    }
    /**
     * 数据库建表、数据删除、数据更新修改、数据添加操作函数
     * @return
     */
    public boolean Operation(){
        boolean alex = false;
        try {
            /*加载数据库连接驱动*/
            selverlet();
            stm.executeUpdate(SQL);
            Close();
            alex = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close();
        }
        return alex;
    }

    /**
     * 获取查询数据的结果集
     * @return 返回查询结果集
     */
    public ResultSet getRst(){
        /*加载数据库连接驱动*/
        selverlet();
        try {
            rst = stm.executeQuery(SQL);
        } catch (SQLException e) {
            Close();
            e.printStackTrace();
        }
        return rst;
    }
    /**
     * 数据库连接关闭操作
     */
    public void Close(){
        try {
            if (con!=null){
                con.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(rst!=null){
                rst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 数据库连接加载
     */
    private void selverlet(){
        try {
            Class.forName(readConfigData.getConfigData("driver"));
            con = DriverManager.getConnection(readConfigData.getConfigData("url"),readConfigData.getConfigData("username"),readConfigData.getConfigData("password"));
            stm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public String getID(int number){
        String alex = "";
        Random ran = new Random();
        for(int i=0;i<number;i++){
            alex += ran.nextInt(10);
        }
        return alex;
    }
}