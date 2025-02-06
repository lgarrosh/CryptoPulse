package io.currencybot.currency_rate_bot;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.currencybot.currency_rate_bot.model.coin_market_cap.RequestedCryptocurrency;
import io.currencybot.currency_rate_bot.model.crb.Currency;
import io.currencybot.currency_rate_bot.properties.AppProperties;
import io.currencybot.currency_rate_bot.service.CoinMarketCapComponent;
import io.currencybot.currency_rate_bot.service.CrbCurrencyRates;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private CoinMarketCapComponent coinMarketCapComponent;
	
	@Autowired 
	private CrbCurrencyRates crbCurrencyRates;
	
	@Autowired
	private AppProperties appProperties;

	public static final String[] COIN = {"1", "1027", "11419"};
	
	@Test
	void сoinMarketCapComponentTest() {
		ArrayList<RequestedCryptocurrency> cryptoCurrency = (ArrayList<RequestedCryptocurrency>) coinMarketCapComponent.getRates();

		assertNotEquals(cryptoCurrency, null);
		assertNotEquals(cryptoCurrency.get(0), null);
		assertNotEquals(cryptoCurrency.get(0).getQuote(), null);
	}
	
	@Test
	void сoinMarketCapComponentTest2() {
		ArrayList<RequestedCryptocurrency> cryptoCurrency = (ArrayList<RequestedCryptocurrency>) coinMarketCapComponent.getRates("2", "3");

		assertNotEquals(cryptoCurrency, null);
		assertNotEquals(cryptoCurrency.get(0), null);
		assertNotEquals(cryptoCurrency.get(0).getQuote(), null);
	}
	
	@Test
	void checkCrbQuote() {
		List<Currency> valute = crbCurrencyRates.getRates();
		assertNotEquals(valute, null);
	}
	
	@Test
	void checkCrbQuote2() {
		List<Currency> valute1 = crbCurrencyRates.getRates("USD", "EUR");
		assertNotEquals(valute1, null);
	}
	
	@Test
	void checkAppProperties() {
		assertNotEquals(appProperties.getCoinMarketCapKey(), null);
	}
}
