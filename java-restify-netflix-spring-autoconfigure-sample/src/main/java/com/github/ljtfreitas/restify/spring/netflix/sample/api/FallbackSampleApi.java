package com.github.ljtfreitas.restify.spring.netflix.sample.api;

import org.springframework.stereotype.Service;

import com.github.ljtfreitas.restify.spring.netflix.autoconfigure.hystrix.RestifyFallback;

@Service
@RestifyFallback
public class FallbackSampleApi implements SampleApi {

	@Override
	public String get() {
		return "Hey, i'm a fallback!";
	}

	@Override
	public String throwError() {
		return "Hey, i'm a [throwError] fallback!";
	}

}
