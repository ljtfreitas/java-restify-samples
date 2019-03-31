package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;

import io.vavr.Lazy;
import io.vavr.concurrent.Future;
import io.vavr.control.Option;
import io.vavr.control.Try;

@Path("https://enilssm7uq9z.x.pipedream.net")
public interface RequestBin {

	@Path("/sample") @Get
	Try<String> sample();

	@Path("/lazy") @Get
	Lazy<String> lazy();

	@Path("/option") @Get
	Option<String> option();

	@Path("/future") @Get
	Future<String> future();
}
