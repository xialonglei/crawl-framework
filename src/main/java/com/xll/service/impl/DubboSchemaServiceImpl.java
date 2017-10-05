package com.xll.service.impl;

import com.xll.mapper.DubboSchemaMapper;
import com.xll.model.DubboSchema;
import com.xll.service.DubboSchemaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lonely.xia on 2017/10/1.
 */
@Service("dubboSchemaService")
public class DubboSchemaServiceImpl implements DubboSchemaService {

    @Resource
    private DubboSchemaMapper dubboSchemaDao;

    @Override
    public void insertList(List<DubboSchema> dubboSchemaList) {
        for (DubboSchema dubboSchema : dubboSchemaList) {
            dubboSchemaDao.insert(dubboSchema);
        }
    }
}
