package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class);
	}

}
