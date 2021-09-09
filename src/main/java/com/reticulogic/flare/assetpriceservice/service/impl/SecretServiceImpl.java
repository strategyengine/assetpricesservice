package com.reticulogic.flare.assetpriceservice.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.reticulogic.flare.assetpriceservice.service.SecretService;

import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SecretServiceImpl implements SecretService {

	private static final String COINLAYER_SECRET_KEY = "coinlayerapikey";
	private static final String PROJECT_ID = "1091305102443";

	private String coinLayerApiKeyValue = null;

	@PostConstruct
	public void init() throws Exception {

		try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
			coinLayerApiKeyValue = getSecret(COINLAYER_SECRET_KEY, client);
		}
	}

	public String getSecret(String secretId, SecretManagerServiceClient client) {

		String path = String.format("projects/%s/secrets/%s/versions/latest", PROJECT_ID, secretId);
		// Access the secret version.
		AccessSecretVersionResponse response = client.accessSecretVersion(path);

		return response.getPayload().getData().toStringUtf8();
	}

	@Override
	public String getCoinLayerApiKey() {
		return coinLayerApiKeyValue;
	}

}
