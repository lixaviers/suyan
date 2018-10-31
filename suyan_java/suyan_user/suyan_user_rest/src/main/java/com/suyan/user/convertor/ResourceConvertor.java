package com.suyan.user.convertor;

import com.suyan.user.req.ResourceDTO;
import com.suyan.user.req.ResourceQueryDTO;
import com.suyan.user.vo.ResourceQueryVO;
import com.suyan.user.vo.ResourceVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层资源转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class ResourceConvertor {

    private static final BeanCopier beanCopierForResourceDTO = BeanCopier.create(ResourceVO.class, ResourceDTO.class, false);
    private static final BeanCopier beanCopierForResourceQueryDTO = BeanCopier.create(ResourceQueryVO.class, ResourceQueryDTO.class, false);

    public static ResourceDTO toResourceDTO(ResourceVO resourceVO) {
        if (resourceVO == null) {
            return null;
        }
        ResourceDTO resourceDTO = new ResourceDTO();
        beanCopierForResourceDTO.copy(resourceVO, resourceDTO, null);
        return resourceDTO;
    }

    public static List<ResourceDTO> toResourceDTOList(List<ResourceVO> resourceVOList) {
        if (resourceVOList == null || resourceVOList.isEmpty()) {
            return null;
        }
        List<ResourceDTO> resourceDTOList = new ArrayList<ResourceDTO>(resourceVOList.size());
        for (ResourceVO resourceVO : resourceVOList) {
            resourceDTOList.add(toResourceDTO(resourceVO));
        }
        return resourceDTOList;
    }
    
    public static ResourceQueryDTO toResourceQueryDTO(ResourceQueryVO resourceQueryVO) {
        if (resourceQueryVO== null) {
            return null;
        }
        ResourceQueryDTO resourceQueryDTO = new ResourceQueryDTO();
        beanCopierForResourceQueryDTO.copy(resourceQueryVO, resourceQueryDTO, null);
        return resourceQueryDTO;
    }
}