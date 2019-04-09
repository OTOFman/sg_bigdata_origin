package com.otof.tecentmarketing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.net.URI;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RequestCretiraEntity {

    private URI url;
    private HttpMethod httpMethod;
    private Class responseClassType;
    private HttpHeaders httpHeaders;
}
