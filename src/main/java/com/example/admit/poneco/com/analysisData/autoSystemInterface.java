package com.example.admit.poneco.com.analysisData;

import com.example.admit.poneco.com.ConfigPath;

import javax.servlet.http.HttpServletRequest;

public interface autoSystemInterface extends ConfigPath {
    /**
     * 自动加载随机参数
     * @param Length
     * @return
     */
    public String getRan(int Length);

    /**
     * 获取系统时间
     * @param TimeType
     * @return
     */
    public String getSystemTime(String TimeType);

    /**
     * 获取自动会话值
     * @param request
     * @param sessionName
     * @return
     */
    public String getSession(HttpServletRequest request, String sessionName);

    /**
     * 获取自动命令
     * @param str
     * @return
     */
    public String getRemark(String str);
}
