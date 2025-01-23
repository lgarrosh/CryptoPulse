package io.currencybot.currency_rate_bot.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import io.currencybot.currency_rate_bot.model.coin_market_cap.RequestQuoteData;
import io.currencybot.currency_rate_bot.properties.AppProperties;
import io.currencybot.currency_rate_bot.utils.WebClientConfig;
import reactor.core.publisher.Mono;

@Component
public class CoinMarketCapComponent {
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private WebClientConfig webClient;
	
	private static final String QUOTES_LATEST_ENDPOINT = "/v2/cryptocurrency/quotes/latest";
	
	private static final Logger log = LoggerFactory.getLogger(CoinMarketCapComponent.class);
	
	public CoinMarketCapComponent() {
		log.info("CoinMarketCapComponent bean created");
	}
	
	public RequestQuoteData getQuotesLatest(String symbol) {
		HashMap<String, String> headersHashMap = new HashMap<String, String>();
		headersHashMap.put("X-CMC_PRO_API_KEY", appProperties.getCoinMarketCapKey());
		
		@SuppressWarnings("deprecation")
		String uri = UriComponentsBuilder.fromHttpUrl(appProperties.getCoinMarketCapUrl())
				        .path(QUOTES_LATEST_ENDPOINT)
				        .queryParam("symbol", symbol)
				        .toUriString();
		
		Mono<String> responseMono= webClient.getRequest(uri, headersHashMap);
		Gson gson = new Gson(); 
		
		try {
			return gson.fromJson(responseMono.block(), RequestQuoteData.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
