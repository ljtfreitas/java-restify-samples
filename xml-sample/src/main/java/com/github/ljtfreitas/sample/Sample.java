package com.github.ljtfreitas.sample;

import java.util.Arrays;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// open https://pipedream.com/r/enilssm7uq9z and run

		RequestBin requestBin = new RestifyProxyBuilder()
				.target(RequestBin.class)
					.build();

		Person person = new Person();
		person.name = "Tiago de Freitas";
		person.lastName = "Lima";
		
		Person wife = new Person();
		wife.name = "Tatiana Gomes";
		wife.lastName = "da Silva";
		person.wife = wife;

		person.age = 33;
		person.pets = Arrays.asList("Zulu", "Mosquito", "Toia");

		// POST https://enilssm7uq9z.x.pipedream.net/person
		System.out.println("simple xml post request: " + requestBin.person(person));
	}
}
