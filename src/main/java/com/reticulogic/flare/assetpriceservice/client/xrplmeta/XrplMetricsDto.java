package com.reticulogic.flare.assetpriceservice.client.xrplmeta;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class XrplMetricsDto {

	private Integer trustlines;
	private Integer holders;
	private BigDecimal supply;
	private BigDecimal price;

	@JsonProperty("volume_24h")
	private String volume24h;
	@JsonProperty("volume_7d")
	private String volume7d;
	@JsonProperty("exchanges_24h")
	private String exchanges24h;
	@JsonProperty("exchanges_7d")
	private String exchanges7d;

}
