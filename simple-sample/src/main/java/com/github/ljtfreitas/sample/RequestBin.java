package com.github.ljtfreitas.sample;

import java.util.concurrent.CompletableFuture;

import com.github.ljtfreitas.restify.http.client.call.async.EndpointCallSuccessCallback;
import com.github.ljtfreitas.restify.http.client.response.EndpointResponse;
import com.github.ljtfreitas.restify.http.contract.CallbackParameter;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Header;
import com.github.ljtfreitas.restify.http.contract.HeaderParameter;
import com.github.ljtfreitas.restify.http.contract.Path;

@Path("https://enilssm7uq9z.x.pipedream.net")
public interface RequestBin {

	@Path("/sample") @Get
	String sample();

	@Path("/async") @Get
	CompletableFuture<String> async();

	@Path("/callback") @Get
	void callback(@CallbackParameter EndpointCallSuccessCallback<String> success);

	@Path("/response") @Get
	EndpointResponse<String> response();

	@Path("/header") @Get
	@Header(name = "X-Header-1", value = "header-1")
	@Header(name = "X-Header-2", value = "header-2")
	String header(@HeaderParameter("X-Header-3") String header);
}
