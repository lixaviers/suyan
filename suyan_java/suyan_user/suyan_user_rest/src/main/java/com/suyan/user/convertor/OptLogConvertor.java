package com.suyan.user.convertor;

import com.suyan.user.req.OptLogDTO;
import com.suyan.user.req.OptLogQueryDTO;
import com.suyan.user.vo.OptLogQueryVO;
import com.suyan.user.vo.OptLogVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层操作日志转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public abstract class OptLogConvertor {

    private static final BeanCopier beanCopierForOptLogDTO = BeanCopier.create(OptLogVO.class, OptLogDTO.class, false);
    private static final BeanCopier beanCopierForOptLogQueryDTO = BeanCopier.create(OptLogQueryVO.class, OptLogQueryDTO.class, false);

    public static OptLogDTO toOptLogDTO(OptLogVO optLogVO) {
        if (optLogVO == null) {
            return null;
        }
        OptLogDTO optLogDTO = new OptLogDTO();
        beanCopierForOptLogDTO.copy(optLogVO, optLogDTO, null);
        return optLogDTO;
    }

    public static List<OptLogDTO> toOptLogDTOList(List<OptLogVO> optLogVOList) {
        if (optLogVOList == null || optLogVOList.isEmpty()) {
            return null;
        }
        List<OptLogDTO> optLogDTOList = new ArrayList<OptLogDTO>(optLogVOList.size());
        for (OptLogVO optLogVO : optLogVOList) {
            optLogDTOList.add(toOptLogDTO(optLogVO));
        }
        return optLogDTOList;
    }
    
    public static OptLogQueryDTO toOptLogQueryDTO(OptLogQueryVO optLogQueryVO) {
        if (optLogQueryVO== null) {
            return null;
        }
        OptLogQueryDTO optLogQueryDTO = new OptLogQueryDTO();
        beanCopierForOptLogQueryDTO.copy(optLogQueryVO, optLogQueryDTO, null);
        return optLogQueryDTO;
    }
}