package com.suyan.user.server.controller;

import com.suyan.user.constant.Constants;
import com.suyan.user.req.UserDTO;
import com.suyan.user.resp.UserPermissionsODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.server.vo.UserVO;
import com.suyan.user.service.IResourceService;
import com.suyan.user.service.IUserService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/user")
@RestController
public class ServerUserController {
    private final Logger logger = LoggerFactory.getLogger(ServerUserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IResourceService resourceService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "/getResourceUrl", notes = "查询用户所有权限")
    @RequestMapping(value = "/getResourceUrl", method = {RequestMethod.GET})
    public UserResult<UserPermissionsODTO> getUserInfo(Principal principal) {
        UserResult<UserPermissionsODTO> result = UserResult.newSuccess();
        try {
            result = resourceService.getResourceUrlByUserOpenId(principal.getName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }


    @ApiOperation(value = "/logout", notes = "退出")
    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public UserResult logout(Principal principal, HttpServletRequest request) {

        UserResult result = UserResult.newSuccess();
        tokenStore.removeAccessToken(tokenStore.getAccessToken((OAuth2Authentication) principal));
        request.getSession().removeAttribute(Constants.USER_SESSION_KEY);

        return result;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "/regist", notes = "创建用户")
    @RequestMapping(value = "/regist", method = {RequestMethod.POST})
    public UserResult<Long> regist(@Valid @RequestBody UserVO userVO) {
        UserResult<Long> result = UserResult.newSuccess();
        try {
            userVO.setUserName(userVO.getUserName() == null ? null : userVO.getUserName().trim());
            if (StringUtils.length(userVO.getUserName()) < 6 || StringUtils.length(userVO.getUserName()) > 16) {
                result.setErrorCode(UserResultCode.COMMON_PARAM_INVALID, "用户名");
                return result;
            }
            if (StringUtils.length(userVO.getUserPwd()) < 6 || StringUtils.length(userVO.getUserPwd()) > 16) {
                result.setErrorCode(UserResultCode.COMMON_PARAM_INVALID, "密码");
                return result;
            }
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(userVO.getUserName());
            userDTO.setUserPwd(passwordEncoder.encode(userVO.getUserPwd()));
            result = userService.createUser(userDTO);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

}
