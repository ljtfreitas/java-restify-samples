package com.github.ljtfreitas.sample;

import java.util.Map;

import com.github.ljtfreitas.restify.http.client.message.converter.form.FormObjectParameterSerializer;
import com.github.ljtfreitas.restify.http.contract.BodyParameter;
import com.github.ljtfreitas.restify.http.contract.FormURLEncoded;
import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Parameters;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.Post;
import com.github.ljtfreitas.restify.http.contract.QueryParameter;
import com.github.ljtfreitas.restify.http.contract.QueryParameters;

@Path("https://enilssm7uq9z.x.pipedream.net")
public interface RequestBin {

	@Path("/parameters") @Get
	String simple(@QueryParameter("name") String name, @QueryParameter("last_name") String lastName);

	@Path("/parameters") @Get
	String map(@QueryParameters Map<String, String> parameters);

	@Path("/parameters") @Get
	String parameters(@QueryParameters Parameters parameters);

	@Path("/parameters") @Get
	String formObject(@QueryParameters(serializer = FormObjectParameterSerializer.class) MyForm myForm);
	
	@Path("/parameters") @Post
	@FormURLEncoded
	String postWithMap(@BodyParameter Map<String, String> parameters);
	
	@Path("/parameters") @Post
	@FormURLEncoded
	String postWithParameters(@BodyParameter Parameters parameters);

	@Path("/parameters") @Post
	@FormURLEncoded
	String postWithFormObject(@BodyParameter MyForm myForm);
}
