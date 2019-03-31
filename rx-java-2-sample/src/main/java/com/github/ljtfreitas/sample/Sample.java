package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

public class Sample {

	public static void main(String[] args) throws InterruptedException {		
		Mocky mocky = new RestifyProxyBuilder()
				.target(Mocky.class)
					.build();

		// GET http://www.mocky.io/v2/5c9911a93200002c00d90796
		mocky.single()
			.subscribe(result -> System.out.println("simple request (with single): " + result));

		// GET http://www.mocky.io/v2/5c9911a93200002c00d90796
		mocky.maybe()
			.subscribe(result -> System.out.println("simple request (with maybe): " + result));

		// GET http://www.mocky.io/v2/5c9911a93200002c00d90796
		mocky.completable()
			.subscribe(() -> System.out.println("simple request (with completable): ok..."));

		// GET http://www.mocky.io/v2/5c9913613200004f00d907a7
		mocky.observable()
			.subscribe(result -> System.out.println("simple request (with observable): " + result));

		// GET http://www.mocky.io/v2/5c9913613200004f00d907a7
		mocky.flowable()
			.subscribe(result -> System.out.println("simple request (with flowable): " + result));

		// wait async requests
		Thread.sleep(2000);
	}
}
