package io.currencybot.currency_rate_bot;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

@RestController
public class RestApiWhebHook {
	
	@Autowired
	private TelegramBot bot;

    private static final Logger log = LoggerFactory.getLogger(RestApiWhebHook.class);
    
    @GetMapping("hello")
    String helloWorld() {
        return ("Hello World!!!");
    }

    public RestApiWhebHook() {
        log.info("RestApiWhebHook been created");
    }

    @PostMapping("post")
    public String handleWebhook(@RequestBody String payload) {
        log.info("Received payload: " + payload);
        return "Webhook received!";
    }
    
    @PostMapping("webhook")
    public String telegramDataUpdate(@RequestBody String updateJson) throws JsonMappingException, JsonProcessingException {
		Gson gson = new Gson();
		Update update = gson.fromJson(updateJson, Update.class);
		
		if (update != null && update.message() != null) {
			Long chatId = update.message().chat().id();
			String message = update.message().text();
			
			SendMessage request = new SendMessage(chatId, message);
			BaseResponse baseResponse = bot.execute(request);
			System.out.println(baseResponse.isOk());
		}
        return "Webhook received!";
    }
}

