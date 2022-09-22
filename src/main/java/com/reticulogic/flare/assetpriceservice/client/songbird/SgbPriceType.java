package com.reticulogic.flare.assetpriceservice.client.songbird;

public enum SgbPriceType {

	
	CONTRACT_SONGBIRD_CANARY("0x47C830E141234d029D953dF39B13d7728eB9f2d4"),
	CONTRACT_EXFI_CANARY ( "0xB5BF334B8Cc30B8B13fc035d171D77A217aaB091"),
	CONTRACT_SFIN_CANARY ( "0x48195Ca4D228ce487AE2AE1335B017a95493Ade6"),
	CONTRACT_COOT_CANARY ( "0x07852D5C7fd1d630Dd79148A195aaAF72241680D");


	public final String priceType;
	
	private SgbPriceType(String t) {
		this.priceType = t;
	}
}
