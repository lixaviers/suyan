package com.suyan.goods.dao.ext;

import com.suyan.goods.model.Brand;
import com.suyan.goods.model.BrandExample;
import com.suyan.goods.req.BrandQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandExtMapper {


    Brand getBrandById(Long id);



}