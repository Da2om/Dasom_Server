package com.project.dasominfra.cloud.service;

import com.project.dasomcore.notice.application.service.AwsS3Service;
import com.project.dasomcore.notice.domain.exception.FileUploadException;
import com.project.dasominfra.cloud.CloudProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AwsS3ServiceImpl implements AwsS3Service {

    private final CloudProperties cloudProperties;

    private final S3Client s3Client;
    /**
     * AWS S3에 이미지 파일 업로드
     * @param file : 파일
     * @param dirName : s3 버킷에서 만들어준 폴더 이름
     * @return : Url
     */
    public String upload(MultipartFile file, String dirName){
        String encodedFilename = encodeFilename(file.getName(),dirName);
        String bucketName = cloudProperties.getBucket();

        // s3에 file 저장
        try(InputStream inputStream = file.getInputStream()){
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(encodedFilename)
                    .build();

            // 파일 업로드
            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, file.getSize()));
        } catch (IOException e){
            // 예외처리
            throw new FileUploadException();
        }

        // s3에 저장된 파일 url 얻어옴.
        String path = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(encodedFilename)).toExternalForm();

        return "https://cloudfront-url" + path;
    }

    // 파일 이름이 같으면 저장이 안 된다. 따라서 파일이름 앞에 UUID를 붙인다.
    private String encodeFilename(String fileName, String dirName){
        return dirName + "/" + UUID.randomUUID() + fileName;
    }

}
