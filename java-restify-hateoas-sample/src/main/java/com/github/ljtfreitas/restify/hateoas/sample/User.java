package com.github.ljtfreitas.restify.hateoas.sample;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty
	private final String name;

	@JsonProperty("birth_date")
	private final Date birthDate;

	@JsonCreator
	public User(@JsonProperty("name") String name, @JsonProperty("birth_date") Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}
}
