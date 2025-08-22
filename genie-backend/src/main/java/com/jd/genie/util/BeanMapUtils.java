package com.jd.genie.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class BeanMapUtils {

    private static final Logger log = LoggerFactory.getLogger(BeanMapUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 使用 Jackson 将 Bean 转换为 Map
     * 可以处理复杂对象和嵌套结构
     *
     * @param bean 要转换的 Bean 对象
     * @return 包含 Bean 属性的 Map
     */
    public static Map<String, Object> beanToMap(Object bean) {
        if (null == bean) {
            log.info("Bean must not be null");
            return null;
        }
        return objectMapper.convertValue(bean, new TypeReference<Map<String, Object>>() {});
    }
}