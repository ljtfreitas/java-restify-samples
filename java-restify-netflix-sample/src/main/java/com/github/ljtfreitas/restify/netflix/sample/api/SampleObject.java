package com.github.ljtfreitas.restify.netflix.sample.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleObject {

	private String message;

	@Deprecated
	SampleObject() {
	}

	@JsonCreator
	public SampleObject(@JsonProperty("message") String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}

	@Override
	public String toString() {
		return "SampleObject: " + message;
	}
}
