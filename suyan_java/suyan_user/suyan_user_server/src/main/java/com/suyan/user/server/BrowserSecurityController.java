package com.suyan.user.server;

import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    // spring跳转工具
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login/action")
    public UserResult requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是：", targetUrl);
        }

        /*
        if (!RequestUtil.checkAjaxRequest(request)) {
            // 跳转
            redirectStrategy.sendRedirect(request, response, "/login.html");
        }*/

        UserResult result = UserResult.newError(UserResultCode.NO_LOGGED_IN);
        return result;
    }

    @GetMapping("/user")
    public UserResult user(Authentication authentication) throws Exception {
        return UserResult.newSuccess(authentication);
    }

    /**
     * session失效
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/session/invalid")
    public UserResult sessionInvalid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserResult result = UserResult.newError(UserResultCode.SESSION_INVALID_ERROR);
        return result;
    }
}
