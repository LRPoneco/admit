package com.example.admit.poneco.com.analysisData;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import com.example.admit.poneco.com.config.XMLRead;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句文件解析器加载
 * SQL语句关键词总结
 * 查询语句select {需要查询的内容} from {表名称} where {查询条件}
 * 删除语句delete from {表名} where {删除条件}
 * 增加语句inert into {表名({需要操作的列名}) values({输入的数据值})
 * update {表名} {列名}={输入的修改值} set where {修改条件}
 * 重点SQL语句中各个关键词要用空格隔开
 */

/**
 * DOM方式解析xml
 */
public class Analysis extends autoSystem implements AnalysisInterface{
    private XMLRead xmlRead = new XMLRead();
    private JSONArray JOSN;//定义一个存储查询语句的JSON数据
    private String SQL;//定义一个SQL语句存储值
    private HttpServletRequest request;
    public void setJOSN(JSONArray JOSN) {
        this.JOSN = JOSN;
    }
    public void setRequest(HttpServletRequest request){
        this.request = request;
    }
    /**
     * 提供外部需要的SQL语句
     * @param idName  SQL语句再SQL文件中储存的名称
     * @return  返回SQL语句
     */
    public String getSQL(String idName){
        SQL = xmlRead.getValue(idName);
        List list = getUseValue(SQL);
        String str0;
        String xt="";
        try {
            for(Object ignored : list){
                xt = ignored.toString();
                /*提取字符串数据名称控制器加载输出名称str0*/
                /*存储SQL语句中的查询条件值*/
                if(xt.equals("{autoTime}")){
                    str0 ="'"+getSystemTime("yyy-MM-dd")+"'";//拼接加载SQL语句
                }else if(xt.indexOf("autoID")>0){
                    str0 = "'"+getRan(Integer.parseInt(getRemark(xt)))+"'";//拼接加载SQL语句
                }else if(xt.indexOf("session")>0){
                    str0 = "'"+ getSession(this.request,getRemark(xt))+"'";
                }else if(xt.equals("{!}")){
                    str0="'0'";
                } else if(xt.indexOf("%")>0){
                    str0 = "'"+this.JOSN.getJSONObject(0).getString(xt.substring(xt.indexOf("{")+1,xt.indexOf("%")))+"%'";//模糊查询功能
                }else if(xt.indexOf("?")>0){//条件判断，是否满足登录条件，加注权限防止越权操作关键词?
                    String strp = (String) request.getSession().getAttribute(xt.substring(xt.indexOf("?")+1,xt.indexOf("}")));
                    str0 = "";
                    if(strp!=null){
                        str0 = "";
                    }else {
                        str0 = "妈的，乱访问！你操作不了数据库;";
                        System.out.print("管理员注意啦！！！！！！！！！！！");
                        break;
                    }
                }else if(xt.indexOf("@")>0){
                    JSONArray json = (JSONArray) request.getSession().getAttribute("admit");
                    String str5 = json.getJSONObject(0).getString(xt.substring(xt.indexOf("@")+1,xt.indexOf("}")));
                    if(str5.equals(xt.substring(xt.indexOf("{")+1,xt.indexOf("@")))){
                        str0 = "";
                    }else {
                        str0 ="越权操作";
                    }

                }else if(xt.indexOf("{")!=-1&&xt.indexOf("}")!=-1){
                    str0 = "'"+this.JOSN.getJSONObject(0).getString(xt.substring(xt.indexOf("{")+1,xt.indexOf("}")))+"'";
                }else{
                    str0="";
                }
                if(xt.indexOf("{")!=-1&&xt.indexOf("}")!=-1){
                    SQL = SQL.replace(xt,str0);//拼接加载SQL语句
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            SQL ="报错的我好伤心！...";
        }
        return SQL;
    }

    /**
     * 解析字符串中需要更改的数据项
     * 语法{字符名}
     * @param str SQL语句的字符串
     * @return
     */
    public List<String> getUseValue(String str){
        List<String> list = new ArrayList();
        String[] str0 = str.split(" ");
        for(int i=0;i<str0.length;i++){
            System.out.println(str0[i].indexOf("{"));
            if(str0[i].indexOf("{")>0||str0[i].indexOf("{")==0){
                String str1 = str0[i].substring(str0[i].indexOf("{"),str0[i].length());
                list.add(str1);
            }
        }
        return list;
    }
}
