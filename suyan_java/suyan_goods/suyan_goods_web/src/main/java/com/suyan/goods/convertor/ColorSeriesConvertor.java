package com.suyan.goods.convertor;

import com.suyan.goods.model.ColorSeries;
import com.suyan.goods.resp.ColorSeriesODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo层颜色信息转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-13>
 * @Modify Date: <2018-11-13>
 * @Version: <1.0>
 */
public abstract class ColorSeriesConvertor {

    private static final BeanCopier beanCopierForColorSeriesODTO = BeanCopier.create(ColorSeries.class, ColorSeriesODTO.class, false);

    public static ColorSeriesODTO toColorSeriesODTO(ColorSeries colorSeries) {
        if (colorSeries == null) {
            return null;
        }
        ColorSeriesODTO colorSeriesODTO = new ColorSeriesODTO();
        beanCopierForColorSeriesODTO.copy(colorSeries, colorSeriesODTO, null);
        return colorSeriesODTO;
    }

    public static List<ColorSeriesODTO> toColorSeriesODTOList(List<ColorSeries> colorSeriesList) {
        if (colorSeriesList == null || colorSeriesList.isEmpty()) {
            return null;
        }
        List<ColorSeriesODTO> colorSeriesInfoList = new ArrayList<ColorSeriesODTO>(colorSeriesList.size());
        for (ColorSeries colorSeries : colorSeriesList) {
            colorSeriesInfoList.add(toColorSeriesODTO(colorSeries));
        }
        return colorSeriesInfoList;
    }
}