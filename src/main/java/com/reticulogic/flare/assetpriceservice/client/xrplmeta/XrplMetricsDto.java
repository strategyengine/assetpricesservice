package com.reticulogic.flare.assetpriceservice.client.xrplmeta;

import java.math.BigDecimal;

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
	
}
