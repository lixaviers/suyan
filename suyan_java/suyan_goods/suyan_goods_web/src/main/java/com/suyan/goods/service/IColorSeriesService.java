package com.suyan.goods.service;

import com.suyan.goods.resp.ColorSeriesODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <对外API 颜色信息管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-13>
 * @Modify Date: <2018-11-13>
 * @Version: <1.0>
 */
public interface IColorSeriesService {


    /**
     * 获取所有颜色信息
     *
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    Result<List<ColorSeriesODTO>> getAll();

}