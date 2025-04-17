package com.it.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "minio.oss")
public class MinIoProperties {
    private String endPoint;
    private String bucketName;
    private String accessKey;
    private String secretKey;


}
