package com.reticulogic.flare.assetpriceservice.client.xrplmeta;

import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class XrplMetaOrgClientImpl implements XrplMetaOrgClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private String endpoint = "https://s1.xrplmeta.org/tokens?limit=%s&offset=$s";
	
	//https://s1.xrplmeta.org/token/FSE:rs1MKY54miDtMFEGyNuPd3BLsXauFZUSrj
	private String endpointToken = "https://s1.xrplmeta.org/token/%s:%s";
	
	
	//offset starts at 0
	@Override
	public List<XrplTokenPriceDto> getIssuedTokens(int limit, int offset){
		
		HttpGet httpGet = new HttpGet(endpoint);
		
		try (CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpGet)){
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			
			if(statusCode != 200) {
				log.warn(String.format("No data found from xrplmeta status:%s limit:%s offset:%s " , statusCode, limit, offset));
				return null;
			}
			
			List<XrplTokenPriceDto> data = objectMapper.readValue(httpResponse.getEntity().getContent(), 
					new TypeReference<List<XrplTokenPriceDto>>(){});
			
			return data;
		}catch(Exception e) {
			log.error("Error calling xrplmeta", e);
		}
		
		return null;
	}  
	
	@Override
	public XrplTokenPriceDto getIssuedToken(String currency, String issuer){
		
		String url = String.format(endpointToken, currency, issuer);
		HttpGet httpGet = new HttpGet(url);
		
		try (CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpGet)){
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			
			if(statusCode != 200) {
				log.warn(String.format("No data found from xrplmeta status:%s currency:%s issuer:%s " , statusCode, currency, issuer));
				return null;
			}
			
			XrplTokenPriceDto data = objectMapper.readValue(httpResponse.getEntity().getContent(), 
					XrplTokenPriceDto.class);
			
			return data;
		}catch(Exception e) {
			log.error("Error calling xrplmeta", e);
		}
		
		return null;
	}  
}
