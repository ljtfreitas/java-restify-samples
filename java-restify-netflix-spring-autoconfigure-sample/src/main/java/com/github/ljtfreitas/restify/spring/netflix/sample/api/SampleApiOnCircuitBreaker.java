package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.web.bind.annotation.GetMapping;

import com.github.ljtfreitas.restify.http.netflix.client.request.circuitbreaker.OnCircuitBreaker;
import com.github.ljtfreitas.restify.spring.configure.Restifyable;
import com.netflix.hystrix.HystrixCommand;

@Restifyable(name = "sample-api", endpoint = "http://sample-api")
public interface SampleApiOnCircuitBreaker {

	@GetMapping("/api/sample")
	@OnCircuitBreaker
	public String get();

	@GetMapping("/api/sample")
	public HystrixCommand<String> getAsHystrixCommand();

}
