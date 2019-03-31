package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.contract.BodyParameter;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.Post;
import com.github.ljtfreitas.restify.http.contract.XmlContent;

@Path("https://enilssm7uq9z.x.pipedream.net")
public interface RequestBin {

	@Path("/person") @Post
	@XmlContent
	String person(@BodyParameter Person person);

}
