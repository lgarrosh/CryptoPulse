package io.currencybot.currency_rate_bot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import io.currencybot.currency_rate_bot.model.coin_market_cap.RequestQuoteData;
import io.currencybot.currency_rate_bot.model.coin_market_cap.RequestedCryptocurrency;
import io.currencybot.currency_rate_bot.properties.AppProperties;
import io.currencybot.currency_rate_bot.utils.WebClientConfig;
import reactor.core.publisher.Mono;

@Component
public class CoinMarketCapComponent {
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private WebClientConfig webClient;
	
	private static final String[] COINID = {"1", "1027", "11419"};
	
	private static final String QUOTES_LATEST_ENDPOINT = "/v2/cryptocurrency/quotes/latest";
	
	private static final Logger log = LoggerFactory.getLogger(CoinMarketCapComponent.class);
	
	public CoinMarketCapComponent() {
		log.info("CoinMarketCapComponent bean created");
	}
	
	public List<RequestedCryptocurrency> getRates() {
		RequestQuoteData rates = getQuotesLatest(String.join(",", COINID));
		if (rates != null) {
			return new ArrayList<>(rates.getData().values());
		}
		return null;
	}
	
	public List<RequestedCryptocurrency> getRates(String...strings) {
		RequestQuoteData rates = getQuotesLatest(String.join(",", strings));
		if (rates != null) {
			return new ArrayList<>(rates.getData().values());
		}
		return null;
	}
	
	private RequestQuoteData getQuotesLatest(String id) {
		
		HashMap<String, String> headersHashMap = new HashMap<String, String>();
		headersHashMap.put("X-CMC_PRO_API_KEY", appProperties.getCoinMarketCapKey());
		
		@SuppressWarnings("deprecation")
		String uri = UriComponentsBuilder.fromHttpUrl(appProperties.getCoinMarketCapUrl())
				        .path(QUOTES_LATEST_ENDPOINT)
				        .queryParam("id", id)
				        .toUriString();
		
		Mono<String> responseMono = webClient.getRequest(uri, headersHashMap);
		
		Gson gson = new Gson();
		try {
			String response = responseMono.block();
			return gson.fromJson(response, RequestQuoteData.class);
		} catch (WebClientResponseException e) {
		    log.info("Ошибка HTTP: " + e.getStatusCode());
		    log.info("Ответ сервера: " + e.getResponseBodyAsString());
		} catch (JsonSyntaxException e) {
			log.info("Ошибка дисереализации " + this.getClass().getName());
			log.info(e.getMessage());
		}
		return null;
	}
}
