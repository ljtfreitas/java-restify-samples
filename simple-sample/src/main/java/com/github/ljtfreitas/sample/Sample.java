package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// open https://pipedream.com/r/enilssm7uq9z and run
		
		RequestBin requestBin = new RestifyProxyBuilder()
				.target(RequestBin.class)
					.build();

		// GET https://enilssm7uq9z.x.pipedream.net/sample
		System.out.println("simple request: " + requestBin.sample());

		// GET https://enilssm7uq9z.x.pipedream.net/async (async)
		requestBin.async()
			.thenAccept(result -> System.out.println("simple async request: " + result));

		// GET https://enilssm7uq9z.x.pipedream.net/callback (async)
		requestBin.callback(result -> System.out.println("simple async request, with callback: " + result));

		// GET https://enilssm7uq9z.x.pipedream.net/response (full response: status code, headers and body)
		System.out.println("full response: " + requestBin.response());

		// GET https://enilssm7uq9z.x.pipedream.net/response (with custom headers)
		System.out.println("simple request (with custom headers): " + requestBin.header("whatever"));

		// wait async requests
		Thread.sleep(1000);
	}
}
