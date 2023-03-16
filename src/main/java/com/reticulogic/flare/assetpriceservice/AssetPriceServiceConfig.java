package com.reticulogic.flare.assetpriceservice;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

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


	
	@Bean(name = "restTemplate")
	public RestTemplate xrplNftRestTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
	}
	
	

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 60000;
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}
	
}
