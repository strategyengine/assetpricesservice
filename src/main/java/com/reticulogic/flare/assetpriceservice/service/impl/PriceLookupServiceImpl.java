package com.reticulogic.flare.assetpriceservice.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.AssetLookupService;
import com.reticulogic.flare.assetpriceservice.service.PriceLookupService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PriceLookupServiceImpl implements PriceLookupService {

	// fetch tokens from songbird --
	// https://songbird-explorer.flare.network/tokens?type=JSON

	// first sample lookup service calls coinlayer
	@VisibleForTesting
	@Autowired
	@Qualifier("coinLayerService")
	protected AssetLookupService coinLayerLookupService;

	@VisibleForTesting
	@Autowired
	@Qualifier("coinMarketCapService")
	protected AssetLookupService coinMarketCapService;

	@Autowired
	@Qualifier("coinGeckoService")
	protected AssetLookupService coinGeckoService;
	
	// there will be many lookup services for redundancy and if certain assets are
	// only available from some services
	List<AssetLookupService> lookupServices = new ArrayList<AssetLookupService>();

	@PostConstruct
	public void init() {
		lookupServices.add(coinMarketCapService);
		lookupServices.add(coinLayerLookupService);
		lookupServices.add(coinGeckoService);
	}

	@Cacheable("assetValuesCache")
	@Override
	public List<AssetValue> getAssetPrices() {
		Set<AssetValue> assetValues = lookupServices.stream().map(l -> getAssets(l)).flatMap(List::stream)
				.collect(Collectors.toSet());
		List<AssetValue> assetValueLst = new ArrayList<AssetValue>(assetValues);

		Collections.sort(assetValueLst, (a, b) -> a.getAsset().compareTo(b.getAsset()));

		return assetValueLst;
	}

	private List<AssetValue> getAssets(AssetLookupService l) {

		try {
			List<AssetValue> assets = l.getAssetPrices();
			log.debug("Found assets from {} total {}", l.getClass().getName(), assets.size());
			return assets;
		} catch (Exception e) {
			log.error("Error looking up assets " + l, e);

		}
		return ImmutableList.of();
	}

}
