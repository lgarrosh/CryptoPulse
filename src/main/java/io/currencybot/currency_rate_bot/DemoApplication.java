package io.currencybot.currency_rate_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		SpringApplication.run(DemoApplication.class, args);
		

//		Mono<String> responseMonoString = WebClientConfig.getRequest("https://jsonplaceholder.typicode.com/posts/1");
//		
//		responseMonoString.subscribe(System.out::println);
		
	}
}
