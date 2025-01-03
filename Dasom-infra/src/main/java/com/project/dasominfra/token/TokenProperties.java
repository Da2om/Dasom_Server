package com.project.dasominfra.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt")
public class TokenProperties {
    private Long accessExp;
    private Long refreshExp;
    private String prefix;
    private String header;
    private String secretKey;
}