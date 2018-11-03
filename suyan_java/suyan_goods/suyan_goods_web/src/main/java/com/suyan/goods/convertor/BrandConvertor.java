package com.suyan.goods.convertor;

import com.suyan.goods.model.Brand;
import com.suyan.goods.req.BrandDTO;
import com.suyan.goods.resp.BrandODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo层品牌转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
public abstract class BrandConvertor {

    private static final BeanCopier beanCopierForBrandODTO = BeanCopier.create(Brand.class, BrandODTO.class, false);
    private static final BeanCopier beanCopierForBrand = BeanCopier.create(BrandDTO.class, Brand.class, false);

    public static BrandODTO toBrandODTO(Brand brand) {
        if (brand == null) {
            return null;
        }
        BrandODTO brandODTO = new BrandODTO();
        beanCopierForBrandODTO.copy(brand, brandODTO, null);
        return brandODTO;
    }

    public static Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        beanCopierForBrand.copy(brandDTO, brand, null);
        return brand;
    }

    public static List<BrandODTO> toBrandODTOList(List<Brand> brandList) {
        if (brandList == null || brandList.isEmpty()) {
            return null;
        }
        List<BrandODTO> brandInfoList = new ArrayList<BrandODTO>(brandList.size());
        for (Brand brand : brandList) {
            brandInfoList.add(toBrandODTO(brand));
        }
        return brandInfoList;
    }

    public static List<Brand> toBrandList(List<BrandDTO> brandDTOList) {
        if (brandDTOList == null || brandDTOList.isEmpty()) {
            return null;
        }
        List<Brand> brandList = new ArrayList<Brand>(brandDTOList.size());
        for (BrandDTO brandDTO : brandDTOList) {
            brandList.add(toBrand(brandDTO));
        }
        return brandList;
    }

    public static QueryResultODTO<BrandODTO> toQueryResult(QueryResultODTO<Brand> queryResult) {
        QueryResultODTO<BrandODTO> queryResultInfo = new QueryResultODTO<BrandODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toBrandODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}