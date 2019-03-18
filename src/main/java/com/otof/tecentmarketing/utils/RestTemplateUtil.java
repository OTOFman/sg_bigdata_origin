package com.otof.tecentmarketing.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Configuration
public class RestTemplateUtil {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
