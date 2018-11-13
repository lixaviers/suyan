package com.suyan.goods.controller;

import com.suyan.common.result.ValidationResult;
import com.suyan.common.util.ValidationUtils;
import com.suyan.goods.req.PropertyNameDTO;
import com.suyan.goods.req.PropertyNameQueryDTO;
import com.suyan.goods.resp.PropertyNameODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.service.IPropertyNameService;
import com.suyan.goods.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("propertyName")
@RestController
@Api(value = "propertyName", description = "属性名管理接口")
public class PropertyNameController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(PropertyNameController.class);

    @Autowired
    private IPropertyNameService propertyNameService;

    @ApiOperation(value = "deletePropertyName/{id}", notes = "删除属性名")
    @RequestMapping(value = "deletePropertyName/{id}", method = {RequestMethod.POST})
    public Result<Integer> deletePropertyName(@PathVariable Long id) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            result = propertyNameService.deletePropertyName(id, user.getOpenId(), user.getNickName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "createPropertyName", notes = "创建属性名")
    @RequestMapping(value = "createPropertyName", method = {RequestMethod.POST})
    public Result<Long> createPropertyName(@Valid @RequestBody PropertyNameDTO propertyNameDTO) {
        Result<Long> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(propertyNameDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            propertyNameDTO.setCreateUser(user.getOpenId());
            propertyNameDTO.setCreateUserName(user.getNickName());
            propertyNameDTO.setUpdateUser(user.getOpenId());
            propertyNameDTO.setUpdateUserName(user.getNickName());
            result = propertyNameService.createPropertyName(propertyNameDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "updatePropertyName", notes = "更新属性名")
    @RequestMapping(value = "updatePropertyName", method = {RequestMethod.POST})
    public Result<Integer> updatePropertyName(@Valid @RequestBody PropertyNameDTO propertyNameDTO) {
        Result<Integer> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(propertyNameDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            propertyNameDTO.setCreateUser(null);
            propertyNameDTO.setCreateUserName(user.getNickName());
            propertyNameDTO.setUpdateUser(null);
            propertyNameDTO.setUpdateUserName(user.getNickName());
            result = propertyNameService.updatePropertyName(propertyNameDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "getPropertyName/{id}", notes = "根据属性名ID获取属性名信息")
    @RequestMapping(value = "getPropertyName/{id}", method = {RequestMethod.GET})
    public Result<PropertyNameODTO> getPropertyName(@PathVariable Long id) {
        Result<PropertyNameODTO> result = Result.newSuccess();
        try {
            result = propertyNameService.getPropertyName(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "queryPropertyName", notes = "分页获取属性名列表信息")
    @RequestMapping(value = "queryPropertyName", method = {RequestMethod.POST})
    Result<QueryResultODTO<PropertyNameODTO>> queryPropertyName(@Valid @RequestBody PropertyNameQueryDTO propertyNameQueryDTO) {
        Result<QueryResultODTO<PropertyNameODTO>> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(propertyNameQueryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            result = propertyNameService.queryPropertyName(propertyNameQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "getPropertysByCategoryId/{categoryId}", notes = "根据类目查询属性")
    @RequestMapping(value = "getPropertysByCategoryId/{categoryId}", method = {RequestMethod.GET})
    Result<List<PropertyNameODTO>> getPropertysByCategoryId(@PathVariable Long categoryId) {
        Result<List<PropertyNameODTO>> result = Result.newSuccess();
        try {
            result = propertyNameService.getPropertysByCategoryId(categoryId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }
}
