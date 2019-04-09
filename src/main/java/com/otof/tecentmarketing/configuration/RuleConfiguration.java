package com.otof.tecentmarketing.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@Component
@PropertySource("classpath:properties/textvalue.properties")
@ConfigurationProperties(prefix = "rule.competitor")
public class RuleConfiguration {
    private int badness;
    private int notbad;
    private int good;
    private int excellent;
}
