package com.github.ljtfreitas.restify.netflix.sample.client;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.netflix.client.request.circuitbreaker.OnCircuitBreaker;
import com.github.ljtfreitas.restify.netflix.sample.api.SampleObject;
import com.netflix.hystrix.HystrixCommand;

@Path("/api")
public interface SampleApiWithCircuitBreaker {

	@Path("/sample")
	@Get
	public HystrixCommand<SampleObject> get();

	@Path("/sample")
	@Get
	@OnCircuitBreaker
	public SampleObject getOnCircuitBreaker();

}
