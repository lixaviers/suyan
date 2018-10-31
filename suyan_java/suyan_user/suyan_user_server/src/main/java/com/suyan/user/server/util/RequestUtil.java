package com.suyan.user.server.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    public static boolean checkAjaxRequest(HttpServletRequest request) {
        String ajax = request.getHeader("ajax");
        if (StringUtils.isBlank(ajax) || !"true".equals(ajax)) {
            return false;
        }
        return true;
    }

}
