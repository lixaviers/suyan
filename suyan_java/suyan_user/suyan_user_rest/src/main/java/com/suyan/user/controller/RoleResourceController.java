package com.suyan.user.controller;

import com.suyan.user.convertor.RoleResourceConvertor;
import com.suyan.user.req.RoleResourceDTO;
import com.suyan.user.req.RoleResourceQueryDTO;
import com.suyan.user.resp.RoleResourceODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IRoleResourceService;
import com.suyan.user.vo.RoleResourceQueryVO;
import com.suyan.user.vo.RoleResourceVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("roleResource")
@RestController
@Api(value = "roleResource", description = "角色资源管理接口")
public class RoleResourceController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(RoleResourceController.class);
    
    @Autowired
    private IRoleResourceService roleResourceService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
             })
    @ApiOperation(value = "deleteRoleResource/{id}", notes = "删除角色资源")
    @RequestMapping(value = "deleteRoleResource/{id}", method = { RequestMethod.POST })
    public UserResult<Integer> deleteRoleResource(@PathVariable Long id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = roleResourceService.deleteRoleResource(id);
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
    @ApiOperation(value = "createRoleResource", notes = "创建角色资源")
    @RequestMapping(value = "createRoleResource", method = { RequestMethod.POST })
    public UserResult<Long> createRoleResource(@Valid @RequestBody RoleResourceVO roleResourceVO){
        UserResult<Long> result = UserResult.newSuccess();
        try {
            RoleResourceDTO roleResourceDTO = RoleResourceConvertor.toRoleResourceDTO(roleResourceVO);
            result = roleResourceService.createRoleResource(roleResourceDTO);
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
    @ApiOperation(value = "updateRoleResource", notes = "更新角色资源")
    @RequestMapping(value = "updateRoleResource", method = { RequestMethod.POST })
    public UserResult<Integer> updateRoleResource(@Valid @RequestBody RoleResourceVO roleResourceVO){
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            RoleResourceDTO roleResourceDTO = RoleResourceConvertor.toRoleResourceDTO(roleResourceVO);
            result = roleResourceService.updateRoleResource(roleResourceDTO);
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
    @ApiOperation(value = "getRoleResource/{id}", notes = "根据角色资源ID获取角色资源信息")
    @RequestMapping(value = "getRoleResource/{id}", method = { RequestMethod.GET })
    public UserResult<RoleResourceODTO> getRoleResource(@PathVariable Long id ){
        UserResult<RoleResourceODTO> result = UserResult.newSuccess();
        try {
            result = roleResourceService.getRoleResource(id);
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
    @ApiOperation(value = "queryRoleResource", notes = "分页获取角色资源列表信息")
    @RequestMapping(value = "queryRoleResource", method = { RequestMethod.POST })
    UserResult<QueryResultODTO<RoleResourceODTO>> queryRoleResource(@Valid @RequestBody RoleResourceQueryVO roleResourceQueryVO){
        UserResult<QueryResultODTO<RoleResourceODTO>> result = UserResult.newSuccess();
        try {
            RoleResourceQueryDTO roleResourceQueryDTO = RoleResourceConvertor.toRoleResourceQueryDTO(roleResourceQueryVO);
            result = roleResourceService.queryRoleResource(roleResourceQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
