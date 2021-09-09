package com.reticulogic.flare.assetpriceservice.http;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public final class HttpClientUtil {

	private HttpClientUtil() {
	}

	public static final CloseableHttpClient createCloseableHttpClient(int maxTotalConnections, int maxPerRoute,

			int validateAfterInactivity, int connectTimeout, int connectionRequestTimeout, int socketTimeout,
			HttpRequestInterceptor... interceptors) {

		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

		poolingHttpClientConnectionManager.setMaxTotal(maxTotalConnections);

		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute);

		poolingHttpClientConnectionManager.setValidateAfterInactivity(validateAfterInactivity);

		RequestConfig config = RequestConfig.custom()

				.setConnectTimeout(connectTimeout)

				.setConnectionRequestTimeout(connectionRequestTimeout)

				.setSocketTimeout(socketTimeout)

				.build();

		final HttpClientBuilder httpClientBuilder = HttpClients.custom()

				.setConnectionManager(poolingHttpClientConnectionManager)

				.setDefaultRequestConfig(config)

				.disableCookieManagement();

		if (interceptors != null) {

			for (int i = 0; i < interceptors.length; i++) {

				httpClientBuilder.addInterceptorFirst(interceptors[i]);

			}

		}

		return httpClientBuilder.build();

	}

}
