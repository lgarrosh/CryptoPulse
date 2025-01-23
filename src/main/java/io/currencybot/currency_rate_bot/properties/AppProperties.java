package io.currencybot.currency_rate_bot.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	
	private static final Logger log = LoggerFactory.getLogger(AppProperties.class);
	
	private String telegramBotUrl;
	private String telegramBotToken;
	private String currencyRateCrbUrl;
	private String coinMarketCapUrl;
	private String coinMarketCapKey;

	public AppProperties() {
		log.info("AppProperties bean createed");
	}

	public String getFullUrl() {
		return telegramBotUrl + telegramBotToken;
	}

	public void setTelegramBotUrl(String telegramBotUrl) {
		this.telegramBotUrl = telegramBotUrl;
	}

	public void setTelegramBotToken(String telegramBotToken) {
		this.telegramBotToken = telegramBotToken;
	}

	public void setCurrencyRateCrbUrl(String currencyRateCrbUrl) {
		this.currencyRateCrbUrl = currencyRateCrbUrl;
	}
	
	public void setCoinMarketCapUrl(String coinMarketCapbUrl) {
		this.coinMarketCapUrl = coinMarketCapbUrl;
	}
	
	public void setCoinMarketCapKey(String coinMarketCapKey) {
		this.coinMarketCapKey = coinMarketCapKey;
	}
	
	public String getTelegramBotUrl() {
		return telegramBotUrl;
	}
	
	public String getTelegramBotToken() {
		return telegramBotToken;
	}

	public String getCurrencyRateCrbUrl() {
		return currencyRateCrbUrl;
	}

	public String getCoinMarketCapUrl() {
		return coinMarketCapUrl;
	}

	public String getCoinMarketCapKey() {
		return coinMarketCapKey;
	}
}
