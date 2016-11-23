package com.github.ljtfreitas.restify.sample.client;

import java.util.Optional;
import java.util.function.BiConsumer;

import com.github.ljtfreitas.restify.http.client.Headers;
import com.github.ljtfreitas.restify.http.client.call.EndpointCall;
import com.github.ljtfreitas.restify.http.client.request.async.EndpointCallCallback;
import com.github.ljtfreitas.restify.http.client.request.async.EndpointCallSuccessCallback;
import com.github.ljtfreitas.restify.http.client.response.EndpointResponse;
import com.github.ljtfreitas.restify.http.contract.BodyParameter;
import com.github.ljtfreitas.restify.http.contract.CallbackParameter;
import com.github.ljtfreitas.restify.http.contract.Delete;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Head;
import com.github.ljtfreitas.restify.http.contract.Header;
import com.github.ljtfreitas.restify.http.contract.MultipartParameters;
import com.github.ljtfreitas.restify.http.contract.Options;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.PathParameter;
import com.github.ljtfreitas.restify.http.contract.Post;
import com.github.ljtfreitas.restify.http.contract.Put;
import com.github.ljtfreitas.restify.sample.api.MyApiResponse;

@Path("/api")
public interface MyApi {

	@Path("/{type}")
	@Get
	public Optional<MyApiResponse> getAs(@PathParameter String type);

	@Path("/{type}")
	@Post
	public MyApiResponse postAs(@PathParameter String type);

	@Path("/{type}")
	@Put
	public MyApiResponse putAs(@PathParameter String type);

	@Path("/{type}")
	@Delete
	public MyApiResponse deleteAs(@PathParameter String type);

	@Path("/{type}")
	@Head
	public Headers headAs(@PathParameter String type);

	@Path("/{type}")
	@Options
	public Headers optionsAs(@PathParameter String type);

	@Path("/upload")
	@Post
	@Header(name = "Content-Type", value = "multipart/form-data")
	public String upload(@BodyParameter MultipartParameters parameters);

	@Path("/{type}")
	@Get
	public EndpointResponse<MyApiResponse> getResponseObjectAs(@PathParameter String type);

	@Path("/{type}")
	@Get
	public EndpointCall<MyApiResponse> call(@PathParameter String type);

	@Path("/resource-not-found")
	@Get
	public Optional<String> optional();

	@Path("/{type}")
	@Get
	public void async(@PathParameter String type, @CallbackParameter EndpointCallCallback<MyApiResponse> callback);

	@Path("/{type}")
	@Get
	public void asyncWithConsumerCallback(@PathParameter String type, @CallbackParameter BiConsumer<MyApiResponse, Throwable> callback);

	@Path("/{type}")
	@Get
	public void optionalAsync(@PathParameter String type, @CallbackParameter EndpointCallSuccessCallback<Optional<MyApiResponse>> callback);
}
