package com.suyan.goods.Controller;

import com.alibaba.fastjson.JSON;
import com.suyan.goods.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    private final Logger logger = LoggerFactory.getLogger(BaseController.class);
    // session key
    @Value("${user.key}")
    private String userKey;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession(false);
    }

    /**
     * 获取登录用户
     *
     * @return
     */
    protected UserVO getUser() {

        Object object = session.getAttribute(userKey);
        if (null != object) {
            logger.info("user：" + JSON.toJSONString(object));
            UserVO userVO = JSON.parseObject(object.toString(), UserVO.class);
            request.setAttribute("user", userVO);
            return userVO;
        }
        logger.error("BaseControllerError：当出现此错误时，表示拦截器中拦截用户的操作失败，请查明原因!");
        return new UserVO();

    }


}
