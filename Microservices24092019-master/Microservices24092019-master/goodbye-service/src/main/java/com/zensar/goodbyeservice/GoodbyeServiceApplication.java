package com.zensar.goodbyeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class GoodbyeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodbyeServiceApplication.class, args);
	}
	
	@GetMapping
	public String sayGoodBye() {
		return " Good Bye  !!!";
	}

}
