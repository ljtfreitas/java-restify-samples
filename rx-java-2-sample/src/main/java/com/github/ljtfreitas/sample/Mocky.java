package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Path("http://www.mocky.io/v2")
public interface Mocky {

	@Path("/5c9911a93200002c00d90796") @Get
	Single<String> single();

	@Path("/5c9911a93200002c00d90796") @Get
	Maybe<String> maybe();

	@Path("/5c9911a93200002c00d90796") @Get
	Completable completable();

	@Path("/5c9913613200004f00d907a7") @Get
	Observable<String> observable();

	@Path("/5c9913613200004f00d907a7") @Get
	Flowable<String> flowable();
}
