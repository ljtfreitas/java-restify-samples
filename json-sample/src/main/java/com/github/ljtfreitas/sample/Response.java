package com.github.ljtfreitas.sample;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Response {

	@JsonAnySetter
	Map<String, Object> fields = new HashMap<>();
	
	@Override
	public String toString() {
		return fields.toString();
	}
}
