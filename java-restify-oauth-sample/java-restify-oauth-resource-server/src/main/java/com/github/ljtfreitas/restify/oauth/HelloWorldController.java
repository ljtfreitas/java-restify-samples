package com.github.ljtfreitas.restify.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello(Authentication authentication) {
		return "hello, " + authentication.getName();
	}
}
