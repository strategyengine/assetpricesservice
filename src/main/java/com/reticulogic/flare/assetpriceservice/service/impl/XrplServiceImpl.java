package com.reticulogic.flare.assetpriceservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import com.reticulogic.flare.assetpriceservice.client.xrplmeta.XrplMetaOrgClient;
import com.reticulogic.flare.assetpriceservice.client.xrplmeta.XrplTokenPriceDto;
import com.reticulogic.flare.assetpriceservice.service.XrplService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class XrplServiceImpl implements XrplService {

	@VisibleForTesting
	@Autowired
	protected XrplMetaOrgClient xrplMetaOrgClient;

	@Override
	public XrplTokenPriceDto getXrplIssuedPrice(String currency, String issuer) {
		

			return xrplMetaOrgClient.getIssuedToken(currency, issuer);
	
			

	}



}
