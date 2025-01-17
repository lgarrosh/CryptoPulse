package io.currencybot.currency_rate_bot.webhook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import io.currencybot.currency_rate_bot.WebClientConfig;
import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@Component
public class WebhookManager {
	
	private static final Logger log = LoggerFactory.getLogger(WebhookManager.class);
	
	@Autowired
	private NgrokService ngrokService;
	@Autowired
	private WebClientConfig webClientConfig;
	
	public WebhookManager() {
		log.info("WebhookManager create been");
	}

	@PostConstruct
	public void setWebhook() {
		String publicUrl = ngrokService.startNgrok(8080);
		try {
			@SuppressWarnings("deprecation")
			Mono<String> responseMono = webClientConfig.getRequest(UriComponentsBuilder
		            .fromHttpUrl("/setWebhook")
		            .queryParam("url", publicUrl)
		            .build()
		            .toString());
			responseMono.subscribe(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("ngrok url: " + publicUrl);
	}
	
	@EventListener(ContextClosedEvent.class)
	public void disroyWebhookAndNgrok() {
		ngrokService.stopNgrok();
//		webClientConfig.getRequest("/deleteWebhook").subscribe(log::info);
		log.info("webhook distroy");
	}
}

