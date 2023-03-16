package com.reticulogic.flare.assetpriceservice.coingecko;

import java.util.Map;

public interface CoinGeckoClient {

	 Map<String, Map<String, Object>> getCoinGeckoPrices();

}
