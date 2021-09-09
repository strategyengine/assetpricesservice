package com.reticulogic.flare.assetpriceservice.flarestrategyclient;

import com.reticulogic.flare.assetpriceservice.model.AssetValueEvent;

public interface FlareStrategyServiceClient {

	void updateAssetValues(AssetValueEvent assetValueEvent);

}
