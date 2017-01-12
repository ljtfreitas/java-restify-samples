package com.github.ljtfreitas.restify.cdi.sample;

import static br.com.caelum.vraptor.view.Results.json;

import javax.inject.Inject;

import com.github.ljtfreitas.restify.cdi.sample.GithubApi.Repository;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Head;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path("/github")
public class GithubController {

	@Inject
	private GithubApi githubApi;

	@Inject
	private Result result;

	@Get("/{owner}/{project}")
	@Head
	public void get(String owner, String project) {
		Repository repository = githubApi.findRepository(owner, project);

		result.use(json()).withoutRoot().from(repository).serialize();
	}
}
