package com.suyan.goods.controller;

import com.suyan.common.result.ValidationResult;
import com.suyan.common.util.ValidationUtils;
import com.suyan.goods.req.PropertyValuesDTO;
import com.suyan.goods.req.PropertyValuesQueryDTO;
import com.suyan.goods.resp.PropertyValuesODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.service.IPropertyValuesService;
import com.suyan.goods.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("propertyValues")
@RestController
@Api(value = "propertyValues", description = "属性值管理接口")
public class PropertyValuesController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(PropertyValuesController.class);

    @Autowired
    private IPropertyValuesService propertyValuesService;

    @ApiOperation(value = "deletePropertyValues/{id}", notes = "删除属性值")
    @RequestMapping(value = "deletePropertyValues/{id}", method = {RequestMethod.POST})
    public Result<Integer> deletePropertyValues(@PathVariable Long id) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            result = propertyValuesService.deletePropertyValues(id, user.getOpenId(), user.getNickName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "createPropertyValues", notes = "创建属性值")
    @RequestMapping(value = "createPropertyValues", method = {RequestMethod.POST})
    public Result<Long> createPropertyValues(@Valid @RequestBody PropertyValuesDTO propertyValuesDTO) {
        Result<Long> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(propertyValuesDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            propertyValuesDTO.setCreateUser(user.getOpenId());
            propertyValuesDTO.setCreateUserName(user.getNickName());
            propertyValuesDTO.setUpdateUser(user.getOpenId());
            propertyValuesDTO.setUpdateUserName(user.getNickName());
            result = propertyValuesService.createPropertyValues(propertyValuesDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "updatePropertyValues", notes = "更新属性值")
    @RequestMapping(value = "updatePropertyValues", method = {RequestMethod.POST})
    public Result<Integer> updatePropertyValues(@Valid @RequestBody PropertyValuesDTO propertyValuesDTO) {
        Result<Integer> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(propertyValuesDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            propertyValuesDTO.setCreateUser(null);
            propertyValuesDTO.setCreateUserName(user.getNickName());
            propertyValuesDTO.setUpdateUser(null);
            propertyValuesDTO.setUpdateUserName(user.getNickName());
            result = propertyValuesService.updatePropertyValues(propertyValuesDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "getPropertyValues/{id}", notes = "根据属性值ID获取属性值信息")
    @RequestMapping(value = "getPropertyValues/{id}", method = {RequestMethod.GET})
    public Result<PropertyValuesODTO> getPropertyValues(@PathVariable Long id) {
        Result<PropertyValuesODTO> result = Result.newSuccess();
        try {
            result = propertyValuesService.getPropertyValues(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "queryPropertyValues", notes = "分页获取属性值列表信息")
    @RequestMapping(value = "queryPropertyValues", method = {RequestMethod.POST})
    Result<QueryResultODTO<PropertyValuesODTO>> queryPropertyValues(@Valid @RequestBody PropertyValuesQueryDTO propertyValuesQueryDTO) {
        Result<QueryResultODTO<PropertyValuesODTO>> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(propertyValuesQueryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            result = propertyValuesService.queryPropertyValues(propertyValuesQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }
}
