package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// open https://pipedream.com/r/enilssm7uq9z and run
		
		RequestBin requestBin = new RestifyProxyBuilder()
				.target(RequestBin.class)
					.build();

		// GET https://enilssm7uq9z.x.pipedream.net/sample
		System.out.println(requestBin.sample()
							.map(result -> "simple request (with try): " + result)
							.get());

		// GET https://enilssm7uq9z.x.pipedream.net/lazy
		System.out.println(requestBin.lazy()
							.map(result -> "simple request (with lazy): " + result)
							.get());

		// GET https://enilssm7uq9z.x.pipedream.net/option
		System.out.println(requestBin.option()
							.map(result -> "simple request (with option): " + result)
							.get());

		// GET https://enilssm7uq9z.x.pipedream.net/future (async)
		System.out.println(requestBin.future()
							.map(result -> "simple request (with future): " + result)
							.get());

		// wait async requests
		Thread.sleep(1000);
	}
}
