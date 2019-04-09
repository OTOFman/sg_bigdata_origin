package com.otof.tecentmarketing.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "service.map")
public class MapConfiguration {

    private String key;
    private String geoCodeUrl;
    private String poiUrl;
    private String babyTypes;
    private String competitorTypes;
    private String competitorKeywords;
}
