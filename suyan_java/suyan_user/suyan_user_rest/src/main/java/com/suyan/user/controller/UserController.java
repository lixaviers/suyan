package com.suyan.user.controller;

import com.suyan.user.convertor.UserConvertor;
import com.suyan.user.req.UserDTO;
import com.suyan.user.req.UserQueryDTO;
import com.suyan.user.resp.UserODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IUserService;
import com.suyan.user.vo.UserQueryVO;
import com.suyan.user.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("user")
@RestController
@Api(value = "user", description = "用户管理接口")
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value = "getUserInfo", notes = "获取用户信息 ")
    @RequestMapping(value = "getUserInfo", method = { RequestMethod.POST })
    public UserResult<UserVO> getUserInfo() {
        UserResult<UserVO> result = UserResult.newSuccess();
        try {
            result.setDataMap(getUser());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "deleteUser", notes = "删除用户")
    @RequestMapping(value = "deleteUser", method = {RequestMethod.POST})
    public UserResult<Integer> deleteUser(@Valid @RequestBody List<Long> idList) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = userService.deleteUser(idList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "createUser", notes = "创建用户")
    @RequestMapping(value = "createUser", method = {RequestMethod.POST})
    public UserResult<Long> createUser(@Valid @RequestBody UserVO userVO) {
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
            UserDTO userDTO = UserConvertor.toUserDTO(userVO);
            UserVO user = getUser();
            userDTO.setUserPwd(passwordEncoder.encode(userVO.getUserPwd()));
            userDTO.setCreateUser(user.getOpenId());
            userDTO.setCreateUserName(user.getNickName());
            userDTO.setUpdateUser(user.getOpenId());
            userDTO.setUpdateUserName(user.getNickName());
            result = userService.createUser(userDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "updateUser", notes = "更新用户")
    @RequestMapping(value = "updateUser", method = {RequestMethod.POST})
    public UserResult<Integer> updateUser(@Valid @RequestBody UserVO userVO) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserDTO userDTO = UserConvertor.toUserDTO(userVO);
            UserVO user = getUser();
            userDTO.setCreateUser(null);
            userDTO.setCreateUserName(null);
            userDTO.setUpdateUser(user.getOpenId());
            userDTO.setUpdateUserName(user.getNickName());
            result = userService.updateUser(userDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "getUser/{id}", notes = "根据用户ID获取用户信息")
    @RequestMapping(value = "getUser/{id}", method = {RequestMethod.GET})
    public UserResult<UserODTO> getUser(@PathVariable Long id) {
        UserResult<UserODTO> result = UserResult.newSuccess();
        try {
            result = userService.getUser(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "queryUser", notes = "分页获取用户列表信息")
    @RequestMapping(value = "queryUser", method = {RequestMethod.POST})
    UserResult<QueryResultODTO<UserODTO>> queryUser(@Valid @RequestBody UserQueryVO userQueryVO) {
        UserResult<QueryResultODTO<UserODTO>> result = UserResult.newSuccess();
        try {
            UserQueryDTO userQueryDTO = UserConvertor.toUserQueryDTO(userQueryVO);
            result = userService.queryUser(userQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }

}
