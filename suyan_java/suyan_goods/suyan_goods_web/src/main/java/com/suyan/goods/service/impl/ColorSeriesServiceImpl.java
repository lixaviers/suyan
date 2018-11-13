package com.suyan.goods.service.impl;

import com.suyan.goods.biz.ColorSeriesBiz;
import com.suyan.goods.convertor.ColorSeriesConvertor;
import com.suyan.common.result.Result;
import com.suyan.goods.resp.ColorSeriesODTO;
import com.suyan.goods.service.IColorSeriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo Service 颜色信息管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-13>
 * @Modify Date: <2018-11-13>
 * @Version: <1.0>
 */
@Service("colorSeriesService")
public class ColorSeriesServiceImpl implements IColorSeriesService {

    private final Logger logger = LoggerFactory.getLogger(ColorSeriesServiceImpl.class);

    @Autowired
    private ColorSeriesBiz colorSeriesBiz;


    @Override
    public Result<List<ColorSeriesODTO>> getAll() {
        Result<List<ColorSeriesODTO>> result = Result.newSuccess();
        result.setDataMap(ColorSeriesConvertor.toColorSeriesODTOList(colorSeriesBiz.getAll()));
        return result;
    }
}