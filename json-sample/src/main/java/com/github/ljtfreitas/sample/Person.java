package com.github.ljtfreitas.sample;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
class Person {

	@JsonProperty
	String name;

	@JsonProperty("last_name")
	String lastName;

	@JsonProperty
	Integer age;

	@JsonProperty
	Person wife;

	@JsonProperty
	Collection<String> pets;

	@JsonCreator
	Person(@JsonProperty("name") String name, @JsonProperty("last_name") String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
}
