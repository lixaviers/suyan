package com.suyan.user.server.authentication;

import com.suyan.user.result.UserResult;
import com.suyan.user.server.util.ResponseUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Component("userLogoutSuccessHandle")
public class UserLogoutSuccessHandle implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("退出成功");

        Object details = authentication.getDetails();

        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();

        Enumeration<String> headerNames = request.getHeaderNames();


        new SecurityContextLogoutHandler().logout(request, response, authentication);
        SecurityContextHolder.clearContext();  //清空上下文

        String ajax = request.getHeader("ajax");
        if (StringUtils.isNotBlank(ajax) && "true".equals(ajax)) {
            ResponseUtil.setJsonContent(response, UserResult.newSuccess());
        }else {
            response.sendRedirect("http://login.suyan.com/login.html");
//            response.sendRedirect(request.getHeader("referer"));
        }

    }
}
