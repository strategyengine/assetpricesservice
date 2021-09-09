package com.reticulogic.flare.assetpriceservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.AssetLookupService;
import com.reticulogic.flare.assetpriceservice.service.PriceLookupService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PriceLookupServiceImpl implements PriceLookupService {

	//first sample lookup service calls coinlayer
	@VisibleForTesting
	@Autowired
	protected AssetLookupService coinLayerLookupService;
	
	//there will be many lookup services for redundancy and if certain assets are only available from some services
	List<AssetLookupService> lookupServices = new ArrayList<AssetLookupService>();
	
	@PostConstruct
	public void init() {
	
		lookupServices.add(coinLayerLookupService);
		
	}
	
	@Override
	public List<AssetValue> getAssetPrices() {
		return lookupServices.stream().map(l -> getAssets(l)).flatMap(List::stream).collect(Collectors.toList());
	}

	private List<AssetValue> getAssets(AssetLookupService l) {
		
		List<AssetValue> assets = l.getAssetPrices();
		log.debug("Found assets from {} total {}", l.getClass().getName(), assets.size());
		return assets;
		
	}
	


}
