package com.github.ljtfreitas.restify.jaxrs.sample.api;

import java.time.Instant;

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
import javax.ws.rs.core.Response;


@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleController {

	@GET
	public SampleObject get(@QueryParam("name") String name, @HeaderParam("X-App-Name") String appName) {
		return new SampleObject("Hello, i'm a JAX-RS resource (provided with GET verb)! "
				+ "Your [name] query parameter is: " + name + ", and your [X-App-Name] header is: " + appName);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public SampleObject post(SampleObject sampleObject) {
		return new SampleObject("Hello, i'm a JAX-RS resource (provided with POST verb)! Original message is: " + sampleObject.getMessage());
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public SampleObject put(SampleObject sampleObject) {
		return new SampleObject("Hello, i'm a JAX-RS resource (provided with PUT verb)! Original message is: " + sampleObject.getMessage());
	}

	@DELETE
	public SampleObject delete() {
		return new SampleObject("Hello, i'm a JAX-RS resource (provided with DELETE verb)!");
	}

	@HEAD
	public Response head() {
		return Response.status(200).header("X-MyJsonApi-Timestamp", Instant.now().toEpochMilli()).build();
	}
}
