package com.reticulogic.flare.assetpriceservice.coinloan;

import javax.annotation.PostConstruct;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reticulogic.flare.assetpriceservice.service.SecretService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CoinLayerClientImpl implements CoinLayerClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private SecretService secretService;
	
	private String endpoint = "http://api.coinlayer.com/api/live?access_key=";
	
	@PostConstruct
	public void init() {
		
		endpoint += secretService.getCoinLayerApiKey();
	}
	
	@Override
	public CoinLayerRates getCoinLayerRates(){
		
		HttpGet httpGet = new HttpGet(endpoint);
		
		try (CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpGet)){
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			
			if(statusCode != 200) {
				log.warn("No rates found from coinlayer " + statusCode);
				return null;
			}
			
			CoinLayerRates rates = objectMapper.readValue(httpResponse.getEntity().getContent(), 
					CoinLayerRates.class);
			
			return rates;
		}catch(Exception e) {
			log.error("Error calling coinlayer", e);
		}
		
		return null;
	}  
}
