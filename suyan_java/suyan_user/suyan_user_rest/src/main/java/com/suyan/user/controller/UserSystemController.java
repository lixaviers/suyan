package com.suyan.user.controller;

import com.suyan.user.convertor.UserSystemConvertor;
import com.suyan.user.req.UserSystemDTO;
import com.suyan.user.req.UserSystemQueryDTO;
import com.suyan.user.resp.UserSystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IUserSystemService;
import com.suyan.user.vo.UserSystemQueryVO;
import com.suyan.user.vo.UserSystemVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("userSystem")
@RestController
@Api(value = "userSystem", description = "用户系统管理接口")
public class UserSystemController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserSystemController.class);
    
    @Autowired
    private IUserSystemService userSystemService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
             })
    @ApiOperation(value = "deleteUserSystem/{id}", notes = "删除用户系统")
    @RequestMapping(value = "deleteUserSystem/{id}", method = { RequestMethod.POST })
    public UserResult<Integer> deleteUserSystem(@PathVariable Long id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = userSystemService.deleteUserSystem(id);
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
    @ApiOperation(value = "createUserSystem", notes = "创建用户系统")
    @RequestMapping(value = "createUserSystem", method = { RequestMethod.POST })
    public UserResult<Long> createUserSystem(@Valid @RequestBody UserSystemVO userSystemVO){
        UserResult<Long> result = UserResult.newSuccess();
        try {
            UserSystemDTO userSystemDTO = UserSystemConvertor.toUserSystemDTO(userSystemVO);
            result = userSystemService.createUserSystem(userSystemDTO);
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
    @ApiOperation(value = "updateUserSystem", notes = "更新用户系统")
    @RequestMapping(value = "updateUserSystem", method = { RequestMethod.POST })
    public UserResult<Integer> updateUserSystem(@Valid @RequestBody UserSystemVO userSystemVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserSystemDTO userSystemDTO = UserSystemConvertor.toUserSystemDTO(userSystemVO);
            result = userSystemService.updateUserSystem(userSystemDTO);
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
    @ApiOperation(value = "getUserSystem/{id}", notes = "根据用户系统ID获取用户系统信息")
    @RequestMapping(value = "getUserSystem/{id}", method = { RequestMethod.GET })
    public UserResult<UserSystemODTO> getUserSystem(@PathVariable Long id ){
        UserResult<UserSystemODTO> result = UserResult.newSuccess();
        try {
            result = userSystemService.getUserSystem(id);
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
    @ApiOperation(value = "queryUserSystem", notes = "分页获取用户系统列表信息")
    @RequestMapping(value = "queryUserSystem", method = { RequestMethod.POST })
    UserResult<QueryResultODTO<UserSystemODTO>> queryUserSystem(@Valid @RequestBody UserSystemQueryVO userSystemQueryVO){
        UserResult<QueryResultODTO<UserSystemODTO>> result = UserResult.newSuccess();
        try {
            UserSystemQueryDTO userSystemQueryDTO = UserSystemConvertor.toUserSystemQueryDTO(userSystemQueryVO);
            result = userSystemService.queryUserSystem(userSystemQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
