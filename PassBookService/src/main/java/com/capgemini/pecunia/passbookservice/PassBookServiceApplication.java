package com.capgemini.pecunia.passbookservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableSwagger2
public class PassBookServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.capgemini.pecunia.passbookservice"))
				.build()
				.apiInfo(myApiInfo());
		
	}
	private ApiInfo myApiInfo()
	{
		return new ApiInfo(
				"SPRING WITH SWAGGER API", 
				"API CREATION", 
				"1.0", 
				"Free to Use", 
				new Contact("Adarsha","/api" ,"Adarsha@capgemini.com"),
				"API licence",
				"/api",
				Collections.emptyList());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PassBookServiceApplication.class, args);
	}

}
