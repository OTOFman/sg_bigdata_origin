package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.BusinessResponseEntity;
import com.otof.tecentmarketing.entity.NameValueEntity;
import com.otof.tecentmarketing.entity.OpenPointEntity;
import com.otof.tecentmarketing.utils.GenerateMeituanSign;
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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
@ConfigurationProperties(prefix = "service.business")
public class HandleBusinessService {

    private static final String CATEGORY = "亲子照";
    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private String businessInfoUrl;
    private String appKey;
    private String deviceId;
    private String signMethod;
    private String format;
    private String v;
    private String session;
    private String secret;
    private Map<String, String> paramsKeyMap;

    public HandleBusinessService() {
        httpHeaders = new HttpHeaders();
    }

    @PostConstruct
    public void initParams() {
        paramsKeyMap = new HashMap<>();
        paramsKeyMap.put("app_key", appKey);
        paramsKeyMap.put("deviceId", deviceId);
        paramsKeyMap.put("format", format);
        paramsKeyMap.put("v", v);
        paramsKeyMap.put("session", session);
        paramsKeyMap.put("sign_method", signMethod);
        paramsKeyMap.put("category", CATEGORY);

    }

    public ResponseEntity<BusinessResponseEntity> getSurroundBusiness(
            float latitude,
            float longitude,
            int radius,
            int page) throws IOException, NoSuchAlgorithmException, URISyntaxException {

        paramsKeyMap.put("page", Integer.toString(page));
        paramsKeyMap.put("radius", Integer.toString(radius));
        paramsKeyMap.put("open_points", new OpenPointEntity(latitude, longitude).toString());
        paramsKeyMap.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis())));
        if (paramsKeyMap.get("sign") != null) {
            paramsKeyMap.remove("sign");
        }
        String signKey = GenerateMeituanSign.signTopRequest(paramsKeyMap, secret, signMethod);
        paramsKeyMap.put("sign", signKey);

        URI uri = new URIBuilder(businessInfoUrl)
                .addParameters(NameValueEntity.buildNvpList(paramsKeyMap))
                .build();
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                BusinessResponseEntity.class
        );
    }

    public String getBusinessInfoUrl() {
        return businessInfoUrl;
    }

    public void setBusinessInfoUrl(String businessInfoUrl) {
        this.businessInfoUrl = businessInfoUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSignMethod() {
        return signMethod;
    }

    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
