package com.reticulogic.flare.assetpriceservice.flarestrategyclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reticulogic.flare.assetpriceservice.model.AssetValueEvent;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FlareStrategyServiceClientImpl implements FlareStrategyServiceClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String endpoint = "https://flarestrategyengine-56gpv2b23a-uc.a.run.app/api/event/asset/usdvalue";

	@Override
	public void updateAssetValues(AssetValueEvent assetValueEvent) {

		
		HttpPost httpPost = new HttpPost(endpoint);

		try {
			StringEntity entity = new StringEntity(objectMapper.writeValueAsString(assetValueEvent));
			httpPost.setEntity(entity);
		} catch (Exception e) {
			log.error("Error converting to json " + assetValueEvent, e);
			return;
		}
		try (CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost)) {

			int statusCode = httpResponse.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				log.warn("No rates found from coinloan " + statusCode);
			}

		} catch (Exception e) {
			log.error("Error updating rates in flarestrategyengine", e);
		}

	}
}
