package com.github.ljtfreitas.sample;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;

public class Sample {

	public static void main(String[] args) throws InterruptedException {		
		RequestBin requestBin = new RestifyProxyBuilder()
				.target(RequestBin.class)
					.build();

		FutureCallback<String> callback = new FutureCallback<String>() {
			@Override
			public void onSuccess(@Nullable String result) {
				System.out.println("simple request: " + result);
			}

			@Override
			public void onFailure(Throwable throwable) {
				throwable.printStackTrace();
			}
		};

		// GET https://enilssm7uq9z.x.pipedream.net/listenable-future
		Futures.addCallback(requestBin.future(), callback, MoreExecutors.directExecutor());

		// GET https://enilssm7uq9z.x.pipedream.net/listenable-future/callback
		requestBin.callback(callback);

		// GET https://enilssm7uq9z.x.pipedream.net/listenable-future/task
		Futures.addCallback(requestBin.task(), callback, MoreExecutors.directExecutor());
		
		System.out.println("simple request (with optional): " + requestBin.optional());

		// wait async requests
		Thread.sleep(1500);
	}
}
