package com.otof.tecentmarketing.requests;

import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.entity.RequestCretiraEntity;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class HandleMultiplePageRequest {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<PoiResponseEntity> getInfoFromSpecificPage(RequestCretiraEntity requestCretiraEntity, int currentPage) throws URISyntaxException {
        URI uri = new URIBuilder(requestCretiraEntity.getUrl()).addParameter("page", Integer.toString(currentPage)).build();
        HttpMethod httpMethod = requestCretiraEntity.getHttpMethod();
        HttpHeaders httpHeaders = requestCretiraEntity.getHttpHeaders();
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        Class responseClassType = requestCretiraEntity.getResponseClassType();

        return restTemplate.exchange(uri, httpMethod, httpEntity, responseClassType);
    }
}
