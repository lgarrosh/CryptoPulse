package io.currencybot.currency_rate_bot.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pengrad.telegrambot.model.Update;

import io.currencybot.currency_rate_bot.service.TelegramBotService;

@RestController
public class RestControllerWhebHook {
	
	@Autowired
	private TelegramBotService service;

	private static final Logger log = LoggerFactory.getLogger(RestControllerWhebHook.class);

	public RestControllerWhebHook() {
		log.info("RestApiWhebHook been created");
	}

	@PostMapping("webhook")
	public void telegramDataUpdate(@RequestBody String updateJson) {
		try {
			Gson gson = new Gson();
			Update update = gson.fromJson(updateJson, Update.class);
			
			if (update != null && update.message() != null) {
				service.processing(update);
			} else {
				log.info("Получено пустое обновление");
			}
		} catch (Exception e) {
			log.info("Получено неожидаемое сообщение от телеграм: " + e.toString());
			// TODO: handle exception
		}
	}
}
