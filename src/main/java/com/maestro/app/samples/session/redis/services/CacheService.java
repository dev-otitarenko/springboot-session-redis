package com.maestro.app.samples.session.redis.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {
    private static final String CONTROLLED_PREFIX = "myPrefix_";

    public static String getCacheKey(String relevant){
        return CONTROLLED_PREFIX + relevant;
    }

    @Cacheable(cacheNames = "myCache", key = "T(com.maestro.app.samples.session.redis.services.CacheService).getCacheKey(#key)")
    public String cacheThis(String key, String val) {
        log.info("\t Returning NOT from cache. Tracking: {}, {}!", key, val);
        return val;
    }

    @CacheEvict(cacheNames = "myCache", key = "T(com.maestro.app.samples.session.redis.services.CacheService).getCacheKey(#key)")
    public void forgetAboutThis(String key) {
        log.info("\t Forgetting everything about this '{}'!", key);
    }
}
