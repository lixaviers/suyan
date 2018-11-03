package com.suyan.goods.service.impl;

import com.suyan.goods.biz.BrandBiz;
import com.suyan.goods.convertor.BrandConvertor;
import com.suyan.goods.model.Brand;
import com.suyan.goods.req.BrandDTO;
import com.suyan.goods.req.BrandQueryDTO;
import com.suyan.goods.resp.BrandODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.goods.service.IBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.goods.validate.BrandValidate.validateForCreate;
import static com.suyan.goods.validate.BrandValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo Service 品牌管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
@Service("brandService")
public class BrandServiceImpl implements IBrandService {
    private final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandBiz brandBiz;

    /**
     * 
     * 删除品牌
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
    * @param updateUser
    * @param updateUserName
     * @return
     */
    @Override
    public Result<Integer> deleteBrand(Long id , String updateUser, String updateUserName ){
        Result<Integer> result = Result.newSuccess();
        result.setDataMap(brandBiz.deleteBrand(id , updateUser, updateUserName ));
        return result;
    }
    
    /**
     * 
     * 创建品牌
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param brandDTO
     * @return
     */
    @Override
    public Result<Long> createBrand(BrandDTO brandDTO){
        Result<Long> result = Result.newSuccess();
        Brand brand = BrandConvertor.toBrand(brandDTO);
        if (!validateForCreate(brand, result)) {
            return result;
        }
        result.setDataMap(brandBiz.createBrand( brand ));
        return  result;
    }

    @Override
    public Result<Integer> batchCreate(List<BrandDTO> brandDTOs ) {
            Result<Integer> result = Result.newSuccess();
        List<Brand> items = BrandConvertor.toBrandList(brandDTOs);
        result.setDataMap(brandBiz.batchCreateBrand(items));
        return result;
    }

    /**
     * 
     * 更新品牌
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param brandDTO
     * @return
     */
    @Override
    public Result<Integer> updateBrand(BrandDTO brandDTO){
        Result<Integer> result = Result.newSuccess();
        Brand brand = null;
        brand = BrandConvertor.toBrand(brandDTO);
        if (!validateForUpdate(brand, result)) {
            return result;
        }
        result.setDataMap(brandBiz.updateBrand( brand ));
        return result;
    }
    
    /**
     * 
     * 根据ID获取品牌信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public Result<BrandODTO> getBrand( Long id ){
        Result<BrandODTO> result  = Result.newSuccess();
        Brand brand = brandBiz.getBrand( id );
        BrandODTO brandODTO = BrandConvertor.toBrandODTO(brand);
        result.setDataMap(brandODTO);
        return result;
    }

    /**
     * 
     * 分页查询品牌信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param brandQueryDTO
     * @return
     */
    @Override
    public Result<QueryResultODTO<BrandODTO>> queryBrand(BrandQueryDTO brandQueryDTO) {
        Result<QueryResultODTO<BrandODTO>> result = Result.newSuccess();

        QueryResultODTO<Brand> resultInfo = brandBiz.queryBrand(brandQueryDTO);
        result.setDataMap(BrandConvertor.toQueryResult(resultInfo));

        return result;
    }
}