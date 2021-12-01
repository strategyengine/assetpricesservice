package com.reticulogic.flare.assetpriceservice.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.reticulogic.flare.assetpriceservice.service.SecretService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SecretServiceImpl implements SecretService {

	private static final String COINLAYER_SECRET_KEY = "coinlayerapikey";
	
	private String coinLayerApiKeyValue = null;

	private static final String COINMARKETCAP_SECRET_KEY = "coinmarketcapapikey";
	
	private String coinMarketCapApiKeyValue = null;

	
	@PostConstruct
	public void init() throws Exception {

			coinLayerApiKeyValue = System.getenv(COINLAYER_SECRET_KEY);
			coinMarketCapApiKeyValue = System.getenv(COINMARKETCAP_SECRET_KEY);
	}


	@Override
	public String getCoinMarketCapApiKey() {
		return coinMarketCapApiKeyValue;
	}
	
	@Override
	public String getCoinLayerApiKey() {
		return coinLayerApiKeyValue;
	}

}
