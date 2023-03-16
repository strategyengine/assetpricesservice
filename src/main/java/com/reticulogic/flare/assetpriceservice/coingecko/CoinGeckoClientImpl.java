package com.reticulogic.flare.assetpriceservice.coingecko;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reticulogic.flare.assetpriceservice.service.SecretService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CoinGeckoClientImpl implements CoinGeckoClient {

	@Autowired
	private CloseableHttpClient closeableHttpClient;
	

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SecretService secretService;

	private String endpoint = "https://api.coingecko.com/api/v3/simple/price?ids=the-reaper,sgb,songbird,aquarius,beethoven-x,liquiddriver,deus-finance,fira,lumenswap,"
			+ "realio-network&vs_currencies=usd";


	@Override
	public Map<String, Map<String, Object>> getCoinGeckoPrices() {
		try {
			
//			URL url = new URL(endpoint);
			
//			URLConnection yc = url.openConnection();
//			
//
//	        BufferedReader in = new BufferedReader(new InputStreamReader(
//	                                    yc.getInputStream()));
//	        String inputLine;
//	        while ((inputLine = in.readLine()) != null) 
//	            System.out.println(inputLine);
//	        in.close();
			
			
			HttpResponse response = closeableHttpClient.execute(new HttpGet(endpoint));
			
			String responseString = new BasicResponseHandler().handleResponse(response);
						
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode != 200) {
				log.warn("No rates found from coingecko " + statusCode);
				return null;
			}

			Map<String, Map<String, Object>> rates = objectMapper.readValue(responseString,
					new TypeReference<Map<String, Map<String, Object>>>() {
					});

			return rates;
		} catch (

		Exception e) {
			log.error("Error calling coingecko", e);
		}

		return null;
	}

	public  String getResponseBody(HttpURLConnection conn) {
        BufferedReader br = null;
        StringBuilder body = null;
        String line = "";
        try {//  w  w w .j  a  v a 2s . c  o m
            br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            body = new StringBuilder();
            while ((line = br.readLine()) != null)
                body.append(line);
            return body.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  String getResponseBody(InputStream is) {
        BufferedReader br = null;
        StringBuilder body = null;
        String line = "";
        try {
            // we use xPath to get the baseUrl and accountId from the XML
            // response body
            br = new BufferedReader(new InputStreamReader(is));
            body = new StringBuilder();
            while ((line = br.readLine()) != null)
                body.append(line);
            return body.toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please
            // review it
        }
    }
}
