package davidxxx.microservicewithconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WhatToDoServiceApplication {

	@LoadBalanced
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(WhatToDoServiceApplication.class, args);
	}

}