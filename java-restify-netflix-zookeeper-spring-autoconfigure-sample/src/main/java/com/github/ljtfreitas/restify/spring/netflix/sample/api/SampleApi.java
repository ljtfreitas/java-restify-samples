package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.web.bind.annotation.GetMapping;

import com.github.ljtfreitas.restify.spring.configure.Restifyable;

@Restifyable(name = "sample-zookeeper-api", endpoint = "http://sample-zookeeper-api")
public interface SampleApi {

	@GetMapping("/api/sample")
	public String get();

}
