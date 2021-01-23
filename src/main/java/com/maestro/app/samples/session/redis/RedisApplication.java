package com.maestro.app.samples.session.redis;

import com.maestro.app.samples.session.redis.services.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@EnableCaching
@SpringBootApplication
@Slf4j
public class RedisApplication implements CommandLineRunner {
	@Autowired
	CacheService cacheService;

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("First: {}", cacheService.cacheThis("param1", UUID.randomUUID().toString()));
		log.info("Second: {}", cacheService.cacheThis("param1", UUID.randomUUID().toString()));

		cacheService.forgetAboutThis("param1");
		log.info("Second: {}", cacheService.cacheThis("param1", UUID.randomUUID().toString()));

		log.info("Third: {}", cacheService.cacheThis("AnotherParam", UUID.randomUUID().toString()));
		log.info("Fourth: {}", cacheService.cacheThis("AnotherParam", UUID.randomUUID().toString()));
	}
}
