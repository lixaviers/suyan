package com.suyan.goods.test;

import com.alibaba.fastjson.JSON;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.goods.req.CategoryDTO;
import com.suyan.goods.req.CategoryQueryDTO;
import com.suyan.goods.resp.CategoryODTO;
import com.suyan.goods.service.ICategoryService;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring-test.xml",
        "classpath:*/applicationContext-bean.xml",
        "classpath:*/applicationContext-ds.xml",
})
public class CategoryTest {

    @Resource
    private ICategoryService categoryService;


    @Test
    public void updateCategory() {
        CategoryQueryDTO categoryQueryDTO = new CategoryQueryDTO();
        categoryQueryDTO.setPageSize(100000);
        categoryQueryDTO.setOrderBy("id");
        Result<QueryResultODTO<CategoryODTO>> result = categoryService.queryCategory(categoryQueryDTO);
        for (CategoryODTO record : result.getDataMap().getRecords()) {
            if (!record.getParentId().equals(0l)) {

                System.out.println("--------" + record.getParentId());
                Result<CategoryODTO> beanResult = categoryService.getCategory(record.getParentId());

                CategoryDTO temp = new CategoryDTO();
                temp.setId(record.getId());
                temp.setLevelType((byte) (beanResult.getDataMap().getLevelType().intValue() + 1));

                categoryService.updateCategory(temp);
            }
        }

    }


}