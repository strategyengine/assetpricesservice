package com.reticulogic.flare.assetpriceservice.coinloan;

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
public class CoinLayerRates {

	
	private Boolean success;
	private String terms;
	private String privacy;
	private Long timestamp;
	private String target;
	private Map<String, Double> rates;
	
}

/*
example response 
{
"success": true,
"terms": "https:\/\/coinlayer.com\/terms",
"privacy": "https:\/\/coinlayer.com\/privacy",
"timestamp": 1629119646,
"target": "USD",
"rates": {
	"ABC": 59.99,
	"ACP": 0.014931,
	"ACT": 0.012301,
	"ACT*": 0.017178,
	"ADA": 2.154697,
	"ADCN": 0.00013,
	"ADL": 0.01515,
	"ADX": 0.512371,
	"ADZ": 0.0023,
	"AE": 0.1449
}
}
*/