package com.reticulogic.flare.assetpriceservice.service;

import com.reticulogic.flare.assetpriceservice.client.xrplmeta.XrplTokenPriceDto;

public interface XrplService {

	XrplTokenPriceDto getXrplIssuedPrice(String currency, String issuer);

}
