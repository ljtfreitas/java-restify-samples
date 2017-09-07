package com.github.ljtfreitas.restify.hateoas.sample;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class UserResource extends ResourceSupport {

	@JsonUnwrapped
	private final User user;

	public UserResource(User user) {
		this.user = user;
	}
}
