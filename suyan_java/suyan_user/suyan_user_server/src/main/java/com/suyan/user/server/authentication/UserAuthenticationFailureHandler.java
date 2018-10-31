package com.suyan.user.server.authentication;

import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.server.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("userAuthenticationFailureHandler")
public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        logger.warn("登录失败:", exception);

        String message = "登录失败";
        if (exception instanceof LockedException) {
            message = "用户被删除";
        } else if (exception instanceof BadCredentialsException) {
            message = "用户名和密码不匹配";
        } else if (exception instanceof AccountExpiredException) {
            message = "用户被禁用";
        } // ...

        UserResult result = UserResult.newError(UserResultCode.COMMON_MESSAGE);
        result.setMessage(message);
        ResponseUtil.setJsonContent(response, result);

    }

}
