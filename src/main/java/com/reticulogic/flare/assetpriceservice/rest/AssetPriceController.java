package com.reticulogic.flare.assetpriceservice.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.PriceLookupService;


@RestController
public class AssetPriceController {

	@Autowired
	private PriceLookupService priceLookupService;

	@RequestMapping(value = "/assetprices", method = RequestMethod.GET)
	public List<AssetValue> prices() {

		return priceLookupService.getAssetPrices();
	}

	@RequestMapping(value = "/assetprice/{asset}", method = RequestMethod.GET)
	public AssetValue prices(@PathParam("asset") String asset) {

		List<AssetValue> assets = priceLookupService.getAssetPrices();

		Optional<AssetValue> assetVal = assets.stream().filter(a -> a.getAsset().equals(asset)).findAny();

		return assetVal.isEmpty() ? null : assetVal.get();
	}

}