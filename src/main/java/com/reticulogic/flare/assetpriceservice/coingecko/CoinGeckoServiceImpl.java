package com.reticulogic.flare.assetpriceservice.coingecko;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.AssetLookupService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service(value = "coinGeckoService")
public class CoinGeckoServiceImpl implements AssetLookupService {

	@Autowired
	private CoinGeckoClient coinGeckoClient;


	// free up to 500 per month

	@Override
	public List<AssetValue> getAssetPrices() {
		
		Map<String, Map<String, Object>> rates = coinGeckoClient.getCoinGeckoPrices();

		List<AssetValue> assetValues = rates.keySet().stream().map(r -> convert(r, rates.get(r)))
				.collect(Collectors.toList());

		log.info("Found asset values: " + assetValues);
		return assetValues;
	}

	private AssetValue convert(String assetSymbol, Map<String, Object> usdVal) {
		try {
			return AssetValue.builder().asset(assetSymbol).usdValue(new BigDecimal(String.valueOf(usdVal.get("usd"))))
					.build();
		} catch (Exception e) {
			log.error("Could not parse big decimal for " + assetSymbol + " " + usdVal);
		}
		return AssetValue.builder().asset(assetSymbol).usdValue(BigDecimal.ZERO).build();
	}

}
