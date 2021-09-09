package com.reticulogic.flare.assetpriceservice.service;

import java.util.List;

import com.reticulogic.flare.assetpriceservice.model.AssetValue;
/**
 * Interface used by any lookup services for fetching asset prices
 * @author barry
 *
 */
public interface AssetLookupService {

	List<AssetValue> getAssetPrices();
	
}
