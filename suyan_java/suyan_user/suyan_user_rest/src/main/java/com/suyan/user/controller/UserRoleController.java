package com.suyan.user.controller;

import com.suyan.user.convertor.UserRoleConvertor;
import com.suyan.user.req.UserRoleDTO;
import com.suyan.user.req.UserRoleQueryDTO;
import com.suyan.user.resp.UserRoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IUserRoleService;
import com.suyan.user.vo.UserRoleQueryVO;
import com.suyan.user.vo.UserRoleVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("userRole")
@RestController
@Api(value = "userRole", description = "用户角色管理接口")
public class UserRoleController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
    
    @Autowired
    private IUserRoleService userRoleService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
             })
    @ApiOperation(value = "deleteUserRole/{id}", notes = "删除用户角色")
    @RequestMapping(value = "deleteUserRole/{id}", method = { RequestMethod.POST })
    public UserResult<Integer> deleteUserRole(@PathVariable Long id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = userRoleService.deleteUserRole(id);
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
    @ApiOperation(value = "createUserRole", notes = "创建用户角色")
    @RequestMapping(value = "createUserRole", method = { RequestMethod.POST })
    public UserResult<Long> createUserRole(@Valid @RequestBody UserRoleVO userRoleVO){
        UserResult<Long> result = UserResult.newSuccess();
        try {
            UserRoleDTO userRoleDTO = UserRoleConvertor.toUserRoleDTO(userRoleVO);
            result = userRoleService.createUserRole(userRoleDTO);
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
    @ApiOperation(value = "updateUserRole", notes = "更新用户角色")
    @RequestMapping(value = "updateUserRole", method = { RequestMethod.POST })
    public UserResult<Integer> updateUserRole(@Valid @RequestBody UserRoleVO userRoleVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserRoleDTO userRoleDTO = UserRoleConvertor.toUserRoleDTO(userRoleVO);
            result = userRoleService.updateUserRole(userRoleDTO);
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
    @ApiOperation(value = "getUserRole/{id}", notes = "根据用户角色ID获取用户角色信息")
    @RequestMapping(value = "getUserRole/{id}", method = { RequestMethod.GET })
    public UserResult<UserRoleODTO> getUserRole(@PathVariable Long id ){
        UserResult<UserRoleODTO> result = UserResult.newSuccess();
        try {
            result = userRoleService.getUserRole(id);
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
    @ApiOperation(value = "queryUserRole", notes = "分页获取用户角色列表信息")
    @RequestMapping(value = "queryUserRole", method = { RequestMethod.POST })
    UserResult<QueryResultODTO<UserRoleODTO>> queryUserRole(@Valid @RequestBody UserRoleQueryVO userRoleQueryVO){
        UserResult<QueryResultODTO<UserRoleODTO>> result = UserResult.newSuccess();
        try {
            UserRoleQueryDTO userRoleQueryDTO = UserRoleConvertor.toUserRoleQueryDTO(userRoleQueryVO);
            result = userRoleService.queryUserRole(userRoleQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
