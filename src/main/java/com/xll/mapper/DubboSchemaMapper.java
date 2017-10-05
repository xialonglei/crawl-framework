package com.xll.mapper;

import com.xll.model.DubboSchema;
import com.xll.model.DubboSchemaExample;
import java.util.List;

public interface DubboSchemaMapper {

    int insert(DubboSchema record);

    List<DubboSchema> selectByExample(DubboSchemaExample example);


}