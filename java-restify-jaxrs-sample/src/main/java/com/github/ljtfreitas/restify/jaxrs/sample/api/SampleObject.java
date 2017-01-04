package com.github.ljtfreitas.restify.jaxrs.sample.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleObject {

	@JsonProperty
	private String message;

	public SampleObject(@JsonProperty("message") String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "SampleObject: " + message;
	}
}
