package com.github.ljtfreitas.restify.netflix.sample.client.circuitbreaker;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.github.ljtfreitas.restify.http.netflix.client.call.exec.HystrixCircuitBreakerFallbackEndpointCallExecutableFactory;
import com.github.ljtfreitas.restify.http.netflix.client.call.exec.HystrixCommandFallbackEndpointCallExecutableFactory;
import com.github.ljtfreitas.restify.netflix.sample.api.SampleObject;
import com.github.ljtfreitas.restify.netflix.sample.client.SampleApiWithCircuitBreaker;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HystrixFallbackClient {

	public static void main(String[] args) throws Exception {
		SampleApiFallback fallback = new SampleApiFallback();

		SampleApiWithCircuitBreaker sampleApi = new RestifyProxyBuilder()
				.executables()
						.add(new HystrixCommandFallbackEndpointCallExecutableFactory<Object, Object, SampleApiWithCircuitBreaker>(fallback))
						.add(new HystrixCircuitBreakerFallbackEndpointCallExecutableFactory<Object, Object, SampleApiWithCircuitBreaker>(fallback))
						.and()
					.target(SampleApiWithCircuitBreaker.class, "http://localhost:8090")
						.build();

		HystrixCommand<SampleObject> sampleObjectCommand = sampleApi.get();
		SampleObject sampleObject = sampleObjectCommand.execute();
		System.out.println(sampleObject);

		sampleObject = sampleApi.getOnCircuitBreaker();
		System.out.println(sampleObject);
	}

	private static class SampleApiFallback implements SampleApiWithCircuitBreaker {

		@Override
		public HystrixCommand<SampleObject> get() {
			return new HystrixCommand<SampleObject>(HystrixCommandGroupKey.Factory.asKey("SampleApiFallback")) {
				@Override
				protected SampleObject run() throws Exception {
					return new SampleObject("Hey, i'm fallback!");
				}
			};
		}

		@Override
		public SampleObject getOnCircuitBreaker() {
			return new SampleObject("Hey, i'm fallback!");
		}
	}
}
