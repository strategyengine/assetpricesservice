package com.reticulogic.flare.assetpriceservice.coingecko;

import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CoinGeckoClientImpl implements CoinGeckoClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String endpoint = "https://api.coingecko.com/api/v3/simple/price?ids=the-reaper,songbird,aquarius,beethoven-x,liquiddriver,fira,lumenswap,ripple,"
			+ "realio-network&vs_currencies=usd";

	@Override
	public Map<String, Map<String, Object>> getCoinGeckoPrices() {

		HttpResponse response = null;
		try {

		   response = closeableHttpClient.execute(new HttpGet(endpoint));

			String responseString = new BasicResponseHandler().handleResponse(response);

			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				log.warn("No rates found from coingecko " + statusCode);
				return null;
			}

			Map<String, Map<String, Object>> rates = objectMapper.readValue(responseString,
					new TypeReference<Map<String, Map<String, Object>>>() {
					});

			return rates;
		} catch (

		Exception e) {
			log.error("Error calling coingecko " + response, e);
		}

		return null;
	}

}
