package com.suyan.user.controller;

import com.suyan.user.convertor.RoleConvertor;
import com.suyan.user.req.RoleDTO;
import com.suyan.user.req.RoleQueryDTO;
import com.suyan.user.resp.RoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IRoleService;
import com.suyan.user.vo.RoleQueryVO;
import com.suyan.user.vo.RoleVO;
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

@RequestMapping("role")
@RestController
@Api(value = "role", description = "角色管理接口")
public class RoleController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    
    @Autowired
    private IRoleService roleService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
             })
    @ApiOperation(value = "deleteRole/{id}", notes = "删除角色")
    @RequestMapping(value = "deleteRole/{id}", method = { RequestMethod.POST })
    public UserResult<Integer> deleteRole(@PathVariable Integer id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = roleService.deleteRole(id);
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
    @ApiOperation(value = "createRole", notes = "创建角色")
    @RequestMapping(value = "createRole", method = { RequestMethod.POST })
    public UserResult<Integer> createRole(@Valid @RequestBody RoleVO roleVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserVO user = getUser();
            RoleDTO roleDTO = RoleConvertor.toRoleDTO(roleVO);
            roleDTO.setCreateUser(user.getOpenId());
            roleDTO.setCreateUserName(user.getNickName());
            roleDTO.setUpdateUser(user.getOpenId());
            roleDTO.setUpdateUserName(user.getNickName());
            result = roleService.createRole(roleDTO);
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
    @ApiOperation(value = "updateRole", notes = "更新角色")
    @RequestMapping(value = "updateRole", method = { RequestMethod.POST })
    public UserResult<Integer> updateRole(@Valid @RequestBody RoleVO roleVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserVO user = getUser();
            RoleDTO roleDTO = RoleConvertor.toRoleDTO(roleVO);
            roleDTO.setUpdateUser(user.getOpenId());
            roleDTO.setUpdateUserName(user.getNickName());
            result = roleService.updateRole(roleDTO);
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
    @ApiOperation(value = "getRole/{id}", notes = "根据角色ID获取角色信息")
    @RequestMapping(value = "getRole/{id}", method = { RequestMethod.GET })
    public UserResult<RoleODTO> getRole(@PathVariable Integer id ){
        UserResult<RoleODTO> result = UserResult.newSuccess();
        try {
            result = roleService.getRole(id);
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
    @ApiOperation(value = "queryRole", notes = "分页获取角色列表信息")
    @RequestMapping(value = "queryRole", method = { RequestMethod.POST })
    UserResult<QueryResultODTO<RoleODTO>> queryRole(@Valid @RequestBody RoleQueryVO roleQueryVO){
        UserResult<QueryResultODTO<RoleODTO>> result = UserResult.newSuccess();
        try {
            RoleQueryDTO roleQueryDTO = RoleConvertor.toRoleQueryDTO(roleQueryVO);
            result = roleService.queryRole(roleQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
