package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

	@GetMapping("/sample")
	public String get() {
		return "Hello, Restify!";
	}

	@GetMapping("/error")
	public void error() {
		throw new RuntimeException("Internal server error");
	}
}
