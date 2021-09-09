package com.reticulogic.flare.assetpriceservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.PriceLookupService;

//TODO:  

@RestController
public class AssetPriceController {

	@Autowired
	private PriceLookupService priceLookupService;
	
	
	@RequestMapping(value = "/api/assetprices", method = RequestMethod.GET)
	public List<AssetValue> prices() {
		return priceLookupService.getAssetPrices();
	}

}