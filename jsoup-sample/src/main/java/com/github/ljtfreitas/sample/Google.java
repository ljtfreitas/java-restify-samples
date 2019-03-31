package com.github.ljtfreitas.sample;

import org.jsoup.nodes.Document;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;

@Path("https://www.google.com.br")
public interface Google {

	@Path("/") @Get
	Document home();
}
