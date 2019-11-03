package com.study.email.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "sqm.manager.mail")
public class LocalMailConfig {
    private String username;
    private String password;
    private String host;
    private String encoding;
}