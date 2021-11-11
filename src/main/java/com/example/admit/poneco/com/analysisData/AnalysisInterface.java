package com.example.admit.poneco.com.analysisData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AnalysisInterface {
    String SQL = "";//定义一个SQL语句存储值
    HttpServletRequest request = null;
    /**
     * 提供外部需要的SQL语句
     * @param idName  SQL语句再SQL文件中储存的名称
     * @return  返回SQL语句
     */
    String getSQL(String idName);
    /**
     * 解析字符串中需要更改的数据项
     * 语法{字符名}
     * @param str SQL语句的字符串
     * @return
     */
    List<String> getUseValue(String str);
    void setRequest(HttpServletRequest request);
}
