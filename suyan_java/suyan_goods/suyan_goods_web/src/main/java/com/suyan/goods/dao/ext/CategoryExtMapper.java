package com.suyan.goods.dao.ext;

import com.suyan.goods.model.Category;

public interface CategoryExtMapper {
    

    int getMaxSortNumberByParentId(Long parentId);

    int getMaxSortNumberWebByParentId(Long parentId);



}