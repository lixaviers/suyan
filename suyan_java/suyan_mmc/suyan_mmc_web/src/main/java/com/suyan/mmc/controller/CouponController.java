package com.suyan.mmc.controller;

import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.req.CouponDTO;
import com.suyan.mmc.req.CouponQueryDTO;
import com.suyan.mmc.resp.CouponODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.common.result.ValidationResult;
import com.suyan.mmc.service.ICouponService;
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

@RequestMapping("coupon")
@RestController
@Api(value = "coupon", description = "优惠券管理接口")
public class CouponController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    private ICouponService couponService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "deleteCoupon/{id}", notes = "删除优惠券")
    @RequestMapping(value = "deleteCoupon/{id}", method = {RequestMethod.POST})
    public Result<Integer> deleteCoupon(@PathVariable Long id) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            result = couponService.deleteCoupon(id, user.getOpenId(), user.getNickName());
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
    @ApiOperation(value = "createCoupon", notes = "创建优惠券")
    @RequestMapping(value = "createCoupon", method = {RequestMethod.POST})
    public Result<Long> createCoupon(@Valid @RequestBody CouponDTO couponDTO) {
        Result<Long> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(couponDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            couponDTO.setCreateUser(user.getOpenId());
            couponDTO.setCreateUserName(user.getNickName());
            couponDTO.setUpdateUser(user.getOpenId());
            couponDTO.setUpdateUserName(user.getNickName());
            result = couponService.createCoupon(couponDTO);
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
    @ApiOperation(value = "updateCoupon", notes = "更新优惠券")
    @RequestMapping(value = "updateCoupon", method = {RequestMethod.POST})
    public Result<Integer> updateCoupon(@Valid @RequestBody CouponDTO couponDTO) {
        Result<Integer> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(couponDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            UserVO user = getUser();
            couponDTO.setCreateUser(null);
            couponDTO.setCreateUserName(user.getNickName());
            couponDTO.setUpdateUser(null);
            couponDTO.setUpdateUserName(user.getNickName());
            result = couponService.updateCoupon(couponDTO);
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
    @ApiOperation(value = "getCoupon/{id}", notes = "根据优惠券ID获取优惠券信息")
    @RequestMapping(value = "getCoupon/{id}", method = {RequestMethod.GET})
    public Result<CouponODTO> getCoupon(@PathVariable Long id) {
        Result<CouponODTO> result = Result.newSuccess();
        try {
            result = couponService.getCoupon(id);
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
    @ApiOperation(value = "queryCoupon", notes = "分页获取优惠券列表信息")
    @RequestMapping(value = "queryCoupon", method = {RequestMethod.POST})
    Result<QueryResultODTO<CouponODTO>> queryCoupon(@Valid @RequestBody CouponQueryDTO couponQueryDTO) {
        Result<QueryResultODTO<CouponODTO>> result = Result.newSuccess();
        try {
            ValidationResult validateEntity = ValidationUtils.validateEntity(couponQueryDTO);
            if (validateEntity.isHasErrors()) {
                result.setCode(ResultCode.COMMON_PARAM_INVALID.getCode());
                result.setMessage(validateEntity.getErrorMsg().toString());
                return result;
            }
            result = couponService.queryCoupon(couponQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }


    @ApiOperation(value = "changeStatus/{id}/{opt}", notes = "修改优惠券状态")
    @RequestMapping(value = "changeStatus/{id}/{opt}", method = {RequestMethod.POST})
    Result<Integer> changeStatus(@PathVariable Long id, @PathVariable Integer opt) {
        Result<Integer> result = Result.newSuccess();
        try {
            UserVO user = getUser();
            CouponDTO couponDTO = new CouponDTO();
            couponDTO.setId(id);
            couponDTO.setUpdateUser(user.getOpenId());
            couponDTO.setUpdateUserName(user.getNickName());
            Byte couponStatus = null;
            if (opt == 1) {
                // 上线
                couponStatus = CommonStatusEnum.ONLINE.getValue();
            } else if (opt == 2) {
                // 下线
                couponStatus = CommonStatusEnum.SAVED.getValue();
            } else if (opt == 3) {
                // 中止
                couponStatus = CommonStatusEnum.STOPED.getValue();
            } else {
                // 取消
                couponStatus = CommonStatusEnum.CANCELED.getValue();
            }
            couponDTO.setCouponStatus(couponStatus);
            result = couponService.changeStatus(couponDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }

}
