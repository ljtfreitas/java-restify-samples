package com.github.ljtfreitas.restify.cdi.sample;

import com.github.ljtfreitas.restify.cdi.Restifyable;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.google.gson.annotations.SerializedName;

@Restifyable
@Path("https://api.github.com")
public interface GithubApi {

	@Path("/repos/{owner}/{repository}")
	@Get
	public Repository findRepository(String owner, String repository);

	public static class Repository {
		String id;

		String name;

		@SerializedName("full_name")
		String fullName;
	}
}
