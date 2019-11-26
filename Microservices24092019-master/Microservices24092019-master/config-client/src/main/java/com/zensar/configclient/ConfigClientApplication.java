package com.zensar.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigClientApplication {
	
	@Autowired
	private ConfigClientConfiguration property;
	
	
	@Value("${some.other.property}")
	private String someOtherProperty;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@GetMapping
	public String printMessage() {
		
		
		StringBuffer sb=new StringBuffer();
		
		sb.append(property.getProperty());
		
		sb.append(" || ");
		
		sb.append(someOtherProperty);
		
		return sb.toString();
	}

}
