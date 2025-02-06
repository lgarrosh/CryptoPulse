package io.currencybot.currency_rate_bot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import io.currencybot.currency_rate_bot.model.crb.Currency;

@Service
public class TelegramBotService {
	
	private static final Logger log = LoggerFactory.getLogger(TelegramBotService.class);
	
	@Autowired
	private TelegramBot bot;
	
	@Autowired
	private CrbCurrencyRates crbCurrencyRates;
	
	public void processing(Update update) {
		Long chatId = update.message().chat().id();
		String message = update.message().text();

		if (message.charAt(0) == '/') {
			BaseResponse baseResponse = commandControl(update);
			if (baseResponse != null) {
				log.info(baseResponse.isOk() ? "Успешно" : "Ошибка");
			}
		} else {
			SendMessage request = new SendMessage(chatId, message);
			BaseResponse baseResponse = bot.execute(request);
			log.info(baseResponse.isOk() ? "Успешно" : "Ошибка");
		}
	}
	
	private BaseResponse start(Long chatId) {
		SendMessage request = new SendMessage(chatId, "bot started");
		return bot.execute(request);
	}
	
	private BaseResponse rates(Long chatId) {
		List<Currency> rates = crbCurrencyRates.getRates();
		String ratesInfo = new String();
		for (Currency currency : rates) {
			if (!ratesInfo.isEmpty()) {
				ratesInfo += '\n';
			}
			ratesInfo += String.join("  -  ", currency.charCode, String.format("%1$,.2f", (currency.value / currency.nominal))).concat("     (" + currency.name + ")");
		}
		SendMessage request = new SendMessage(chatId, ratesInfo);
		return bot.execute(request);
	}
	
	private BaseResponse commandControl(Update update) {
		Long chatId = update.message().chat().id();
		String message = update.message().text();
		
		if (message.equals("/start")) {
			return start(chatId);
		} else if (message.equals("/rates")) {
			return rates(chatId);
		}
		return null;
	}
}
