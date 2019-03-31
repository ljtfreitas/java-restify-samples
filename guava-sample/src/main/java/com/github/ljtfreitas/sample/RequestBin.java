package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.contract.CallbackParameter;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

@Path("https://enilssm7uq9z.x.pipedream.net")
public interface RequestBin {

	@Path("/listenable-future") @Get
	ListenableFuture<String> future();

	@Path("/listenable-future/callback") @Get
	void callback(@CallbackParameter FutureCallback<String> callback);
	
	@Path("/listenable-future/task") @Get
	ListenableFutureTask<String> task();

	@Path("/option") @Get
	Optional<String> optional();
}
