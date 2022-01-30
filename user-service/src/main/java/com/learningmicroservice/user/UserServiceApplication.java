package com.learningmicroservice.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// Creating RestTemplate object to get Department Microservice
	@Bean 		      // to use/autowire in UserService
	@LoadBalanced     // if multiple services connected to ServiceRegistry then it will load balance the requests
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
