package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class RunController {

	@Autowired
	private SampleApi sampleApi;

	@GetMapping
	public String run() {
		return sampleApi.get();
	}
}
