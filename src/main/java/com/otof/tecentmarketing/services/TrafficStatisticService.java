package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.configuration.MapConfiguration;
import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.entity.PoisEntity;
import com.otof.tecentmarketing.entity.RequestCretiraEntity;
import com.otof.tecentmarketing.entity.SurroundInstitutesResponseEntity;
import com.otof.tecentmarketing.entity.evaluation.TrafficEvaluation;
import com.otof.tecentmarketing.enums.KiloEnum;
import com.otof.tecentmarketing.requests.MultiplePageRequest;
import com.otof.tecentmarketing.rules.TrafficStatisticRules;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service
public class TrafficStatisticService implements StatisticService {

    @Autowired
    private MapConfiguration mapConfiguration;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MultiplePageRequest multiplePageRequest;
    @Autowired
    private TrafficStatisticRules trafficStatisticRules;

    public TrafficEvaluation getTrafficEvaluation(String location) throws URISyntaxException, InterruptedException {
        List<PoisEntity> poisEntityList = getSurroundPois(location, KiloEnum.ONEKILOMETER.radius);
        return trafficStatisticRules.analysisTraffic(poisEntityList);
    }

    @Override
    public List<PoisEntity> getSurroundPois(String location, String radius) throws URISyntaxException, InterruptedException {

        URI uri = new URIBuilder(mapConfiguration.getPoiUrl())
                .addParameter("location", location)
                .addParameter("radius", radius)
                .addParameter("keywords", mapConfiguration.getTrafficKeywords())
                .addParameter("key", mapConfiguration.getKey())
                .build();

        HttpEntity<?> httpEntity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<SurroundInstitutesResponseEntity> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                SurroundInstitutesResponseEntity.class
        );

        String totalAmount = responseEntity.getBody().getCount();
        RequestCretiraEntity requestCretiraEntity = new RequestCretiraEntity(uri, HttpMethod.GET, PoiResponseEntity.class, new HttpHeaders());
        return multiplePageRequest.getAllResultsByRequest(requestCretiraEntity, totalAmount);
    }
}
