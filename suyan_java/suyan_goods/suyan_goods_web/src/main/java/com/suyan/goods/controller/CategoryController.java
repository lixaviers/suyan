package com.suyan.goods.controller;

import com.suyan.common.result.ValidationResult;
import com.suyan.common.util.ValidationUtils;
import com.suyan.goods.req.CategoryDTO;
import com.suyan.goods.req.CategoryQueryDTO;
import com.suyan.goods.resp.CategoryCascaderODTO;
import com.suyan.goods.resp.CategoryODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.service.ICategoryService;
import com.suyan.goods.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("category")
@RestController
@Api(value = "category", description = "类目管理接口")
public class CategoryController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "deleteCategory/{id}", notes = "删除类目")
    @RequestMapping(value = "deleteCategory/{id}", method = {RequestMethod.POST})
    public Result<Integer> deleteCategory(@PathVariable Long id) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            result = categoryService.deleteCategory(id, user.getOpenId(), user.getNickName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "createCategory", notes = "创建类目")
    @RequestMapping(value = "createCategory", method = {RequestMethod.POST})
    public Result<Long> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Result<Long> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(categoryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            categoryDTO.setCreateUser(user.getOpenId());
            categoryDTO.setCreateUserName(user.getNickName());
            categoryDTO.setUpdateUser(user.getOpenId());
            categoryDTO.setUpdateUserName(user.getNickName());
            result = categoryService.createCategory(categoryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "updateCategory", notes = "更新类目")
    @RequestMapping(value = "updateCategory", method = {RequestMethod.POST})
    public Result<Integer> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Result<Integer> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(categoryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            categoryDTO.setCreateUser(null);
            categoryDTO.setCreateUserName(user.getNickName());
            categoryDTO.setUpdateUser(null);
            categoryDTO.setUpdateUserName(user.getNickName());
            result = categoryService.updateCategory(categoryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "getCategory/{id}", notes = "根据类目ID获取类目信息")
    @RequestMapping(value = "getCategory/{id}", method = {RequestMethod.GET})
    public Result<CategoryODTO> getCategory(@PathVariable Long id) {
        Result<CategoryODTO> result = Result.newSuccess();
        try {
            result = categoryService.getCategory(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "queryCategory", notes = "分页获取类目列表信息")
    @RequestMapping(value = "queryCategory", method = {RequestMethod.POST})
    Result<QueryResultODTO<CategoryODTO>> queryCategory(@Valid @RequestBody CategoryQueryDTO categoryQueryDTO) {
        Result<QueryResultODTO<CategoryODTO>> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(categoryQueryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            categoryQueryDTO.setOrderBy("sort_number asc, id asc");
            result = categoryService.queryCategory(categoryQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "sort", notes = "类目排序")
    @RequestMapping(value = "sort", method = {RequestMethod.POST})
    Result<Boolean> sort(@Valid @RequestBody List<CategoryDTO> categoryList) {
        Result<Boolean> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(categoryList);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            result = categoryService.sort(categoryList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "queryCategoryCascader", notes = "获取类目列表信息")
    @RequestMapping(value = "queryCategoryCascader", method = {RequestMethod.GET})
    Result<List<CategoryCascaderODTO>> queryCategoryCascader() {
        Result<List<CategoryCascaderODTO>> result = Result.newSuccess();
        try {
            result = categoryService.queryCategoryCascader();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

}
