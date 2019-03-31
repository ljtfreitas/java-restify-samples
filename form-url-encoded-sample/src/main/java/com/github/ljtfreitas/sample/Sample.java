package com.github.ljtfreitas.sample;

import java.util.LinkedHashMap;
import java.util.Map;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.github.ljtfreitas.restify.http.contract.Parameters;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// open https://pipedream.com/r/enilssm7uq9z and run

		RequestBin requestBin = new RestifyProxyBuilder()
				.target(RequestBin.class)
					.build();

		// GET https://enilssm7uq9z.x.pipedream.net/parameters
		System.out.println("simple request with parameters: " + requestBin.simple("Tiago de Freitas", "Lima"));

		// GET https://enilssm7uq9z.x.pipedream.net/parameters
		Map<String, String> parametersAsMap = new LinkedHashMap<>();
		parametersAsMap.put("name", "Tiago de Freitas");
		parametersAsMap.put("last_name", "Lima");

		System.out.println("simple request with parameters (as map): " + requestBin.map(parametersAsMap));

		// GET https://enilssm7uq9z.x.pipedream.net/parameters
		Parameters parameters = new Parameters() //immutable
			.put("name", "Tiago de Freitas")
			.put("last_name", "Lima");

		System.out.println("simple request with parameters (as parameters): " + requestBin.parameters(parameters));

		// GET https://enilssm7uq9z.x.pipedream.net/parameters
		MyForm myForm = new MyForm("Tiago de Freitas", "Lima");

		System.out.println("simple request with parameters (as form object): " + requestBin.formObject(myForm));

		// POST https://enilssm7uq9z.x.pipedream.net/parameters
		System.out.println("simple post request with parameters (as map): " + requestBin.postWithMap(parametersAsMap));
		
		// POST https://enilssm7uq9z.x.pipedream.net/parameters
		System.out.println("simple post request with parameters (as parameters): " + requestBin.postWithParameters(parameters));

		// POST https://enilssm7uq9z.x.pipedream.net/parameters
		System.out.println("simple post request with parameters (as form object): " + requestBin.postWithFormObject(myForm));
	}
}
