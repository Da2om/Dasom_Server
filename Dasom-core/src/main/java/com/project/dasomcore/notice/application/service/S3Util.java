package com.project.dasomcore.notice.application.service;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class S3Util {

    public static final String BUCKET = "";

    public static String uploadFile(String uuid, InputStream inputStream)
            throws AwsServiceException, SdkClientException, IOException {

        AwsBasicCredentials credentials = AwsBasicCredentials.create("","");

        S3Client client = S3Client.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(uuid)
                .build();

        client.putObject(request,
                RequestBody.fromInputStream(inputStream,inputStream.available()));

        S3Presigner presigner = S3Presigner.create();

        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .bucket(BUCKET)
                .key(uuid)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofHours(1)) // The URL will expire in 10 minutes
                .getObjectRequest(objectRequest)
                .build();

        PresignedGetObjectRequest presignedRequest = presigner.presignGetObject(presignRequest);

        return presignedRequest.url().toExternalForm();
    }

}
