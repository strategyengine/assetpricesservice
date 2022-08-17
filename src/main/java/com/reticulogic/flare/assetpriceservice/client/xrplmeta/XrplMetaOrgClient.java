package com.reticulogic.flare.assetpriceservice.client.xrplmeta;

import java.util.List;

public interface XrplMetaOrgClient {

	List<XrplTokenPriceDto> getIssuedTokens(int limit, int offset);

	XrplTokenPriceDto getIssuedToken(String currency, String issuer);

}
