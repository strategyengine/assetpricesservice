package com.reticulogic.flare.assetpriceservice;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.reticulogic.flare.assetpriceservice.http.HttpClientUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class AssetPriceServiceConfig {

	@Value("${assetpriceservice.version}")
	private String version;
	
	@Bean
	public CloseableHttpClient closeableHttpClient() {
		log.info("#### Version " + version);
		return HttpClientUtil.createCloseableHttpClient(5, 5, 30000, 20000, 20000, 20000);
	}


}
