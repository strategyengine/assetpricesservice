package com.reticulogic.flare.assetpriceservice;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.reticulogic.flare.assetpriceservice.http.HttpClientUtil;


@Configuration
public class AssetPriceServiceConfig {

	@Bean
	public CloseableHttpClient closeableHttpClient() {
		return HttpClientUtil.createCloseableHttpClient(5, 5, 30000, 20000, 20000, 20000);
	}


}
