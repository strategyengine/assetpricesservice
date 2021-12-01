package com.reticulogic.flare.assetpriceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableCaching
@SpringBootApplication
public class AssetpriceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetpriceserviceApplication.class, args);
	}

}
