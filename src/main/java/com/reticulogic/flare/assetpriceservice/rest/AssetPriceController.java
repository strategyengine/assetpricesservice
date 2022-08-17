package com.reticulogic.flare.assetpriceservice.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reticulogic.flare.assetpriceservice.client.xrplmeta.XrplTokenPriceDto;
import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.PriceLookupService;
import com.reticulogic.flare.assetpriceservice.service.XrplService;


@RestController
public class AssetPriceController {

	@Autowired
	private PriceLookupService priceLookupService;
	
	@Autowired
	private XrplService xrplService;
	

	@RequestMapping(value = "/assetprices", method = RequestMethod.GET)
	public List<AssetValue> prices() {

		return priceLookupService.getAssetPrices();
	}

	@RequestMapping(value = "/assetprice/{asset}", method = RequestMethod.GET)
	public AssetValue prices(@PathVariable("asset") String asset) {

		List<AssetValue> assets = priceLookupService.getAssetPrices();

		Optional<AssetValue> assetVal = assets.stream().filter(a -> a.getAsset().equals(asset)).findAny();

		return assetVal.isEmpty() ? null : assetVal.get();
	}
	
	@RequestMapping(value = "/assetprice/xrpl/issued/{currency}/{issuer}", method = RequestMethod.GET)
	public XrplTokenPriceDto getXrplIssuedPrices(@PathVariable(value="currency") String currency,
			@PathVariable("issuer") String issuer) {

		XrplTokenPriceDto asset = xrplService.getXrplIssuedPrice(currency, issuer);

		return asset;
	}

}