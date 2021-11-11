package com.example.admit.poneco;

import com.alibaba.fastjson.JSONObject;
public class main {
    public static void main(String[] arg){


        String str1 ="<td>工号</td>\n" +
                "        <td>电话</td>\n" +
                "        <td>邮箱</td>\n" +
                "        <td>姓名</td>\n" +
                "        <td>密码</td>\n" +
                "        <td>性别</td>\n" +
                "        <td>职位</td>\n" +
                "        <td>状态</td>\n" +
                "        <td>入职时间</td>\n";
        for(int i=0;i<15;i++){
            String[] st = str1.split("\n");
            System.out.print("<tr>\n"+st[i] + "<input value=\""+st[i]+"\" class=\"text\">\n");
        }
    }
}