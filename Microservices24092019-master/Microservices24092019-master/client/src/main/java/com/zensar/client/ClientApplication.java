package com.zensar.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ClientApplication {
	
	@Autowired
	public RestTemplateBuilder builder;
	
	//@Autowired
	//public EurekaClient client;
	
	@Autowired
	public DiscoveryClient client;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@GetMapping
	public String getMessage() {
		
		RestTemplate template = builder.build();
		
		//InstanceInfo info = client.getNextServerFromEureka("service", false);
		
		List<ServiceInstance> instances = client.getInstances("service");
		
		
		//URI uri = instances.get(0).getUri();
		
		String url=instances.get(0).getUri().toString();
		
		
		// String url=info.getHomePageUrl();
		
		ResponseEntity<String> exchange = template.exchange(url, HttpMethod.GET, null, String.class);
		
		return exchange.getBody();
	}

}
