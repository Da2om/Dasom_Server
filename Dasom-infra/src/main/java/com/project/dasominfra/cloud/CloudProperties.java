package com.project.dasominfra.cloud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cloud.aws.credentials")
public class CloudProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
}
