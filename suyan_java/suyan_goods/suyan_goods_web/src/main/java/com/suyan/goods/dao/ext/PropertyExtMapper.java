package com.suyan.goods.dao.ext;

import com.suyan.goods.model.PropertyName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyExtMapper {


    int getPropertyNameMaxSortNumberByCategoryId(Long categoryId);

    int getPropertyNameMaxSortNumberByPropertyNameId(
            @Param("categoryId") Long categoryId,
            @Param("propertyNameId") Long propertyNameId
    );

    List<PropertyName> getPropertysByCategoryId(Long categoryId);


}