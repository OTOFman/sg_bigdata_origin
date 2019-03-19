package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@ConfigurationProperties(prefix = "service.map")
public class HandleMapService {

    private String key;
    private String geoCodeUrl;
    private String poiUrl;
    private Map<String, String> immutableKeyMap;
    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    public HandleMapService() {
        httpHeaders = new HttpHeaders();
    }

    @PostConstruct
    public void initMapConfig() {
        immutableKeyMap = Collections.singletonMap("key", key);
        immutableKeyMap.forEach( (k, v) -> httpHeaders.set(k, v));
    }

    public ResponseEntity<GeoCodeResponseEntity> getGeoCodeByName(String name, String city) throws URISyntaxException {

        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);

        URI uri = new URIBuilder(geoCodeUrl)
                .addParameter("address", name)
                .addParameter("city", city)
                .addParameter("key", key)
                .build();

        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                requestEntity,
                GeoCodeResponseEntity.class
        );
    }

    public ResponseEntity<PoiResponseEntity> getCommunitiesByLocation(String location, String radius, String types) throws URISyntaxException {
        URI uri = new URIBuilder(poiUrl)
                .addParameter("location", location)
                .addParameter("radius", radius)
                .addParameter("types", types)
                .addParameter("key", key)
                .build();
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders) ,
                PoiResponseEntity.class
        );
    }

    public ResponseEntity<PoiResponseEntity> getSurroundInstitutes(String location,
                                                                   String radius,
                                                                   List<String> keywords) throws URISyntaxException {
        URI uri = new URIBuilder(poiUrl)
                .addParameter("location", location)
                .addParameter("radius", radius)
                .addParameter("key", key)
                .addParameter("keywords", String.join("|", keywords))
                .build();

        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders) ,
                PoiResponseEntity.class
        );
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getGeoCodeUrl() {
        return geoCodeUrl;
    }

    public void setGeoCodeUrl(String geoCodeUrl) {
        this.geoCodeUrl = geoCodeUrl;
    }

    public String getPoiUrl() {
        return poiUrl;
    }

    public void setPoiUrl(String poiUrl) {
        this.poiUrl = poiUrl;
    }
}
