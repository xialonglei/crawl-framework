package com.xll.importdb;

import com.xll.model.DubboSchema;
import com.xll.page.model.PageCrawlRule;
import com.xll.service.DubboSchemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lonely.xia on 2017/10/3.
 */
public class DubboSchemaImport implements Export<DubboSchema> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboSchemaImport.class);

    @Override
    public void writeDataToDB(List<DubboSchema> datas) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
           "/spring-config/spring-mybatis.xml"
        });

        context.start();

        DubboSchemaService dubboSchemaService = (DubboSchemaService) context.getBean("dubboSchemaService");
        dubboSchemaService.insertList(datas);
    }

    @Override
    public void assemblyStoreDatas(PageCrawlRule pageCrawlRule, Map<String, ArrayList<String>> content) {

        //对获取的数据进行入库
        List<DubboSchema> dubboSchemaList = new ArrayList<>();

        for (Map.Entry<String , ArrayList<String>> entry : content.entrySet()) {
            String fieldName = entry.getKey();
            ArrayList<String> fieldValues = entry.getValue();
            for (int i = 0 ; i < fieldValues.size() ; i++) {
                String fieldValue = fieldValues.get(i);
                DubboSchema dubboSchema = null;
                if (dubboSchemaList.size() != fieldValues.size()) {
                    dubboSchema = new DubboSchema();
                } else {
                    dubboSchema = dubboSchemaList.get(i);
                }
                Class clazz = dubboSchema.getClass();
                Field field = null;
                try {
                    field = clazz.getDeclaredField(fieldName);
                    Method method = clazz
                            .getDeclaredMethod("set" + fieldName.substring(0,1).toUpperCase()
                                    + fieldName.substring(1) , field.getType());
                    if (field.getType().getCanonicalName().equals("java.lang.Boolean")) {
                        if (fieldValue.equals("必填")) {
                            method.invoke(dubboSchema , Boolean.TRUE);
                        } else {
                            method.invoke(dubboSchema , Boolean.FALSE);
                        }
                    }else {
                        method.invoke(dubboSchema , fieldValue);
                    }
                } catch (Exception e) {
                    LOGGER.info("未能成功处理的[{},{}]" , fieldName , field.getType().getCanonicalName());
                    return;
                }
                if (dubboSchemaList.size() != fieldValues.size()) {
                    dubboSchemaList.add(dubboSchema);
                }
            }

        }

        Class clazz = pageCrawlRule.getPageBO().getClass();
        // 获取父类传递过来的值
        for (DubboSchema dubboSchema : dubboSchemaList) {
            Class dubboSchemaClazz = dubboSchema.getClass();
            Method fieldMethod = null;
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Method method = null;
                String fieldNameTemp = field.getName();
                try {
                    method = clazz.getDeclaredMethod("get" + fieldNameTemp.substring(0,1).toUpperCase()
                            + fieldNameTemp.substring(1));
                    if (method.invoke(pageCrawlRule.getPageBO()) != null) {
                        fieldMethod = dubboSchemaClazz
                                .getDeclaredMethod("set" + fieldNameTemp.substring(0,1).toUpperCase()
                                        + fieldNameTemp.substring(1) , field.getType());
                        fieldMethod.invoke(dubboSchema , method.invoke(pageCrawlRule.getPageBO()));
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }

        writeDataToDB(dubboSchemaList);
    }
}
