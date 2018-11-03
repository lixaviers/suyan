package com.suyan.goods.controller;

import com.suyan.common.result.ValidationResult;
import com.suyan.common.util.ValidationUtils;
import com.suyan.goods.req.BrandDTO;
import com.suyan.goods.req.BrandQueryDTO;
import com.suyan.goods.resp.BrandODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.service.IBrandService;
import com.suyan.goods.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("brand")
@RestController
@Api(value = "brand", description = "品牌管理接口")
public class BrandController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private IBrandService brandService;

    @ApiOperation(value = "deleteBrand/{id}", notes = "删除品牌")
    @RequestMapping(value = "deleteBrand/{id}", method = {RequestMethod.POST})
    public Result<Integer> deleteBrand(@PathVariable Long id) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            result = brandService.deleteBrand(id, user.getOpenId(), user.getNickName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "createBrand", notes = "创建品牌")
    @RequestMapping(value = "createBrand", method = {RequestMethod.POST})
    public Result<Long> createBrand(@Valid @RequestBody BrandDTO brandDTO) {
        Result<Long> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(brandDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            brandDTO.setCreateUser(user.getOpenId());
            brandDTO.setCreateUserName(user.getNickName());
            brandDTO.setUpdateUser(user.getOpenId());
            brandDTO.setUpdateUserName(user.getNickName());
            result = brandService.createBrand(brandDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "updateBrand", notes = "更新品牌")
    @RequestMapping(value = "updateBrand", method = {RequestMethod.POST})
    public Result<Integer> updateBrand(@Valid @RequestBody BrandDTO brandDTO) {
        Result<Integer> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(brandDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            brandDTO.setCreateUser(null);
            brandDTO.setCreateUserName(user.getNickName());
            brandDTO.setUpdateUser(null);
            brandDTO.setUpdateUserName(user.getNickName());
            result = brandService.updateBrand(brandDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "getBrand/{id}", notes = "根据品牌ID获取品牌信息")
    @RequestMapping(value = "getBrand/{id}", method = {RequestMethod.GET})
    public Result<BrandODTO> getBrand(@PathVariable Long id) {
        Result<BrandODTO> result = Result.newSuccess();
        try {
            result = brandService.getBrand(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiOperation(value = "queryBrand", notes = "分页获取品牌列表信息")
    @RequestMapping(value = "queryBrand", method = {RequestMethod.POST})
    Result<QueryResultODTO<BrandODTO>> queryBrand(@Valid @RequestBody BrandQueryDTO brandQueryDTO) {
        Result<QueryResultODTO<BrandODTO>> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(brandQueryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            result = brandService.queryBrand(brandQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }
}
