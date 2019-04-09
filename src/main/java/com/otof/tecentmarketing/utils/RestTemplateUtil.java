package com.otof.tecentmarketing.utils;

import com.otof.tecentmarketing.configuration.MapConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateUtil {

    @Autowired
    private MapConfiguration mapConfiguration;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", mapConfiguration.getKey());
        return httpHeaders;
    }
}
