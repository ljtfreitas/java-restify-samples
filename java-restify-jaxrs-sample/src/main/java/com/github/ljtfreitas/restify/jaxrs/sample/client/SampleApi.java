package com.github.ljtfreitas.restify.jaxrs.sample.client;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.ljtfreitas.restify.http.client.Headers;
import com.github.ljtfreitas.restify.jaxrs.sample.api.SampleObject;

@ApplicationPath("/rest")
@Produces(MediaType.APPLICATION_JSON)
public interface SampleApi {

	@Path("/sample")
	@GET
	public SampleObject get();

	@Path("/sample")
	@GET
	public SampleObject get(@QueryParam("name") String name, @HeaderParam("X-App-Name") String appName);

	@Path("/sample")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public SampleObject post(SampleObject sampleObject);

	@Path("/sample")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public SampleObject put(SampleObject sampleObject);

	@Path("/sample")
	@DELETE
	public SampleObject delete();

	@Path("/sample")
	@HEAD
	public Headers head();
}
