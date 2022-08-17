package com.reticulogic.flare.assetpriceservice;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CacheConfig {


  public static final String CACHE_NAME_ASSET_VALUES = "assetValuesCache";

  private static final int CACHE_NAME_ASSET_VALUES_MINUTES = 5;

  private static final int MAX_CACHE_SIZE_ASSET_VALUES = 5000;

  @Bean(name = CACHE_NAME_ASSET_VALUES)
  public CaffeineCache cacheSiteTestByName() {
    return new CaffeineCache(CACHE_NAME_ASSET_VALUES,
        Caffeine.newBuilder().expireAfterWrite(CACHE_NAME_ASSET_VALUES_MINUTES, TimeUnit.MINUTES)
            .maximumSize(MAX_CACHE_SIZE_ASSET_VALUES).recordStats().build());
  }

}

