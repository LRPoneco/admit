package com.example.admit.poneco.com.requestData;

import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 前段数据获取层
 * @author 杨鹏飞
 *
 */
public class dataRead {
    /**
     * 取出所有传输的数据 文字数据
     * @param request 请求数据
     * @return
     */
    private Map map = new HashMap();
    public JSONArray getData(HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        JSONArray jsonArray=null;
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            map.put(paraName,request.getParameter(paraName));
        }
        list.add(map);
        Gson gson = new Gson();
        try {
            jsonArray = new JSONArray(gson.toJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jsonArray);
        return jsonArray;
    }
}
