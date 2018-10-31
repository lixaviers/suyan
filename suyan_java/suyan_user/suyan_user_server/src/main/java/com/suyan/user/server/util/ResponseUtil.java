package com.suyan.user.server.util;

import com.alibaba.fastjson.JSON;
import com.suyan.user.result.UserResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

    public static void setJsonContent(HttpServletResponse response, UserResult<?> result) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

}
