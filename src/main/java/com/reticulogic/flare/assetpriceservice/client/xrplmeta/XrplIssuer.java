package com.reticulogic.flare.assetpriceservice.client.xrplmeta;

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
public class XrplIssuer {

	private String description;
	private String icon;
	private Boolean kyc;
	private String name;
	
	
	
}
