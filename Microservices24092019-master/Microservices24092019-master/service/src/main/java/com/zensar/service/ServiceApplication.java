package com.zensar.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ServiceApplication {
	@Value("${server.instance.name}")
	private String instanceName;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	
	@GetMapping
	public String getMessage() {
		return "<h1> Hello From "+instanceName +"</h1>";
	}

}
