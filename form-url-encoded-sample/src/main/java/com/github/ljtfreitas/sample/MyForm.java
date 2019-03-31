package com.github.ljtfreitas.sample;

import com.github.ljtfreitas.restify.http.contract.Form;
import com.github.ljtfreitas.restify.http.contract.Form.Field;

@Form
class MyForm {

	@Field
	final String name;
	
	@Field("last_name")
	final String lastName;

	MyForm(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
}
