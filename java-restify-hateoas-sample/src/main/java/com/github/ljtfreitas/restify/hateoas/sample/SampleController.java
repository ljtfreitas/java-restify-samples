package com.github.ljtfreitas.restify.hateoas.sample;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/")
	public UserResource show() {
		UserResource resource = new UserResource(new User("Tiago de Freitas Lima", Date.valueOf(LocalDate.of(1985, 7, 2))));

		resource.add(linkTo(methodOn(SampleController.class).show()).withSelfRel());
		resource.add(linkTo(methodOn(SampleController.class).friends("")).withRel("friends").expand("tiago"));

		return resource;
	}

	@GetMapping("/{user}/friends")
	public Collection<User> friends(String user) {
		return Arrays.asList(new User("Tatiana Gomes da Silva", Date.valueOf(LocalDate.of(1983, 10, 5))));
	}
}
