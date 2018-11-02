package com.suyan.goods.interceptor;

import com.alibaba.fastjson.JSON;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.vo.UserVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Component("adminInterceptor")
public class AdminInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // session key
    @Value("${user.key}")
    private String userKey;

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            // 打印日志
            logger.info("requestUri：{},contextPath：{},parameterNames：{}", request.getRequestURI(), request.getContextPath(), JSON.toJSONString(request.getParameterMap()));


            HttpSession session = request.getSession();
            Object object = session.getAttribute(userKey);
            if (null != object) {
                logger.info("session user：" + JSON.toJSONString(object));
                return true;
            }
            String header = request.getHeader("Authorization");
            String token = StringUtils.substringAfter(header, "bearer ");

            Claims claims = Jwts.parser().setSigningKey(jwtKey.getBytes("UTF-8"))
                    .parseClaimsJws(token).getBody();
            String nickName = (String) claims.get("nickName");
            String openId = (String) claims.get("openId");

            UserVO userVO = new UserVO();
            userVO.setOpenId(openId);
            userVO.setNickName(nickName);
            String userStr = JSON.toJSONString(userVO);
            logger.info("user:" + userStr);
            session.setAttribute(userKey, userStr);
            return true;


        } catch (Exception e) {
            returnErrorJson(response, JSON.toJSONString(Result.newError(ResultCode.SYS_ERROR)));
            return false;
        }

    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }


    private void returnErrorJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            logger.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
