package com.reticulogic.flare.assetpriceservice.client.songbird;

import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.reticulogic.flare.assetpriceservice.client.xrplmeta.XrplTokenPriceDto;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * SGB price
 * https://index.flr.finance/v1/swaps/price/0x47C830E141234d029D953dF39B13d7728eB9f2d4
 * 
 * [{"_id":"62ffb172e8320c00044b5aaa","pair":"0x47C830E141234d029D953dF39B13d7728eB9f2d4","direction":"sell","rate":"25.1967488699016654443571159723039801","rateCross":"0.039687659910542364","timestamp":"2022-08-19T15:51:11.000Z","amountIn":"3660.07406","amountOut":"145.259774540678035316","sender":"0xebbe40f9a5f131fbb108e8c05db66530c02af3e3","volume":"145.259774540678035316","transactionHash":"0xe05308cc90c59e82f10bf213d23cac49b7178d00694095f3d69638b563d37a83","__v":0}]
 * 
 * rateCross is the price in canary dollars
 * 
 * EXFI price
 * https://index.flr.finance/v1/swaps/price/0xB5BF334B8Cc30B8B13fc035d171D77A217aaB091
 * 
 * SFIN price
 * https://index.flr.finance/v1/swaps/price/0x48195Ca4D228ce487AE2AE1335B017a95493Ade6
 * 
 * COOT price
 * https://index.flr.finance/v1/swaps/price/0x07852D5C7fd1d630Dd79148A195aaAF72241680D
 * 
 * @author barry
 *
 *
 *explorers
 *https://songbird-explorer.flare.network/tokens
 *https://flare-explorer.flare.network/tokens
 *
 *
 */
@Log4j2
@Service
public class SgbFlrFinanceClientImpl implements SgbFlrFinanceClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;

	@Autowired
	private ObjectMapper objectMapper;

	private String endpoint = "https://index.flr.finance/v1/swaps/price/";


	private static int MAX_ATTEMPTS = 3;

	// offset starts at 0
	@Override
	public FlrFinanceDto getPrice(SgbPriceType priceType) {
		

		HttpGet httpGet = new HttpGet(endpoint + priceType.priceType);

		try (CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpGet)) {

			int statusCode = httpResponse.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				log.warn("Not data found SgbFlrFinanceClientImpl "  + priceType);
				return null;
			}

			List<FlrFinanceDto> data = objectMapper.readValue(httpResponse.getEntity().getContent(),
					new TypeReference<List<FlrFinanceDto>>() {
					});

			return data.isEmpty()? null : data.get(0);
		} catch (Exception e) {
			log.error("Error calling xrplmeta", e);
		}

		return null;
	}

}
