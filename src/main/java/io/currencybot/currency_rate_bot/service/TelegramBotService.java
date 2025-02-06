package io.currencybot.currency_rate_bot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import io.currencybot.currency_rate_bot.model.coin_market_cap.RequestedCryptocurrency;
import io.currencybot.currency_rate_bot.model.crb.Currency;

@Service
public class TelegramBotService {
	
	private static final Logger log = LoggerFactory.getLogger(TelegramBotService.class);
	
	private static final String NAMINAL_STRING = "USD";
	
	private static final String BUTTON1_TEXT = "Get a cryptocurrency rate";
	private static final String BUTTON2_TEXT = "Get exchange rate";
	private static final String START_COMMAND = "/start";
	
	@Autowired
	private TelegramBot bot;
	
	@Autowired
	private CrbCurrencyRates crbCurrencyRates;
	
	@Autowired
	private CoinMarketCapComponent coinMarketCapComponent;
	
	public void processing(Update update) {
		Long chatId = update.message().chat().id();
		String message = update.message().text();

		
		BaseResponse baseResponse = commandControl(update);
		if (baseResponse != null) {
			log.info(baseResponse.isOk() ? "Успешно" : "Ошибка");
		} else {
			SendMessage request = new SendMessage(chatId, message);
			log.info(bot.execute(request).isOk() ? "Успешно" : "Ошибка");
		}
	}
	
	private BaseResponse start(Long chatId) {
//		SendMessage request = new SendMessage(chatId, "bot started");
		return sendReplyKeyboardMarkup(chatId);
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
	
	private BaseResponse cryptoRates(Long chatId) {
		List<RequestedCryptocurrency> rates = coinMarketCapComponent.getRates();
		String ratesInfo = new String();
		for (RequestedCryptocurrency currency : rates) {
			if (!ratesInfo.isEmpty()) {
				ratesInfo += '\n';
			}
			ratesInfo += String.join("  -  ", currency.getSymbol(), String.format("%1$,.2f", (currency.getQuote().get(NAMINAL_STRING).getPrice()))).concat(" $     (" + currency.getName() + ")");
		}
		SendMessage request = new SendMessage(chatId, ratesInfo);
		return bot.execute(request);
	}
	
	private BaseResponse commandControl(Update update) {
		Long chatId = update.message().chat().id();
		String message = update.message().text();
		
		if (message.equals(START_COMMAND)) {
			return start(chatId);
		} else if (message.equals(BUTTON1_TEXT)) {
			return cryptoRates(chatId);
		} else if (message.equals(BUTTON2_TEXT)) {
			return rates(chatId);
		}
		return null;
	}
	
	private BaseResponse sendReplyKeyboardMarkup(Long chatId) {
		KeyboardButton button1 = new KeyboardButton(BUTTON1_TEXT);
        KeyboardButton button2 = new KeyboardButton(BUTTON2_TEXT);

        // Создаем клавиатуру
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup(
                new KeyboardButton[]{button1, button2}
        ).resizeKeyboard(true); // Делаем кнопки адаптивными

        // Отправляем сообщение с клавиатурой
        SendMessage request = new SendMessage(chatId, "Выберите кнопку")
                .replyMarkup(keyboard);
        return bot.execute(request);
	}
}
