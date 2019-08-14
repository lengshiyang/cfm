package com.taichi.cfm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by shiyang.leng
 * on 2019/05/30
 * ClassDescription：
 */
@Configuration
public class RestTemplateConfig {
    @Value("${remote.maxTotalConn:500}")
    private int maxTotalConn;

    @Value("${remote.maxConnPerRoute:100}")
    private int maxConnPerRoute;

    @Value("${remote.connectTimeout:2000}")
    private int connectTimeout; // 建立链接 2s

    @Value("${remote.readTimeout:30000}")
    private int readTimeout; // 数据读取 30s

    @Bean
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);
        RestTemplate restTemplate = new RestTemplate(factory);

        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass() == StringHttpMessageConverter.class) {
                converterTarget = item;
                break;
            }
        }
        if (converterTarget != null) {
            converterList.remove(converterTarget);
        }

        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converterList.add(1, converter);

        return restTemplate;
    }
}
