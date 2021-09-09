package com.reticulogic.flare.assetpriceservice.service;

import java.util.List;

import com.reticulogic.flare.assetpriceservice.model.AssetValue;

public interface PriceLookupService {

	List<AssetValue> getAssetPrices();

}
