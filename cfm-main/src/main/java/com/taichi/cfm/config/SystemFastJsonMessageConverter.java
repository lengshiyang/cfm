package com.taichi.cfm.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 继承FastJsonHttpMessageConverter解析器， 重写read方法， 添加上传报文打印
 */
public class SystemFastJsonMessageConverter extends FastJsonHttpMessageConverter {
    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream in = inputMessage.getBody();
        String message = IOUtils.toString(in, super.getFastJsonConfig().getCharset().toString());
        logger.debug("请求报文: " + message);
        return JSON.parseObject(message, type, super.getFastJsonConfig().getFeatures());
    }
}