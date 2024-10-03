package com.project.dasominfra.cloud;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;


@Configuration
@RequiredArgsConstructor
public class AwsS3Config {

    private final CloudProperties cloudProperties;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    public S3Client amazonS3Client() {
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(cloudProperties.getAccessKey(), cloudProperties.getSecretKey());

        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }

}
