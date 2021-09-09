package com.reticulogic.flare.assetpriceservice.coinloan;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.AssetLookupService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CoinLayerServiceImpl implements AssetLookupService {

	private static final long EVERY_TWO_HOURS_MILLIS = 3600 * 1000 * 2;

	private static final long FIVE_MINUTES_MILLIS = 60 * 1000 * 5;

	@Autowired
	private CoinLayerClient coinLayerClient;

	// free up to 500 per month
	@Scheduled(fixedDelay = EVERY_TWO_HOURS_MILLIS, initialDelay = FIVE_MINUTES_MILLIS)
	@Override
	public List<AssetValue> getAssetPrices() {
		CoinLayerRates rates = coinLayerClient.getCoinLayerRates();

		List<AssetValue> assetValues = rates.getRates().keySet().stream().map(r -> convert(r, rates.getRates().get(r)))
				.collect(Collectors.toList());

		log.info("Found asset values: " + assetValues);
		return assetValues;
	}

	private AssetValue convert(String assetSymbol, Double usdVal) {
		return AssetValue.builder().asset(assetSymbol).usdValue(new BigDecimal(String.valueOf(usdVal))).build();
	}

}
