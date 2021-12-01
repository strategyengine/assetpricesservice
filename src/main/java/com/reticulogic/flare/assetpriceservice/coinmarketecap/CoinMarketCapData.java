package com.reticulogic.flare.assetpriceservice.coinmarketecap;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CoinMarketCapData {

	String name;
	String symbol;
	Map<String, CoinMarketCapQuote> quote;
}
