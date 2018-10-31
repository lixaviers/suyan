package com.suyan.mmc.biz;

import com.suyan.mmc.dao.DictionaryMapper;
import com.suyan.mmc.model.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <业务层字典管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
@Service("dictionaryBiz")
public class DictionaryBiz {
    private final Logger logger = LoggerFactory.getLogger(DictionaryBiz.class);

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public String getNumber() {
        Dictionary dictionary = dictionaryMapper.selectForUpdate("NUMBER");
        dictionary.setDictId(dictionary.getDictId() + 1);
        dictionaryMapper.updateByPrimaryKeySelective(dictionary);
        return dictionary.getDictId().toString();
    }


}