package com.github.ljtfreitas.restify.netflix.sample.client.circuitbreaker;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.github.ljtfreitas.restify.http.netflix.client.call.exec.HystrixCircuitBreakerEndpointCallExecutableFactory;
import com.github.ljtfreitas.restify.http.netflix.client.call.exec.HystrixCommandEndpointCallExecutableFactory;
import com.github.ljtfreitas.restify.netflix.sample.api.SampleObject;
import com.github.ljtfreitas.restify.netflix.sample.client.SampleApiWithCircuitBreaker;
import com.netflix.hystrix.HystrixCommand;

public class HystrixClient {

	public static void main(String[] args) throws Exception {
		SampleApiWithCircuitBreaker sampleApi = new RestifyProxyBuilder()
				.executables()
						.add(new HystrixCommandEndpointCallExecutableFactory<Object, Object>())
						.add(new HystrixCircuitBreakerEndpointCallExecutableFactory<Object, Object>())
						.and()
					.target(SampleApiWithCircuitBreaker.class, "http://localhost:8090")
						.build();

		HystrixCommand<SampleObject> sampleObjectCommand = sampleApi.get();
		SampleObject sampleObject = sampleObjectCommand.execute();
		System.out.println(sampleObject);

		sampleObject = sampleApi.getOnCircuitBreaker();
		System.out.println(sampleObject);
	}
}
