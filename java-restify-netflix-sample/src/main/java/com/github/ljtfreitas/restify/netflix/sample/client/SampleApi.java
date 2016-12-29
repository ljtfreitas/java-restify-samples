package com.github.ljtfreitas.restify.netflix.sample.client;

import com.github.ljtfreitas.restify.http.contract.BodyParameter;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.Post;
import com.github.ljtfreitas.restify.netflix.sample.api.SampleObject;

@Path("/api")
public interface SampleApi {

	@Path("/sample")
	@Get
	public SampleObject get();

	@Path("/sample")
	@Post
	public SampleObject send(@BodyParameter SampleObject sampleObject);
}
