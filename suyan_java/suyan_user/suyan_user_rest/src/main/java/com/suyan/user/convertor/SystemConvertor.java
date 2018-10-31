package com.suyan.user.convertor;

import com.suyan.user.req.SystemDTO;
import com.suyan.user.req.SystemQueryDTO;
import com.suyan.user.vo.SystemQueryVO;
import com.suyan.user.vo.SystemVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层系统转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class SystemConvertor {

    private static final BeanCopier beanCopierForSystemDTO = BeanCopier.create(SystemVO.class, SystemDTO.class, false);
    private static final BeanCopier beanCopierForSystemQueryDTO = BeanCopier.create(SystemQueryVO.class, SystemQueryDTO.class, false);

    public static SystemDTO toSystemDTO(SystemVO systemVO) {
        if (systemVO == null) {
            return null;
        }
        SystemDTO systemDTO = new SystemDTO();
        beanCopierForSystemDTO.copy(systemVO, systemDTO, null);
        return systemDTO;
    }

    public static List<SystemDTO> toSystemDTOList(List<SystemVO> systemVOList) {
        if (systemVOList == null || systemVOList.isEmpty()) {
            return null;
        }
        List<SystemDTO> systemDTOList = new ArrayList<SystemDTO>(systemVOList.size());
        for (SystemVO systemVO : systemVOList) {
            systemDTOList.add(toSystemDTO(systemVO));
        }
        return systemDTOList;
    }
    
    public static SystemQueryDTO toSystemQueryDTO(SystemQueryVO systemQueryVO) {
        if (systemQueryVO== null) {
            return null;
        }
        SystemQueryDTO systemQueryDTO = new SystemQueryDTO();
        beanCopierForSystemQueryDTO.copy(systemQueryVO, systemQueryDTO, null);
        return systemQueryDTO;
    }
}