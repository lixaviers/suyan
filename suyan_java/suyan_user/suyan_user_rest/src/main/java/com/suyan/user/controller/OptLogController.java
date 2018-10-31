package com.suyan.user.controller;

import com.suyan.user.convertor.OptLogConvertor;
import com.suyan.user.req.OptLogDTO;
import com.suyan.user.req.OptLogQueryDTO;
import com.suyan.user.resp.OptLogODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.service.IOptLogService;
import com.suyan.user.vo.OptLogQueryVO;
import com.suyan.user.vo.OptLogVO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("optLog")
@RestController
@Api(value = "optLog", description = "操作日志管理接口")
public class OptLogController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(OptLogController.class);

    @Autowired
    private IOptLogService optLogService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 500, message = "内部错误"),
            @ApiResponse(code = 401, message = "用户不存在"),
            @ApiResponse(code = 402, message = "没有此操作权限"),
    })
    @ApiOperation(value = "deleteOptLog/{id}", notes = "删除操作日志")
    @RequestMapping(value = "deleteOptLog/{id}", method = {RequestMethod.POST})
    public UserResult<Integer> deleteOptLog(@PathVariable Long id) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            result = optLogService.deleteOptLog(id);
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
    @ApiOperation(value = "createOptLog", notes = "创建操作日志")
    @RequestMapping(value = "createOptLog", method = {RequestMethod.POST})
    public UserResult<Long> createOptLog(@Valid @RequestBody OptLogVO optLogVO) {
        UserResult<Long> result = UserResult.newSuccess();
        try {
            OptLogDTO optLogDTO = OptLogConvertor.toOptLogDTO(optLogVO);
            result = optLogService.createOptLog(optLogDTO);
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
    @ApiOperation(value = "updateOptLog", notes = "更新操作日志")
    @RequestMapping(value = "updateOptLog", method = {RequestMethod.POST})
    public UserResult<Integer> updateOptLog(@Valid @RequestBody OptLogVO optLogVO) {
        UserResult<Integer> result = UserResult.newSuccess();
        try {
            OptLogDTO optLogDTO = OptLogConvertor.toOptLogDTO(optLogVO);
            result = optLogService.updateOptLog(optLogDTO);
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
    @ApiOperation(value = "getOptLog/{id}", notes = "根据操作日志ID获取操作日志信息")
    @RequestMapping(value = "getOptLog/{id}", method = {RequestMethod.GET})
    public UserResult<OptLogODTO> getOptLog(@PathVariable Long id) {
        UserResult<OptLogODTO> result = UserResult.newSuccess();
        try {
            result = optLogService.getOptLog(id);
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
    @ApiOperation(value = "queryOptLog", notes = "分页获取操作日志列表信息")
    @RequestMapping(value = "queryOptLog", method = {RequestMethod.POST})
    UserResult<QueryResultODTO<OptLogODTO>> queryOptLog(@Valid @RequestBody OptLogQueryVO optLogQueryVO) {
        UserResult<QueryResultODTO<OptLogODTO>> result = UserResult.newSuccess();
        try {
            OptLogQueryDTO optLogQueryDTO = OptLogConvertor.toOptLogQueryDTO(optLogQueryVO);
            result = optLogService.queryOptLog(optLogQueryDTO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(UserResultCode.SYS_ERROR);
        }
        return result;
    }
}
