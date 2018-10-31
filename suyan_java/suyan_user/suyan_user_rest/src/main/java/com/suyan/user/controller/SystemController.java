package com.suyan.user.controller;

import com.suyan.user.convertor.SystemConvertor;
import com.suyan.user.req.SystemDTO;
import com.suyan.user.req.SystemQueryDTO;
import com.suyan.user.resp.SystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.ISystemService;
import com.suyan.user.vo.SystemQueryVO;
import com.suyan.user.vo.SystemVO;
import com.suyan.user.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("system")
@RestController
@Api(value = "system", description = "系统管理接口")
public class SystemController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(SystemController.class);
    
    @Autowired
    private ISystemService systemService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
             })
    @ApiOperation(value = "deleteSystem/{id}", notes = "删除系统")
    @RequestMapping(value = "deleteSystem/{id}", method = { RequestMethod.POST })
    public UserResult<Integer> deleteSystem(@PathVariable Integer id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = systemService.deleteSystem(id);
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
    @ApiOperation(value = "createSystem", notes = "创建系统")
    @RequestMapping(value = "createSystem", method = { RequestMethod.POST })
    public UserResult<Integer> createSystem(@Valid @RequestBody SystemVO systemVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            SystemDTO systemDTO = SystemConvertor.toSystemDTO(systemVO);
            UserVO user = getUser();
            systemDTO.setCreateUser(user.getOpenId());
            systemDTO.setCreateUserName(user.getNickName());
            systemDTO.setUpdateUser(user.getOpenId());
            systemDTO.setUpdateUserName(user.getNickName());
            result = systemService.createSystem(systemDTO);
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
    @ApiOperation(value = "updateSystem", notes = "更新系统")
    @RequestMapping(value = "updateSystem", method = { RequestMethod.POST })
    public UserResult<Integer> updateSystem(@Valid @RequestBody SystemVO systemVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            SystemDTO systemDTO = SystemConvertor.toSystemDTO(systemVO);
            UserVO user = getUser();
            systemDTO.setCreateUser(null);
            systemDTO.setCreateUserName(null);
            systemDTO.setUpdateUser(user.getOpenId());
            systemDTO.setUpdateUserName(user.getNickName());
            result = systemService.updateSystem(systemDTO);
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
    @ApiOperation(value = "getSystem/{id}", notes = "根据系统ID获取系统信息")
    @RequestMapping(value = "getSystem/{id}", method = { RequestMethod.GET })
    public UserResult<SystemODTO> getSystem(@PathVariable Integer id ){
        UserResult<SystemODTO> result = UserResult.newSuccess();
        try {
            result = systemService.getSystem(id);
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
    @ApiOperation(value = "querySystem", notes = "分页获取系统列表信息")
    @RequestMapping(value = "querySystem", method = { RequestMethod.POST })
    UserResult<QueryResultODTO<SystemODTO>> querySystem(@Valid @RequestBody SystemQueryVO systemQueryVO){
        UserResult<QueryResultODTO<SystemODTO>> result = UserResult.newSuccess();
        try {
            SystemQueryDTO systemQueryDTO = SystemConvertor.toSystemQueryDTO(systemQueryVO);
            result = systemService.querySystem(systemQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
