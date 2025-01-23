package io.currencybot.currency_rate_bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.currencybot.currency_rate_bot.model.coin_market_cap.RequestQuoteData;
import io.currencybot.currency_rate_bot.model.crb.Currency;
import io.currencybot.currency_rate_bot.service.CoinMarketCapComponent;
import io.currencybot.currency_rate_bot.service.CrbCurrencyRates;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private CoinMarketCapComponent capComponent;
	
	@Autowired 
	private CrbCurrencyRates crbCurrencyRates;

	@Test
	void chekTon() {
		RequestQuoteData requestQuoteData = capComponent.getQuotesLatest("TON");
		System.out.println("request: " + requestQuoteData.getData().get("TON")[0].getQuote().get("USD").getPrice());
		assertNotEquals(requestQuoteData, null);
	}
	
	@Test
	void chekBitcoin() {
		RequestQuoteData requestQuoteData = capComponent.getQuotesLatest("BTC");
		System.out.println("request: " + requestQuoteData.getData().get("BTC")[0].getQuote().get("USD").getPrice());
		assertNotEquals(requestQuoteData, null);
	}
	
	@Test
	void chekEth() {
		RequestQuoteData requestQuoteData = capComponent.getQuotesLatest("ETH");
		System.out.println("request: " + requestQuoteData.getData().get("ETH")[0].getQuote().get("USD").getPrice());
		assertNotEquals(requestQuoteData, null);
	}
	
	@Test
	void chekUsdt() {
		RequestQuoteData requestQuoteData = capComponent.getQuotesLatest("USDT");
		System.out.println("request: " + requestQuoteData.getData().get("USDT")[0].getQuote().get("USD").getPrice());
		assertNotEquals(requestQuoteData, null);
	}
	
	@Test
	void checkCrbQuote() {
		Map<String, Currency> maps = crbCurrencyRates.getRates();
		assertNotEquals(maps, null);
	}

}
