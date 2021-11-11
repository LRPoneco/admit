package com.example.admit.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface face {
    /**
     *
     * @param request
     * @return
     */
    public boolean main(HttpServletRequest request, HttpServletResponse response);
    public boolean dao(HttpServletRequest request,HttpServletResponse response);
}
