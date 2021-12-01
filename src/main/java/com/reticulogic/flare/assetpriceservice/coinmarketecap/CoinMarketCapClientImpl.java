package com.reticulogic.flare.assetpriceservice.coinmarketecap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reticulogic.flare.assetpriceservice.coinloan.CoinLayerRates;
import com.reticulogic.flare.assetpriceservice.service.SecretService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CoinMarketCapClientImpl implements CoinMarketCapClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SecretService secretService;

	String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

	@Override
	public CoinMarketCapRates getRates() {

		List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
		paratmers.add(new BasicNameValuePair("start", "1"));
		paratmers.add(new BasicNameValuePair("limit", "300"));
		paratmers.add(new BasicNameValuePair("convert", "USD"));

		try {
			return makeAPICall(uri, paratmers);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private CoinMarketCapRates makeAPICall(String uri, List<NameValuePair> parameters)
			throws URISyntaxException, IOException {

		URIBuilder query = new URIBuilder(uri);
		query.addParameters(parameters);

		HttpGet request = new HttpGet(query.build());

		request.setHeader(HttpHeaders.ACCEPT, "application/json");
		request.addHeader("X-CMC_PRO_API_KEY", secretService.getCoinMarketCapApiKey());
		
		try (CloseableHttpResponse httpResponse = closeableHttpClient.execute(request)){
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			
			if(statusCode != 200) {
				log.warn("No rates found from coinloan " + statusCode);
				return null;
			}

			return objectMapper.readValue(httpResponse.getEntity().getContent(), CoinMarketCapRates.class);
			
		}catch(Exception e) {
			log.error("Error calling coinmarketcap", e);
			throw new RuntimeException(e);
		}
		

	}
}
