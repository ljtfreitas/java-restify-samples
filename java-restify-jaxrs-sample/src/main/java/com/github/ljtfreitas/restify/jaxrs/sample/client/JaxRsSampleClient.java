package com.github.ljtfreitas.restify.jaxrs.sample.client;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.github.ljtfreitas.restify.http.jaxrs.contract.JaxRsContractReader;
import com.github.ljtfreitas.restify.jaxrs.sample.api.SampleObject;

public class JaxRsSampleClient {

	public static void main(String[] args) throws Exception {
		SampleApi sampleApi = new RestifyProxyBuilder()
			.contract(new JaxRsContractReader())
				.target(SampleApi.class, "http://localhost:8080")
					.build();

		System.out.println(sampleApi.get());

		System.out.println(sampleApi.get("Tiago de Freitas Lima", "Sample-Restify-JAXRS-Client"));

		System.out.println(sampleApi.post(new SampleObject("Hello, i'm Restify JAX-RS client!")));

		System.out.println(sampleApi.put(new SampleObject("Hello, i'm Restify JAX-RS client!")));

		System.out.println(sampleApi.delete());

		System.out.println(sampleApi.head());
	}
}
