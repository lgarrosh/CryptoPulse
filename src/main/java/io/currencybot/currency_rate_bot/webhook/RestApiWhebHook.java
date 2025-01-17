package io.currencybot.currency_rate_bot.webhook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("webhook")
public class RestApiWhebHook {

    private static final Logger log = LoggerFactory.getLogger(RestApiWhebHook.class);

    
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    
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
}

