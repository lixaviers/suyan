package com.suyan.goods.biz;

import com.suyan.goods.dao.ColorSeriesMapper;
import com.suyan.goods.model.ColorSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <业务层颜色信息管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-13>
 * @Modify Date: <2018-11-13>
 * @Version: <1.0>
 */
@Service("colorSeriesBiz")
public class ColorSeriesBiz {

    @Autowired
    ColorSeriesMapper colorSeriesMapper;

    /**
     * 获取所有颜色信息
     *
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public List<ColorSeries> getAll() {
        return colorSeriesMapper.selectAll();
    }

}