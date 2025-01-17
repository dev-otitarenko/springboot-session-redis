package com.maestro.app.samples.session.redis.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "cache")
@Data
public class RedisConfigurationProperties {
    private long timeoutSeconds = 60;
    private int redisPort = 6379;
    private String redisHost = "localhost";
    private Map<String, Long> cacheExpirations = new HashMap<>();
}
