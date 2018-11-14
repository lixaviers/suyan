package com.suyan.goods.controller;

import com.suyan.goods.resp.ColorSeriesODTO;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.service.IColorSeriesService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("colorSeries")
@RestController
@Api(value = "colorSeries", description = "颜色信息管理接口")
public class ColorSeriesController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(ColorSeriesController.class);

    @Autowired
    private IColorSeriesService colorSeriesService;

    @ApiOperation(value = "getA1ll", notes = "获取所有颜色信息")
    @RequestMapping(value = "getAll", method = {RequestMethod.GET})
    Result<List<ColorSeriesODTO>> getAll() {
        Result<List<ColorSeriesODTO>> result = Result.newSuccess();
        try {
            result = colorSeriesService.getAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setErrorCode(ResultCode.SYS_ERROR);
        }
        return result;
    }
}
