package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class);
	}

	@Autowired
	private SampleApi sampleApi;

	@Override
	public void run(String... arg0) throws Exception {
		String response = sampleApi.get();
		System.out.println(response);
	}
}
