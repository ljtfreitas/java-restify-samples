package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.web.bind.annotation.GetMapping;

import com.github.ljtfreitas.restify.http.netflix.client.request.circuitbreaker.OnCircuitBreaker;
import com.github.ljtfreitas.restify.spring.configure.Restifyable;

@Restifyable(name = "sample-api", endpoint = "http://sample-api")
public interface SampleApi {

	@GetMapping("/api/sample")
	public String get();

	@GetMapping("/api/error")
	@OnCircuitBreaker
	public String throwError();

}
