package com.suyan.mmc.controller;

import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.req.CouponDTO;
import com.suyan.mmc.req.SubPromotionDTO;
import com.suyan.mmc.req.SubPromotionQueryDTO;
import com.suyan.mmc.resp.SubPromotionODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.common.result.ValidationResult;
import com.suyan.mmc.service.ISubPromotionService;
import com.suyan.common.util.ValidationUtils;
import com.suyan.mmc.vo.UserVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("subPromotion")
@RestController
@Api(value = "subPromotion", description = "订单促销管理接口")
public class SubPromotionController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(SubPromotionController.class);

    @Autowired
    private ISubPromotionService subPromotionService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "deleteSubPromotion/{id}", notes = "删除订单促销")
    @RequestMapping(value = "deleteSubPromotion/{id}", method = {RequestMethod.POST})
    public Result<Integer> deleteSubPromotion(@PathVariable Long id) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            result = subPromotionService.deleteSubPromotion(id, user.getOpenId(), user.getNickName());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "createSubPromotion", notes = "创建订单促销")
    @RequestMapping(value = "createSubPromotion", method = {RequestMethod.POST})
    public Result<Long> createSubPromotion(@Valid @RequestBody SubPromotionDTO subPromotionDTO) {
        Result<Long> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(subPromotionDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            subPromotionDTO.setCreateUser(user.getOpenId());
            subPromotionDTO.setCreateUserName(user.getNickName());
            subPromotionDTO.setUpdateUser(user.getOpenId());
            subPromotionDTO.setUpdateUserName(user.getNickName());
            result = subPromotionService.createSubPromotion(subPromotionDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "updateSubPromotion", notes = "更新订单促销")
    @RequestMapping(value = "updateSubPromotion", method = {RequestMethod.POST})
    public Result<Integer> updateSubPromotion(@Valid @RequestBody SubPromotionDTO subPromotionDTO) {
        Result<Integer> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(subPromotionDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            subPromotionDTO.setCreateUser(null);
            subPromotionDTO.setCreateUserName(user.getNickName());
            subPromotionDTO.setUpdateUser(null);
            subPromotionDTO.setUpdateUserName(user.getNickName());
            result = subPromotionService.updateSubPromotion(subPromotionDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "getSubPromotion/{id}", notes = "根据订单促销ID获取订单促销信息")
    @RequestMapping(value = "getSubPromotion/{id}", method = {RequestMethod.GET})
    public Result<SubPromotionODTO> getSubPromotion(@PathVariable Long id) {
        Result<SubPromotionODTO> result = Result.newSuccess();
        try {
            result = subPromotionService.getSubPromotion(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "querySubPromotion", notes = "分页获取订单促销列表信息")
    @RequestMapping(value = "querySubPromotion", method = {RequestMethod.POST})
    Result<QueryResultODTO<SubPromotionODTO>> querySubPromotion(@Valid @RequestBody SubPromotionQueryDTO subPromotionQueryDTO) {
        Result<QueryResultODTO<SubPromotionODTO>> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(subPromotionQueryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            result = subPromotionService.querySubPromotion(subPromotionQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }



    @ApiOperation(value = "changeStatus/{id}/{opt}", notes = "修改商品促销状态")
    @RequestMapping(value = "changeStatus/{id}/{opt}", method = {RequestMethod.POST})
    Result<Integer> changeStatus(@PathVariable Long id, @PathVariable Integer opt) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            SubPromotionDTO subPromotionDTO = new SubPromotionDTO();
            subPromotionDTO.setId(id);
            subPromotionDTO.setUpdateUser(user.getOpenId());
            subPromotionDTO.setUpdateUserName(user.getNickName());
            Byte subPromotionStatus = null;
            if (opt == 1) {
                // 上线
                subPromotionStatus = CommonStatusEnum.ONLINE.getValue();
            } else if (opt == 2) {
                // 下线
                subPromotionStatus = CommonStatusEnum.SAVED.getValue();
            } else if (opt == 3) {
                // 中止
                subPromotionStatus = CommonStatusEnum.STOPED.getValue();
            } else {
                // 取消
                subPromotionStatus = CommonStatusEnum.CANCELED.getValue();
            }
            subPromotionDTO.setPromotionStatus(subPromotionStatus);
            result = subPromotionService.changeStatus(subPromotionDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }


}
