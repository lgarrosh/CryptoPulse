package io.currencybot.currency_rate_bot.service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.currencybot.currency_rate_bot.model.crb.ExchangeRates;
import io.currencybot.currency_rate_bot.model.crb.Currency;
import io.currencybot.currency_rate_bot.properties.AppProperties;
import io.currencybot.currency_rate_bot.utils.WebClientConfig;
import reactor.core.publisher.Mono;

@Component
public class CrbCurrencyRates {
	
	private static final Logger log = LoggerFactory.getLogger(CrbCurrencyRates.class);
	
	@Autowired
	private WebClientConfig webClient;
	
	@Autowired
	private AppProperties appProperties;
	
	private ExchangeRates exchangeRates;
	
	public static final String[] VALUTE = {"AUD", "GBP", "AMD", "USD", "EUR"};
	
	
	
	public Map<String, Currency> getRates() {
		ExchangeRates rates = getRatesControler();
		Map<String, Currency> valute = new HashMap<String, Currency>();
		for (String i : VALUTE) {
			valute.put(i, rates.getValute().get(i));
		}
		return valute;
	}
	
	private ExchangeRates getRatesControler() {
		if (isNotRelevantRate()) {
			log.info("Запрос на получения курса валют");
			exchangeRates = getCourseFromCrb();
			return exchangeRates;
		}
		return exchangeRates;
	}
	
	private ExchangeRates getCourseFromCrb() {
		Mono<String> responseMono =  webClient.getRequest(appProperties.getCurrencyRateCrbUrl());
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			return objectMapper.readValue(responseMono.block(), ExchangeRates.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Boolean isEmptyExchangeRates() {
		return (exchangeRates == null || exchangeRates.getDate().isEmpty());
	}
	
	private Boolean isNotRelevantRate() {
		if (isEmptyExchangeRates()) {
			return true;
		} else {
			String ratesDate = exchangeRates.getTimestamp().substring(0, exchangeRates.getTimestamp().length()-6);
			LocalDateTime cuurentDate = LocalDateTime.now();
			LocalDateTime rateDate = LocalDateTime.parse(ratesDate);
			
			Duration duration = Duration.between(rateDate, cuurentDate);
			Long timeDifference = duration.toHours();
	        if (timeDifference > 12 && !isWeekend(cuurentDate)) {
	        	log.info("курс просрочен");
	        	return true;
	        }
		}
		return false;
	}
	
    private static boolean isWeekend(LocalDateTime dateTime) {
        DayOfWeek day = dateTime.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

}
