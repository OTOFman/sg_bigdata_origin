package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.configuration.MapConfiguration;
import com.otof.tecentmarketing.entity.*;
import com.otof.tecentmarketing.entity.evaluation.CooperatorEvaluation;
import com.otof.tecentmarketing.enums.KiloEnum;
import com.otof.tecentmarketing.requests.MultiplePageRequest;
import com.otof.tecentmarketing.rules.CooperatorStatisticRules;
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
import java.util.List;

@Setter
@Getter
@Service
public class CooperatorStatisticService implements StatisticService {

    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private CooperatorStatisticEntity cooperatorStatisticResult;

    @Autowired
    private CooperatorStatisticRules cooperatorStatisticRules;
    @Autowired
    private MapConfiguration mapConfiguration;
    @Autowired
    private MultiplePageRequest multiplePageRequest;


    @PostConstruct
    public void initHeader() {
        httpHeaders = new HttpHeaders();
        httpHeaders.set("key", mapConfiguration.getKey());
    }

    public CooperatorEvaluation getCooperatorEvaluation(String location) throws URISyntaxException, InterruptedException {
        List<PoisEntity> poisEntityList = getSurroundPois(location, KiloEnum.THREEKILOMETER.radius);
        return cooperatorStatisticRules.analysisCooperators(poisEntityList);
    }

    @Override
    public List<PoisEntity> getSurroundPois(String location, String radius) throws URISyntaxException, InterruptedException {

        URI uri = new URIBuilder(mapConfiguration.getPoiUrl())
                .addParameter("location", location)
                .addParameter("types", mapConfiguration.getCoorperatorKeywords())
                .addParameter("radius", radius)
                .addParameter("key", mapConfiguration.getKey())
                .build();

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<SurroundInstitutesResponseEntity> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                SurroundInstitutesResponseEntity.class
        );

        String totalAmount = responseEntity.getBody().getCount();
        RequestCretiraEntity requestCretiraEntity = new RequestCretiraEntity(uri, HttpMethod.GET, PoiResponseEntity.class, httpHeaders);
        return multiplePageRequest.getAllResultsByRequest(requestCretiraEntity, totalAmount);
    }
}
