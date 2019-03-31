package com.github.ljtfreitas.sample;

import org.jsoup.nodes.Document;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		Google google = new RestifyProxyBuilder()
				.target(Google.class)
					.build();

		// GET https://www.google.com.br/
		Document home = google.home();

		System.out.println(home);
		System.out.println(home.head());
	}
}
