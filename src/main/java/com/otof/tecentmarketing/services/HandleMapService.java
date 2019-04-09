package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.configuration.MapConfiguration;
import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import com.otof.tecentmarketing.entity.PoiResponseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

@Getter
@Setter
@Service
public class HandleMapService {

    private Map<String, String> immutableKeyMap;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MapConfiguration mapConfiguration;
    private HttpHeaders httpHeaders;
    public HandleMapService() {
        httpHeaders = new HttpHeaders();
    }

    @PostConstruct
    public void initMapConfig() {
        immutableKeyMap = Collections.singletonMap("key", mapConfiguration.getKey());
        immutableKeyMap.forEach( (k, v) -> httpHeaders.set(k, v));
    }

    public ResponseEntity<GeoCodeResponseEntity> getGeoCodeByName(String name, String city) throws URISyntaxException {

        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);

        URI uri = new URIBuilder(mapConfiguration.getGeoCodeUrl())
                .addParameter("address", name)
                .addParameter("city", city)
                .addParameter("key", mapConfiguration.getKey())
                .build();

        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                requestEntity,
                GeoCodeResponseEntity.class
        );
    }

    public ResponseEntity<PoiResponseEntity> getCommunitiesByLocation(String location, String radius, String types, int page) throws URISyntaxException {
        URI uri = new URIBuilder(mapConfiguration.getPoiUrl())
                .addParameter("location", location)
                .addParameter("radius", radius)
                .addParameter("types", types)
                .addParameter("page", Integer.toString(page))
                .addParameter("key", mapConfiguration.getKey())
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
        URI uri = new URIBuilder(mapConfiguration.getPoiUrl())
                .addParameter("location", location)
                .addParameter("radius", radius)
                .addParameter("key", mapConfiguration.getKey())
                .addParameter("keywords", String.join("|", keywords))
                .build();

        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders) ,
                PoiResponseEntity.class
        );
    }
}
