package com.codecrane.core.web;

import javax.servlet.http.HttpServletRequest;

/**
 * Request工具类
 * Created by crane on 16/6/23.
 */
public class RequestUtils {

    public static boolean isIE(HttpServletRequest request) {
        return request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0
                || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0
                || request.getHeader("USER-AGENT").toLowerCase().indexOf("edge") > 0;
    }
}
