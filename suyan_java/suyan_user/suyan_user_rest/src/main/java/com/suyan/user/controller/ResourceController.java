package com.suyan.user.controller;

import com.suyan.user.convertor.ResourceConvertor;
import com.suyan.user.req.ResourceDTO;
import com.suyan.user.req.ResourceQueryDTO;
import com.suyan.user.resp.NavODTO;
import com.suyan.user.resp.ResourceODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IResourceService;
import com.suyan.user.vo.ResourceQueryVO;
import com.suyan.user.vo.ResourceVO;
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
import java.util.List;

@RequestMapping("resource")
@RestController
@Api(value = "resource", description = "资源管理接口")
public class ResourceController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private IResourceService resourceService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "deleteResource/{id}", notes = "删除资源")
    @RequestMapping(value = "deleteResource/{id}", method = {RequestMethod.POST})
    public UserResult<Integer> deleteResource(@PathVariable Long id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserVO user = getUser();
            result = resourceService.deleteResource(id, user.getOpenId(), user.getNickName());
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
    @ApiOperation(value = "createResource", notes = "创建资源")
    @RequestMapping(value = "createResource", method = {RequestMethod.POST})
    public UserResult<Long> createResource(@Valid @RequestBody ResourceVO resourceVO) {
        UserResult<Long> result = UserResult.newSuccess();
        try {
            UserVO user = getUser();
            ResourceDTO resourceDTO = ResourceConvertor.toResourceDTO(resourceVO);
            resourceDTO.setCreateUser(user.getOpenId());
            resourceDTO.setCreateUserName(user.getNickName());
            resourceDTO.setUpdateUser(user.getOpenId());
            resourceDTO.setUpdateUserName(user.getNickName());
            result = resourceService.createResource(resourceDTO);
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
    @ApiOperation(value = "updateResource", notes = "更新资源")
    @RequestMapping(value = "updateResource", method = {RequestMethod.POST})
    public UserResult<Integer> updateResource(@Valid @RequestBody ResourceVO resourceVO) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            UserVO user = getUser();
            ResourceDTO resourceDTO = ResourceConvertor.toResourceDTO(resourceVO);
            resourceDTO.setUpdateUser(user.getOpenId());
            resourceDTO.setUpdateUserName(user.getNickName());
            result = resourceService.updateResource(resourceDTO);
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
    @ApiOperation(value = "getResource/{id}", notes = "根据资源ID获取资源信息")
    @RequestMapping(value = "getResource/{id}", method = {RequestMethod.GET})
    public UserResult<ResourceODTO> getResource(@PathVariable Long id) {
        UserResult<ResourceODTO> result = UserResult.newSuccess();
        try {
            result = resourceService.getResource(id);
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
    @ApiOperation(value = "queryResource", notes = "分页获取资源列表信息")
    @RequestMapping(value = "queryResource", method = {RequestMethod.POST})
    UserResult<QueryResultODTO<ResourceODTO>> queryResource(@Valid @RequestBody ResourceQueryVO resourceQueryVO) {
        UserResult<QueryResultODTO<ResourceODTO>> result = UserResult.newSuccess();
        try {
            ResourceQueryDTO resourceQueryDTO = ResourceConvertor.toResourceQueryDTO(resourceQueryVO);
            result = resourceService.queryResource(resourceQueryDTO);
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
    @ApiOperation(value = "getResources/role/{roleId}", notes = "获取角色资源列表信息")
    @RequestMapping(value = "getResources/role/{roleId}", method = {RequestMethod.GET})
    UserResult<List<ResourceODTO>> getResourcesByRoleId(@PathVariable Integer roleId) {
        UserResult<List<ResourceODTO>> result = UserResult.newSuccess();
        try {
            result = resourceService.getResourcesByRoleId(roleId);
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
    @ApiOperation(value = "getTreeResource/{systemId}", notes = "获取树资源列表信息")
    @RequestMapping(value = "getTreeResource/{systemId}", method = {RequestMethod.GET})
    UserResult<List<ResourceODTO>> getTreeResource(@PathVariable Integer systemId) {
        UserResult<List<ResourceODTO>> result = UserResult.newSuccess();
        try {
            result = resourceService.getTreeResource(systemId);
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
    @ApiOperation(value = "nav", notes = "获取用户资源列表信息")
    @RequestMapping(value = "nav", method = {RequestMethod.GET})
    UserResult<NavODTO> nav() {
        UserResult<NavODTO> result = UserResult.newSuccess();
        try {
            UserVO user = getUser();
            result = resourceService.getNav(user.getOpenId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
