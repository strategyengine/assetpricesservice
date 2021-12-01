package com.reticulogic.flare.assetpriceservice.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.ImmutableList;
import com.reticulogic.flare.assetpriceservice.model.AssetValue;
import com.reticulogic.flare.assetpriceservice.service.AssetLookupService;

public class PriceLookupServiceImplTest {

	@Mock
	private AssetLookupService coinLayerLookupService;

	private PriceLookupServiceImpl sut;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		sut = new PriceLookupServiceImpl();
		sut.coinLayerLookupService = coinLayerLookupService;
		sut.init();

	}

	@Test
	public void testGetAssetPrices() {
//		List<AssetValue> expected = ImmutableList.of(AssetValue.builder().asset("FSE").usdValue(new BigDecimal("6")).build());
//		Mockito.when(coinLayerLookupService.getAssetPrices()).thenReturn(expected);
//
//		List<AssetValue> actual = sut.getAssetPrices();
//
//		Assertions.assertEquals(expected, actual);

	}

}
